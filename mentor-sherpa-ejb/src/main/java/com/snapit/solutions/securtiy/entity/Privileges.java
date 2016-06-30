/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.entity;

import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Embedded
public class Privileges {
     public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    private String name;
 
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Privilege [name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }
}
