/**
CREATE TABLE mystudy.member
(    
    id VARCHAR2(20 BYTE) NOT NULL ENABLE,
    name VARCHAR2(30 BYTE) NOT NULL ENABLE,
    password VARCHAR2(20 BYTE) NOT NULL ENABLE,
    phone VARCHAR2(20 BYTE) NOT NULL ENABLE, -- 11
    email VARCHAR2(50 BYTE) NOT NULL ENABLE,
    grade CHAR(1 BYTE) DEFAULT 'W' NOT NULL ENABLE, -- W
    point NUMBER(6) DEFAULT 0 NOT NULL ENABLE, -- 적립금(10만원대)
    status CHAR(1 BYTE) DEFAULT 'R' NOT NULL ENABLE, -- 상태 R가입 X탈퇴
    password_change_date DATE DEFAULT SYSDATE NOT NULL ENABLE
);
 */
package com.mj.shop.member;

import java.util.Date;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String phone;
	private String email;
	private String grade; 
	private String point;
	private String status;
	private Date password_change_date;// 비밀번호 변경일
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getPassword_change_date() {
		return password_change_date;
	}
	public void setPassword_change_date(Date password_change_date) {
		this.password_change_date = password_change_date;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", grade=" + grade + ", point=" + point + ", status=" + status + ", password_change_date="
				+ password_change_date + "]";
	}
	
	
	
}
