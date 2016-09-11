/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.model;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public class StudentList {
    Map<String, Map<Student, Mentor>> registeredStudentList = new HashMap<>();
    List<Student> unRegisteredStudents = new ArrayList<>();

    public List<Student> getUnRegisteredStudents() {
        return unRegisteredStudents;
    }

    public void setUnRegisteredStudents(List<Student> unRegisteredStudents) {
        this.unRegisteredStudents = unRegisteredStudents;
    }

    public Map<String, Map<Student, Mentor>> getRegisteredStudentList() {
        return registeredStudentList;
    }

    public void setRegisteredStudentList(Map<String, Map<Student, Mentor>> registeredStudentList) {
        this.registeredStudentList = registeredStudentList;
    }

}
