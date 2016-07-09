/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service.utils;

import com.snapit.solutions.mentor.sherpa.entity.InterestedOrganizations;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.Program;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ram
 */
public class CommonServiceUtils {
    
    public static List<ObjectId> findrequiredQuestionIdList(Organization organization,InterestedOrganizations interestedOrganizations){
        List<ObjectId> questionIdList = new ArrayList<>();
        for (Program program : organization.getPrograms()) 
        {
            for (String interestedProgramName : interestedOrganizations.getPrograms()) 
            {
                if (interestedProgramName.equals(program.getProgramName())) 
                {
                    questionIdList.addAll(program.getQuestionIdList());
                }
            }
        }
        return questionIdList;
    }
    
}
