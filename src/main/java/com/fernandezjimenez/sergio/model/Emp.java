package com.fernandezjimenez.sergio.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EMP")
public class Emp {

    @Id
    @Column(name = "EMPNO")
    private int empNo;

    @Column(name = "ENAME")
    private String ename;

    @Column(name = "JOB")
    private String job;

    @Column(name = "HIREDATE")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "SAL")
    private BigDecimal sal;

    @Column(name = "COMM")
    private BigDecimal comm;

    @ManyToOne
    @JoinColumn(name = "DEPTNO", nullable = false)
    private Dept dept;

    // Getters y Setters
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
