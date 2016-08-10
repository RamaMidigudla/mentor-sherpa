/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.bson.types.ObjectId;

/**
 *
 * @author Ram
 */
public class DaoUtils {

    public static ObjectId createObjectId(String objectId) {
        if (!ObjectId.isValid(objectId)) {
            return null;
        }
        return new ObjectId(objectId);
    }

    public static Set<ObjectId> createSetOfObjectIds(Collection<String> objectIds) {
        Set<ObjectId> objectIdSet = new HashSet<>();
        for (String objectId : objectIds) {
            objectIdSet.add(createObjectId(objectId));
        }
        return objectIdSet;
    }
}
