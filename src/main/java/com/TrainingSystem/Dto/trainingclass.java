package com.TrainingSystem.Dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
public class trainingclass implements Serializable {
    private Integer classID;

    private String classGuid;
    @NotEmpty(message="{trainingclass.studyContent.null}")
    private String studyContent;
    @NotNull(message="{trainingclass.memberAmount.null}")
    @Min(value=0,message="{trainingclass.memberAmount.min}")
    private Integer memberAmount;
    @NotEmpty(message="{trainingclass.trainingBook.null}")
    private String trainingBook;
    @NotEmpty(message="{trainingclass.trainingForm.null}")
    private String trainingForm;
    @NotEmpty(message="{trainingclass.trainingPeriod.null}")
    private String trainingPeriod;
    
    private String trainingTime;

    private String trainingLocation;

    private String trainingClass;

    private String teacherName;

    private String teacherUnit;

    private String trainingGoal;
    @NotEmpty(message="{trainingclass.className.null}")
    private String className;

    private static final long serialVersionUID = 1L;
    
    public Integer getClassID() {
        return classID;
    }

    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public String getClassGuid() {
        return classGuid;
    }

    public void setClassGuid(String classGuid) {
        this.classGuid = classGuid == null ? null : classGuid.trim();
    }

    public String getStudyContent() {
        return studyContent;
    }

    public void setStudyContent(String studyContent) {
        this.studyContent = studyContent == null ? null : studyContent.trim();
    }

    public Integer getMemberAmount() {
        return memberAmount;
    }

    public void setMemberAmount(Integer memberAmount) {
        this.memberAmount = memberAmount;
    }

    public String getTrainingBook() {
        return trainingBook;
    }

    public void setTrainingBook(String trainingBook) {
        this.trainingBook = trainingBook == null ? null : trainingBook.trim();
    }

    public String getTrainingForm() {
        return trainingForm;
    }

    public void setTrainingForm(String trainingForm) {
        this.trainingForm = trainingForm == null ? null : trainingForm.trim();
    }

    public String getTrainingPeriod() {
        return trainingPeriod;
    }

    public void setTrainingPeriod(String trainingPeriod) {
        this.trainingPeriod = trainingPeriod == null ? null : trainingPeriod.trim();
    }

    public String getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(String trainingTime) {
        this.trainingTime = trainingTime == null ? null : trainingTime.trim();
    }

    public String getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(String trainingLocation) {
        this.trainingLocation = trainingLocation == null ? null : trainingLocation.trim();
    }

    public String getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(String trainingClass) {
        this.trainingClass = trainingClass == null ? null : trainingClass.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherUnit() {
        return teacherUnit;
    }

    public void setTeacherUnit(String teacherUnit) {
        this.teacherUnit = teacherUnit == null ? null : teacherUnit.trim();
    }

    public String getTrainingGoal() {
        return trainingGoal;
    }

    public void setTrainingGoal(String trainingGoal) {
        this.trainingGoal = trainingGoal == null ? null : trainingGoal.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classID=").append(classID);
        sb.append(", classGuid=").append(classGuid);
        sb.append(", studyContent=").append(studyContent);
        sb.append(", memberAmount=").append(memberAmount);
        sb.append(", trainingBook=").append(trainingBook);
        sb.append(", trainingForm=").append(trainingForm);
        sb.append(", trainingPeriod=").append(trainingPeriod);
        sb.append(", trainingTime=").append(trainingTime);
        sb.append(", trainingLocation=").append(trainingLocation);
        sb.append(", trainingClass=").append(trainingClass);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", teacherUnit=").append(teacherUnit);
        sb.append(", trainingGoal=").append(trainingGoal);
        sb.append(", className=").append(className);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}