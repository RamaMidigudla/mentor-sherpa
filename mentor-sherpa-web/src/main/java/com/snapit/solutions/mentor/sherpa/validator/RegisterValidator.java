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
public class RegisterValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return (MentorRegisterForm.class.isAssignableFrom(clazz) || StudentRegisterForm.class.isAssignableFrom(clazz));
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        RegisterForm registerForm = null;
        if (target instanceof MentorRegisterForm) {
            registerForm = (MentorRegisterForm) target;
        } else if (target instanceof StudentRegisterForm) {
            registerForm = (StudentRegisterForm) target;
        }
        
        if (registerForm != null) {
            
        String password = registerForm.getPassword();
        String confirmPassword = registerForm.getConfirmPassword();
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "registerForm.firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "registerForm.lastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "registerForm.emailId.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "registerForm.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "registerForm.confPassword.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "registerForm.dateOfBirth.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "registerForm.phoneNumber.empty");
        ValidationUtils.rejectIfEmpty(errors, "gender", "registerForm.gender.empty");
        
        if (errors.hasErrors()) {
         return;   
        }
        
        if(!registerForm.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            errors.rejectValue("emailId", "registerForm.emailId.invalid");
        }
        //Business validation
        if (!password.equals(confirmPassword)) {
            errors.rejectValue("password","registerForm.password.missMatch");
        }
        if (!isPhoneNoValid(registerForm.getPhoneNumber())) {
            errors.rejectValue("phoneNumber","registerForm.phoneNumber.invalid");
        }
        }
    }
    public boolean isPhoneNoValid(String phoneNo) {
		if(phoneNo == null){
			return false;
		}
                System.out.println("Phone Number: " + phoneNo);
		//validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
        //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        //validating phone number with extension length from 3 to 5
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
        //validating phone number where area code is in braces ()
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
        //return false if nothing matches the input
        else return false;
	}
}
