package com.TrainingSystem.Dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class lessonrecord implements Serializable {
    private Integer lessonrecordID;
   @NotNull(message="未选择班级")
   @Min(value=0,message="数据错误！")
    private Integer classID;
   @NotEmpty(message="请输入时间")
    private String lessondate;

    private String lessonContent;

    private String time;

    private String lessonPeriod;
   @NotEmpty(message="请签名")
    private String teacherSign;

    private static final long serialVersionUID = 1L;

    public Integer getLessonrecordID() {
        return lessonrecordID;
    }

    public void setLessonrecordID(Integer lessonrecordID) {
        this.lessonrecordID = lessonrecordID;
    }

    public Integer getClassID() {
        return classID;
    }

    public void setClassID(Integer classId) {
        this.classID = classId;
    }

    public String getLessondate() {
        return lessondate;
    }

    public void setLessondate(String lessondate) {
        this.lessondate = lessondate == null ? null : lessondate.trim();
    }

    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent == null ? null : lessonContent.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getLessonPeriod() {
        return lessonPeriod;
    }

    public void setLessonPeriod(String lessonPeriod) {
        this.lessonPeriod = lessonPeriod == null ? null : lessonPeriod.trim();
    }

    public String getTeacherSign() {
        return teacherSign;
    }

    public void setTeacherSign(String teacherSign) {
        this.teacherSign = teacherSign == null ? null : teacherSign.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lessonrecordID=").append(lessonrecordID);
        sb.append(", classId=").append(classID);
        sb.append(", lessondate=").append(lessondate);
        sb.append(", lessonContent=").append(lessonContent);
        sb.append(", time=").append(time);
        sb.append(", lessonPeriod=").append(lessonPeriod);
        sb.append(", teacherSign=").append(teacherSign);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}