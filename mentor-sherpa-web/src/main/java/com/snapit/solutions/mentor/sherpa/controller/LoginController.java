/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.entity.PasswordResetToken;
import com.snapit.solutions.mentor.sherpa.exception.UserNotFoundException;
import com.snapit.solutions.securtiy.entity.User;
import com.snapit.solutions.securtiy.service.UserService;
import com.snapit.solutions.web.mail.AppMailSender;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private AppMailSender mailSender;
    static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(11);
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(Model model) {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Model model) {
        return new ModelAndView("accessDenied");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "logout";
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public String forgot() {
        return "forgot";
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public String resetPassword(
            HttpServletRequest request, @RequestParam("email") String userEmail, RedirectAttributes redirectAttributes) {

        User user = userService.findByUserId(userEmail);
        if (user == null) {
            redirectAttributes.addFlashAttribute("alertMessage", "Have you registered with this email id - " + userEmail + "? </br> Please try again.");
            return "redirect:/forgot";
//            throw new UserNotFoundException();
        }

        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        String appUrl
                = "http://" + request.getServerName()
                + ":" + request.getServerPort()
                + request.getContextPath();
        SimpleMailMessage email
                = constructResetTokenEmail(appUrl, request.getLocale(), token, user);
        mailSender.send(email);
        redirectAttributes.addFlashAttribute("successMessage", "Click on the link in the email to reset your password.");
        return "redirect:/login";
    }

    private SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "/changePassword?id=" + user.getId().toString() + "&token=" + token;
        String message = "Please click the link below to reset your password. The Token expires in 24hours.";//messages.getMessage("message.resetPassword", null, locale);
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Reset Password");
        email.setText(message + " <br/>" + url);
        email.setFrom("info@snapit.solutions");
        return email;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String showChangePasswordPage(
            Locale locale, Model model, @RequestParam("id") String id, @RequestParam("token") String token, RedirectAttributes redirectAttributes) {

        PasswordResetToken passToken = userService.getPasswordResetToken(id, token);
        User user;
        if (passToken == null) {// || user.getId().equals(id) != id) {
//            String message = messages.getMessage("auth.message.invalidToken", null, locale);
            redirectAttributes.addFlashAttribute("alertMessage", "Invalid Action. Please try to Reset your password by clicking Forgot your Password link.");
            return "redirect:/login";
        } else {
            user = passToken.getUser();
            if (!user.getId().equals(new ObjectId(id))) {
                redirectAttributes.addFlashAttribute("alertMessage", "Invalid Action. Please try to Reset your password by clicking Forgot your Password link.");
                return "redirect:/login";
            }
        }

        Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            redirectAttributes.addFlashAttribute("alertMessage", "Your Token has Expired.");//messages.getMessage("auth.message.expired", null, locale));
            return "redirect:/login";
        }

        Authentication auth = new UsernamePasswordAuthenticationToken(
                user, null);//, userDetailsService.loadUserByUsername(user.getEmail()).getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:updatePassword";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    public String updatePassword() {
        return "updatePassword";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
//@PreAuthorize("hasRole('READ_PRIVILEGE')")
    public String savePassword(Locale locale, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        User user;
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            userService.changePassword(user, PASSWORD_ENCODER.encode(password));
            redirectAttributes.addFlashAttribute("successMessage", "Password was saved Successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("alertMessage", "There was an error processing your password update. Please try again.");
        }
        return "redirect:/login";
    }
}
