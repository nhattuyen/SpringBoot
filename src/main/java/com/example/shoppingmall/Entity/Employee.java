package com.example.shoppingmall.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "EmpNo", length = 30, nullable = false)
    private String empNo;

    @Column(name="FullName", length = 128, nullable = false)
    private String fullname;

    @Temporal(TemporalType.DATE)
    @Column(name = "HireDate", nullable = false)
    private Date hireDate;

    public Employee() { super(); }

    public Employee(String id, String empNo ,String fullname, String hireDate) throws ParseException {
        super();
        this.setId(id);
        this.empNo=empNo;
        this.fullname=fullname;
        this.setHireDare(hireDate);
    }

    public Employee(String id, String empNo ,String fullname, Date hireDate) {
        super();
        this.id=id;
        this.empNo=empNo;
        this.fullname=fullname;
        this.hireDate=hireDate;
    }

    public Employee(int parseInt, String empNo, String fullname) {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId(int id){
        this.id = Integer.toString(id);
    }

    public String getId(){
        return id;
    }

    public String getIdString() {
        return id;
    }

    public void setEmpNo(String empno) {
        this.empNo = empno;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setHireDare(String hireDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date date = dateFormat.parse(hireDate);
        this.hireDate = date;
    };
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }
}
