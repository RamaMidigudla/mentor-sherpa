/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.validator;

import com.snapit.solutions.mentor.sherpa.model.ProgramSignupForm;
import com.snapit.solutions.mentor.sherpa.model.QuestionOptionsAndResponses;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Component
public class QuestionResponseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return (ProgramSignupForm.class.isAssignableFrom(clazz));
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProgramSignupForm programSignupForm = null;
        if (target instanceof ProgramSignupForm) {
            programSignupForm = (ProgramSignupForm) target;
        }

        if (programSignupForm != null) {

            for (String questionCategory : programSignupForm.getQuestionResponseMap().keySet()) {
                List<QuestionOptionsAndResponses> questionOptionsAndResponses = programSignupForm.getQuestionResponseMap().get(questionCategory);
                if (null != questionOptionsAndResponses && !questionOptionsAndResponses.isEmpty()) {
                    for (QuestionOptionsAndResponses questionOptionsAndResponse : questionOptionsAndResponses) {
                        if (null == questionOptionsAndResponse.getQuestionResponse().getResponse() || questionOptionsAndResponse.getQuestionResponse().getResponse().isEmpty()) {
                            errors.rejectValue("questionResponses", "programSignupForm.questionOptionsAndResponse.null");
                        }
                    }
                }
            }

        }
    }
}
