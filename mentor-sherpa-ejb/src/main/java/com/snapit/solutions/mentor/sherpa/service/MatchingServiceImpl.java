/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.entity.QuestionResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.types.ObjectId;

/**
 *
 * @author Ram
 */
public class MatchingServiceImpl {
    
    private static Set<String> getExcludedQuestions(List<QuestionOptions> execQuestions){
        Set<String> excludedQuestions = new HashSet(); 
       for(QuestionOptions questionOptions : execQuestions){
           excludedQuestions.add(questionOptions.getQuestion());
       }
       return excludedQuestions;
    }
    
    public static Map<ObjectId, Integer> match(MentorAndStudentResponse userResponse, 
                                    List<MentorAndStudentResponse> userResponseList,
                                    List<QuestionOptions> studentExcQuestions,
                                    List<QuestionOptions> mentorExcQuestions) {

        Map<ObjectId, Integer> mentorToMatchPercentageMap = new HashMap<>();
        
        Set<String> studentExcQuestionSet = getExcludedQuestions(studentExcQuestions);
        Set<String> mentorExcQuestionSet = getExcludedQuestions(mentorExcQuestions);

        List<String> studentResponseSet = new ArrayList();
        for (QuestionResponse questionResponse : userResponse.getQuestionAndResponses()) {
            if(!studentExcQuestionSet.contains(questionResponse.getQuestion())){
            studentResponseSet.addAll(questionResponse.getResponse());
            }
        }
        for (MentorAndStudentResponse mentorResponse : userResponseList) {
            List<String> mentorResponseSet = new ArrayList();
            for (QuestionResponse questionResponse : mentorResponse.getQuestionAndResponses()) {
                if(!mentorExcQuestionSet.contains(questionResponse.getQuestion())){
                mentorResponseSet.addAll(questionResponse.getResponse()); 
                }
            }
            Integer percentage = getPercentage(mentorResponseSet, studentResponseSet);
            mentorToMatchPercentageMap.put(mentorResponse.getMentorOrStudentId(),percentage);
        }

        return mentorToMatchPercentageMap;
    }
    
    private static Integer getPercentage(List<String> mentorResponseSet, List<String> studentResponseSet) {
        studentResponseSet.retainAll(mentorResponseSet);
        return studentResponseSet.size() * 100 / mentorResponseSet.size();
   }
    
    //    public static Map<ObjectId, Integer> match(MentorAndStudentResponse userResponse, 
//                                    List<MentorAndStudentResponse> userResponseList,
//                                    List<QuestionOptions> studentExcQuestions,
//                                    List<QuestionOptions> mentorExcQuestions) {
//
//        Map<ObjectId, Integer> mentorToMatchPercentageMap = new HashMap<>();
//        
//        Set<String> studentExcQuestionSet = getExcludedQuestions(studentExcQuestions);
//        Set<String> mentorExcQuestionSet = getExcludedQuestions(mentorExcQuestions);
//
//        Set<String> studentResponseSet = new HashSet<>();
//        for (QuestionResponse questionResponse : userResponse.getQuestionAndResponses()) {
//            if(!studentExcQuestionSet.contains(questionResponse.getQuestion())){
//            studentResponseSet.addAll(questionResponse.getResponse());
//            }
//        }
//        for (MentorAndStudentResponse mentorResponse : userResponseList) {
//            Set<String> mentorResponseSet = new HashSet<>();
//            for (QuestionResponse questionResponse : mentorResponse.getQuestionAndResponses()) {
//                if(!mentorExcQuestionSet.contains(questionResponse.getQuestion())){
//                mentorResponseSet.addAll(questionResponse.getResponse()); 
//                }
//            }
//            Integer percentage = getPercentage(mentorResponseSet, studentResponseSet);
//            mentorToMatchPercentageMap.put(mentorResponse.getMentorOrStudentId(),percentage);
//        }
//
//        return mentorToMatchPercentageMap;
//    }

//    private static Integer getPercentage(Set<String> mentorResponseSet, Set<String> studentResponseSet) {
//
//        studentResponseSet.retainAll(mentorResponseSet);
//        return studentResponseSet.size() * 100 / mentorResponseSet.size();
//
//    }


}
