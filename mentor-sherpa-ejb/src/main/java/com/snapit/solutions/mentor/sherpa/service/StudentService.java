/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.SignedupOrganization;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ram
 */
public interface StudentService {

    public void createMentor(Student student);

    public List<Student> findall();

    public Student findById(String id);

    public List<QuestionOptions> getQuestionsForStudentToAnswer(SignedupOrganization InterestedOrganizations);
    
    public List<Student> findAllByProgramName(String orgId, String programName);
    public Map<String, List<Student>>  findAllByOrg(String orgId);
}
