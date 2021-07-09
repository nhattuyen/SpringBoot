package com.example.shoppingmall.form;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class EmployeeForm {
    private String id;

    //@NotEmpty
    private String empNo;
    private String fullname;
    private String hireDate;

    public EmployeeForm() {

    }

    public EmployeeForm(String id, String empNo, String fullname, String hireDate) {
        super();
        this.id = id;
        this.empNo = empNo;
        this.fullname = fullname;
        this.setHireDate(hireDate);
    }

    public EmployeeForm(String id, String empNo, String fullname, Date hireDate) {
        super();
        this.id = id;
        this.empNo = empNo;
        this.fullname = fullname;
        this.setHireDate(hireDate);
    }

    public String getId() {
        return id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getFullname() {
        return fullname;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setHireDate(Date hireDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        this.hireDate = dateFormat.format(hireDate);
    }
}
