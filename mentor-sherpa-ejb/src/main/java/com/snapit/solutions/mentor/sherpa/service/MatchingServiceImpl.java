/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.QuestionResponse;
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

    public static Map<ObjectId, Integer> match(MentorAndStudentResponse studentResponse, List<MentorAndStudentResponse> mentorResponseList) {

        Map<ObjectId, Integer> mentorToMatchPercentageMap = new HashMap<>();

        Set<String> studentResponseSet = new HashSet<>();
        for (QuestionResponse questionResponse : studentResponse.getQuestionAndResponses()) {
            studentResponseSet.add(questionResponse.getResponse());
        }

        for (MentorAndStudentResponse mentorResponse : mentorResponseList) {
            Set<String> mentorResponseSet = new HashSet<>();
            for (QuestionResponse questionResponse : mentorResponse.getQuestionAndResponses()) {
                mentorResponseSet.add(questionResponse.getResponse());     
            }
            Integer percentage = getPercentage(mentorResponseSet, studentResponseSet);
            mentorToMatchPercentageMap.put(mentorResponse.getMentorOrStudentId(),percentage);

        }

        return mentorToMatchPercentageMap;
    }

    private static Integer getPercentage(Set<String> mentorResponseSet, Set<String> studentResponseSet) {

        studentResponseSet.retainAll(mentorResponseSet);
        return studentResponseSet.size() * 100 / mentorResponseSet.size();

    }

}
