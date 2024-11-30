package com.fernandezjimenez.sergio.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPT")
public class Dept {

    @Id
    @Column(name = "DEPTNO")
    private int deptNo;

    @Column(name = "DNAME")
    private String dname;

    @Column(name = "LOC")
    private String loc;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emp> employees;

    // Constructor por defecto
    public Dept() {}

    // Constructor con parámetros
    public Dept(int deptNo, String dname, String loc) {
        this.deptNo = deptNo;
        this.dname = dname;
        this.loc = loc;
    }

    // Getters y Setters
    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Emp> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
