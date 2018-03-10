package com.TrainingSystem.Dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class trainingexamplan implements Serializable {
	@NotNull(message = "选择班级")
	private Integer classID;
	@NotNull(message = "请输入人数")
	@Min(value = 0, message = "请输入正确的人数")
	private Integer memberAmount;
	@NotEmpty(message = "请输入联系人")
	private String contact;
	@NotEmpty(message = "请输入电话")
	private String telephone;
	private String approval;
	@NotEmpty(message = "请输入单位")
	private String unit;

	private static final long serialVersionUID = 1L;

	public Integer getClassID() {
		return classID;
	}

	public void setClassID(Integer classID) {
		this.classID = classID;
	}

	public Integer getMemberAmount() {
		return memberAmount;
	}

	public void setMemberAmount(Integer memberAmount) {
		this.memberAmount = memberAmount;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact == null ? null : contact.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval == null ? null : approval.trim();
	}

	public String getUnit() {
		return unit;
	}

	public trainingexamplan() {
		// TODO Auto-generated constructor stub
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", classID=").append(classID);
		sb.append(", memberAmount=").append(memberAmount);
		sb.append(", contact=").append(contact);
		sb.append(", telephone=").append(telephone);
		sb.append(", approval=").append(approval);
		sb.append(", unit=").append(unit);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}