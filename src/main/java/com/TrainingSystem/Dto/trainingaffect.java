package com.TrainingSystem.Dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class trainingaffect implements Serializable {
    private Integer trainingAffectID;
    @NotNull(message="请选择班级")
    private Integer classID;
    
    private Date trainingDate;
  
    private Date graduateDate;
   @NotNull(message="请输入结业人数")
    private Integer graduateAmount;

    private String trainingState;

    private String affectComment;
   @NotEmpty(message="请输入负责人")
    private String charge;

    private Date writetime;

    private static final long serialVersionUID = 1L;

    public Integer getTrainingAffectID() {
        return trainingAffectID;
    }

    public void setTrainingAffectID(Integer trainingAffectID) {
        this.trainingAffectID = trainingAffectID;
    }

    public Integer getClassID() {
        return classID;
    }

    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public Integer getGraduateAmount() {
        return graduateAmount;
    }

    public void setGraduateAmount(Integer graduateAmount) {
        this.graduateAmount = graduateAmount;
    }

    public String getTrainingState() {
        return trainingState;
    }

    public void setTrainingState(String trainingState) {
        this.trainingState = trainingState == null ? null : trainingState.trim();
    }

    public String getAffectComment() {
        return affectComment;
    }

    public void setAffectComment(String affectComment) {
        this.affectComment = affectComment == null ? null : affectComment.trim();
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge == null ? null : charge.trim();
    }

    public Date getWritetime() {
        return writetime;
    }

    public void setWritetime(Date writetime) {
        this.writetime = writetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", trainingAffectID=").append(trainingAffectID);
        sb.append(", classID=").append(classID);
        sb.append(", trainingDate=").append(trainingDate);
        sb.append(", graduateDate=").append(graduateDate);
        sb.append(", graduateAmount=").append(graduateAmount);
        sb.append(", trainingState=").append(trainingState);
        sb.append(", affectComment=").append(affectComment);
        sb.append(", charge=").append(charge);
        sb.append(", writetime=").append(writetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}