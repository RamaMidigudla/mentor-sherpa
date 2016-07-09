/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.List;

/**
 *
 * @author Ram
 */
public interface StudentService {
    
    public void createMentor(Student student);
    public List<Student> findall();
    
}
