/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.entity;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ram
 */
public class Program implements Serializable {

    private String programName;

    private String programDescription;

    private Date programStartDate;

    private Date programEndDate;
    
    private List<ObjectId> questionIdList;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public Date getProgramStartDate() {
        return programStartDate;
    }

    public void setProgramStartDate(Date programStartDate) {
        this.programStartDate = programStartDate;
    }

    public Date getProgramEndDate() {
        return programEndDate;
    }

    public void setProgramEndDate(Date programEndDate) {
        this.programEndDate = programEndDate;
    }

    public List<ObjectId> getQuestionIdList() {
        return questionIdList;
    }

    public void setQuestionIdList(List<ObjectId> questionIdList) {
        this.questionIdList = questionIdList;
    }
    

}
