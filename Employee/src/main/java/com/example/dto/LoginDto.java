package com.example.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LoginDto {
    private String email;
    private String empid;
    private String password;
    private String role;
    private String fullname;
    private String project;
    private String pro_desc;
    private Date dateFrom;
    private Date dateTo;
    private String designation; // New field
    
    public LoginDto(String email, String empid, String password, String role, String fullname, String project, String pro_desc, Date dateFrom, Date dateTo, String designation) {
        super();
        this.email = email;
        this.empid = empid;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
        this.project = project;
        this.pro_desc = pro_desc;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public LoginDto() {
        super();
    }
}
