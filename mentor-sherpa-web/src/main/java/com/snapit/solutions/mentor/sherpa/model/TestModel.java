/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.model;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import java.util.Map;

/**
 *
 * @author Ram
 */
public class TestModel {
    
    Map<Mentor,Integer> match;

    public Map<Mentor, Integer> getMatch() {
        return match;
    }

    public void setMatch(Map<Mentor, Integer> match) {
        this.match = match;
    }
    
 
}
