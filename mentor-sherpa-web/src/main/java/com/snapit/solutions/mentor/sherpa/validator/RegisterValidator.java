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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "registerForm.adress1.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "registerForm.city.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "registerForm.state.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "registerForm.zipCode.empty");
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
        if(!registerForm.getState().matches("AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT" +
        "|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY"))
        {
          errors.rejectValue("state", "registerForm.state.invalid");  
        }
        if(!registerForm.getZipCode().matches(" ^\\d{5}$"))
        {
          errors.rejectValue("zipCode", "registerForm.zipCode.invalid");  
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
