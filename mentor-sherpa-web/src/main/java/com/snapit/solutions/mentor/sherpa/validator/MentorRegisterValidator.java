/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.validator;

import com.snapit.solutions.mentor.sherpa.model.MentorRegisterForm;
import com.snapit.solutions.mentor.sherpa.model.RegisterForm;
import com.snapit.solutions.mentor.sherpa.model.StudentRegisterForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Component
public class MentorRegisterValidator extends RegisterValidator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MentorRegisterForm.class.isAssignableFrom(clazz);
    }
//    @Override
//    public void validate(Object target, Errors errors) {
//        MentorRegisterForm registerForm = (MentorRegisterForm) target;
//        
//            
//        String password = registerForm.getPassword();
//        String confirmPassword = registerForm.getConfirmPassword();
//        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "registerForm.firstName.empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "registerForm.lastName.empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "registerForm.emailId.empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "registerForm.password.empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "registerForm.confPassword.empty");
//        
//        if (errors.hasErrors()) {
//         return;   
//        }
//        
//        if(!registerForm.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
//            errors.rejectValue("emailId", "registerForm.emailId.invalid");
//        }
//        //Business validation
//        if (!password.equals(confirmPassword)) {
//            errors.rejectValue("password","registerForm.password.missMatch");
//        }
//    }
}
