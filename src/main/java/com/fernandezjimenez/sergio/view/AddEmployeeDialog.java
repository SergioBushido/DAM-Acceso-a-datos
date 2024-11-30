package com.fernandezjimenez.sergio.view;

import com.fernandezjimenez.sergio.dao.HibernateUtil;
import com.fernandezjimenez.sergio.model.Dept;
import com.fernandezjimenez.sergio.model.Emp;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;


public class AddEmployeeDialog extends JDialog {
    public AddEmployeeDialog() {
        setTitle("Añadir Empleado");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        JTextField empNoField = new JTextField();
        JTextField enameField = new JTextField();
        JTextField jobField = new JTextField();
        JTextField salField = new JTextField();
        JComboBox<Dept> deptCombo = new JComboBox<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Dept> depts = session.createQuery("FROM Dept", Dept.class).getResultList();
            for (Dept dept : depts) {
                deptCombo.addItem(dept);
            }
        }

        add(new JLabel("EmpNo:"));
        add(empNoField);
        add(new JLabel("Ename:"));
        add(enameField);
        add(new JLabel("Job:"));
        add(jobField);
        add(new JLabel("Salary:"));
        add(salField);
        add(new JLabel("Department:"));
        add(deptCombo);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                Emp emp = new Emp();
                emp.setEmpNo(Integer.parseInt(empNoField.getText()));
                emp.setEname(enameField.getText());
                emp.setJob(jobField.getText());
                emp.setSal(BigDecimal.valueOf(Double.parseDouble(salField.getText())));
                emp.setDept((Dept) deptCombo.getSelectedItem());

                session.save(emp);
                transaction.commit();
                JOptionPane.showMessageDialog(this, "Empleado añadido correctamente.");
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al añadir el empleado: " + ex.getMessage());
            }
        });
        add(new JLabel());
        add(saveButton);

        setModal(true);
        setVisible(true);
    }
}
