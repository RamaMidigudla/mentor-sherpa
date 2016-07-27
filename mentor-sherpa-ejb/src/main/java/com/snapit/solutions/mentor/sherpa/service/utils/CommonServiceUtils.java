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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;

/**
 *
 * @author Ram
 */
public class CommonServiceUtils {
    
    public static Set<String> findrequiredQuestionIdList(Organization organization,InterestedOrganizations interestedOrganizations){
        Set<ObjectId> questionIdList = new HashSet();
        for (Program program : organization.getPrograms()) 
        {
            for (String interestedProgramName : interestedOrganizations.getPrograms()) 
            {
                if (interestedProgramName.equals(program.getProgramName())) 
                {
                    questionIdList.addAll(program.getQuestionsIdList());
                }
            }
        }
        return createSetOfStringIds(questionIdList);
    }
    
    public static Set<String> createSetOfStringIds(Collection<ObjectId> objectIds) {
        Set<String> objectIdSet = new HashSet();
        if (!objectIds.isEmpty()) {
            for (ObjectId objectId : objectIds) {
                objectIdSet.add(createStringId(objectId));
            }

        }
        return objectIdSet;
    }

    public static String createStringId(Object objectId) {
        if (objectId == null) {
            return null;
        }
        return objectId.toString();
    }
    
}
