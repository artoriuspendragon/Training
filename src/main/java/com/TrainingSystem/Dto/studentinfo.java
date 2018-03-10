package com.TrainingSystem.Dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class studentinfo implements Serializable {
    private Integer studentID;

    private String studentGuid;
   @NotEmpty(message="{studentinfo.sex.null}")
   @Size(max=2,min=0,message="{studentinfo.sex.size}")
    private String sex;
   @NotNull(message="{studentinfo.age.null}")
    private Integer age;
   @NotEmpty(message="{studentinfo.identity.null}")
    private String identity;
   @NotEmpty(message="{studentinfo.education.null}")
    private String education;
   @NotEmpty(message="{studentinfo.unit.null}")
    private String unit;
   
    private String association;
   @NotEmpty(message="{studentinfo.certification.null}")
    private String certification;
   @NotEmpty(message="{studentinfo.examType.null}")
    private String examType;
   @NotEmpty(message="{studentinfo.examDegree.null}")
    private String examDegree;

    private String remarks;
    @NotEmpty(message="studentinfo.name.null")
    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentGuid() {
        return studentGuid;
    }

    public void setStudentGuid(String studentGuid) {
        this.studentGuid = studentGuid == null ? null : studentGuid.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association == null ? null : association.trim();
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification == null ? null : certification.trim();
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType == null ? null : examType.trim();
    }

    public String getExamDegree() {
        return examDegree;
    }

    public void setExamDegree(String examDegree) {
        this.examDegree = examDegree == null ? null : examDegree.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentID=").append(studentID);
        sb.append(", studentGuid=").append(studentGuid);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", identity=").append(identity);
        sb.append(", education=").append(education);
        sb.append(", unit=").append(unit);
        sb.append(", association=").append(association);
        sb.append(", certification=").append(certification);
        sb.append(", examType=").append(examType);
        sb.append(", examDegree=").append(examDegree);
        sb.append(", remarks=").append(remarks);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}