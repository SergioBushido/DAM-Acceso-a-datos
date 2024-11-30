package com.fernandezjimenez.sergio.view;

import com.fernandezjimenez.sergio.dao.HibernateUtil;
import com.fernandezjimenez.sergio.model.Emp;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;

public class DeleteEmployeeDialog extends JDialog {
    public DeleteEmployeeDialog() {
        setTitle("Eliminar Empleado");
        setSize(300, 200);
        setLayout(new GridLayout(2, 2));

        JLabel empNoLabel = new JLabel("EmpNo:");
        JTextField empNoField = new JTextField();

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                int empNo = Integer.parseInt(empNoField.getText());
                Emp emp = session.get(Emp.class, empNo);

                if (emp != null) {
                    session.remove(emp); // Alternativa al método delete
                    transaction.commit();
                    JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar empleado: " + ex.getMessage());
            }
        });

        add(empNoLabel);
        add(empNoField);
        add(new JLabel());
        add(deleteButton);

        setModal(true);
        setVisible(true);
    }
}
