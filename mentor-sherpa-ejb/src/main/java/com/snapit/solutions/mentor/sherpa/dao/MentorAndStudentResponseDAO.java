/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao;

import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Ram
 */
public interface MentorAndStudentResponseDAO extends DAO<MentorAndStudentResponse, ObjectId> {

    public MentorAndStudentResponse retrieveByMentorStudentId(ObjectId mentorOrStudentId);

    public List<MentorAndStudentResponse> retrieveMentorsResponsebyOrgAndProgram(
                                                                ObjectId orgId,
                                                                String programName,
                                                                ObjectId childId);
    public List<MentorAndStudentResponse> findAll();
}
