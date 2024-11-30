package com.fernandezjimenez.sergio.view;

import com.fernandezjimenez.sergio.dao.HibernateUtil;
import com.fernandezjimenez.sergio.model.Emp;
import org.hibernate.Session;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private final String[] columnNames = {"EmpNo", "Ename", "Job", "Salary", "DeptName", "Location"};
    private List<Object[]> data;

    public EmployeeTableModel() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            data = session.createQuery(
                "SELECT e.empNo, e.ename, e.job, e.sal, d.dname, d.loc " +
                "FROM Emp e JOIN e.dept d", Object[].class
            ).getResultList();
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
