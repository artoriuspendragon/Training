package com.TrainingSystem.Dto;

import java.io.Serializable;
import java.util.Date;

public class trainingexamplan_examplan implements Serializable {
    private Integer classID;

    private String examItem;

    private Date examdate;

    private String teacher;

    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getClassID() {
        return classID;
    }

    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public String getExamItem() {
        return examItem;
    }

    public void setExamItem(String examItem) {
        this.examItem = examItem == null ? null : examItem.trim();
    }

    public Date getExamdate() {
        return examdate;
    }

    public void setExamdate(Date examdate) {
        this.examdate = examdate;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classID=").append(classID);
        sb.append(", examItem=").append(examItem);
        sb.append(", examdate=").append(examdate);
        sb.append(", teacher=").append(teacher);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}