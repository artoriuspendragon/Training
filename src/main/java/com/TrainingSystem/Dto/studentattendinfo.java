package com.TrainingSystem.Dto;

import java.io.Serializable;
import java.util.Date;

public class studentattendinfo implements Serializable {
    private String studentGuid;

    private Date attendDate;

    private String attendClassGuid;

    private static final long serialVersionUID = 1L;

    public String getStudentGuid() {
        return studentGuid;
    }

    public void setStudentGuid(String studentGuid) {
        this.studentGuid = studentGuid == null ? null : studentGuid.trim();
    }

    public Date getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(Date attendDate) {
        this.attendDate = attendDate;
    }

    public String getAttendClassGuid() {
        return attendClassGuid;
    }

    public void setAttendClassGuid(String attendClassGuid) {
        this.attendClassGuid = attendClassGuid == null ? null : attendClassGuid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentGuid=").append(studentGuid);
        sb.append(", attendDate=").append(attendDate);
        sb.append(", attendClassGuid=").append(attendClassGuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}