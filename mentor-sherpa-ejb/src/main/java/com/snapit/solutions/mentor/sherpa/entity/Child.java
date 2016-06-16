/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.List;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Ram
 */
@Embedded
class Child implements Serializable {
    
    private String name;
    
    private Integer age;
    
    private List<String> intrests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getIntrests() {
        return intrests;
    }

    public void setIntrests(List<String> intrests) {
        this.intrests = intrests;
    }
}
