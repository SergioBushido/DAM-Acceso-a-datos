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

public class UpdateEmployeeDialog extends JDialog {
    public UpdateEmployeeDialog() {
        setTitle("Actualizar Empleado");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2));

        // Campos del formulario
        JLabel empNoLabel = new JLabel("EmpNo:");
        JTextField empNoField = new JTextField();

        JLabel enameLabel = new JLabel("Ename:");
        JTextField enameField = new JTextField();

        JLabel jobLabel = new JLabel("Job:");
        JTextField jobField = new JTextField();

        JLabel salLabel = new JLabel("Salary:");
        JTextField salField = new JTextField();

        JLabel deptLabel = new JLabel("Department:");
        JComboBox<Dept> deptCombo = new JComboBox<>();

        // Cargar los departamentos en el ComboBox
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Dept> depts = session.createQuery("FROM Dept", Dept.class).getResultList();
            for (Dept dept : depts) {
                deptCombo.addItem(dept);
            }
        }

        // Botón para cargar datos de un empleado existente
        JButton loadButton = new JButton("Cargar");
        loadButton.addActionListener(e -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                int empNo = Integer.parseInt(empNoField.getText());
                Emp emp = session.get(Emp.class, empNo);

                if (emp != null) {
                    enameField.setText(emp.getEname());
                    jobField.setText(emp.getJob());
                    salField.setText(emp.getSal().toString());
                    deptCombo.setSelectedItem(emp.getDept());
                } else {
                    JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al cargar empleado: " + ex.getMessage());
            }
        });

        // Botón para actualizar el empleado
        JButton updateButton = new JButton("Actualizar");
        updateButton.addActionListener(e -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                int empNo = Integer.parseInt(empNoField.getText());
                Emp emp = session.get(Emp.class, empNo);

                if (emp != null) {
                    emp.setEname(enameField.getText());
                    emp.setJob(jobField.getText());
                    emp.setSal(BigDecimal.valueOf(Double.parseDouble(salField.getText())));
                    emp.setDept((Dept) deptCombo.getSelectedItem());

                    session.update(emp);
                    transaction.commit();
                    JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al actualizar empleado: " + ex.getMessage());
            }
        });

        // Agregar componentes al formulario
        add(empNoLabel);
        add(empNoField);
        add(loadButton); // Botón para cargar datos
        add(new JLabel()); // Espacio vacío
        add(enameLabel);
        add(enameField);
        add(jobLabel);
        add(jobField);
        add(salLabel);
        add(salField);
        add(deptLabel);
        add(deptCombo);
        add(new JLabel()); // Espacio vacío
        add(updateButton); // Botón para actualizar

        setModal(true);
        setVisible(true);
    }
}
