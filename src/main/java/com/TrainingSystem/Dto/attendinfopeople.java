package com.TrainingSystem.Dto;

import java.io.Serializable;
import java.util.Date;

public class attendinfopeople implements Serializable {
    private Integer attendID;

    private String charge;

    private Date date;

    private String teacher;

    private String attendceMan;

    private static final long serialVersionUID = 1L;

    public Integer getAttendID() {
        return attendID;
    }

    public void setAttendID(Integer attendID) {
        this.attendID = attendID;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge == null ? null : charge.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getAttendceMan() {
        return attendceMan;
    }

    public void setAttendceMan(String attendceMan) {
        this.attendceMan = attendceMan == null ? null : attendceMan.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attendID=").append(attendID);
        sb.append(", charge=").append(charge);
        sb.append(", date=").append(date);
        sb.append(", teacher=").append(teacher);
        sb.append(", attendceMan=").append(attendceMan);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}