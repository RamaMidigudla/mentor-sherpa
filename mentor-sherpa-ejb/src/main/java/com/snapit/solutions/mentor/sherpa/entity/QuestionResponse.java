/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Ram
 */
public class QuestionResponse  implements Serializable {
    
    
    private String question;
    
    private Set<String> response;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<String> getResponse() {
        return response;
    }

    public void setResponse(Set<String> response) {
        this.response = response;
    }

   
    
}
