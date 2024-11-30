package com.fernandezjimenez.sergio.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {
    public MainPanel() {
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Añadir Empleado");
        JButton deleteButton = new JButton("Eliminar Empleado");
        JButton updateButton = new JButton("Actualizar Empleado");
        JButton viewButton = new JButton("Consultar Empleados");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(viewButton);

        add(buttonPanel, BorderLayout.NORTH);

        // Tabla para mostrar datos
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Eventos de los botones
        addButton.addActionListener((ActionEvent e) -> new AddEmployeeDialog());
        deleteButton.addActionListener((ActionEvent e) -> new DeleteEmployeeDialog());
        updateButton.addActionListener((ActionEvent e) -> new UpdateEmployeeDialog());
        viewButton.addActionListener((ActionEvent e) -> {
            EmployeeTableModel model = new EmployeeTableModel();
            table.setModel(model);
        });
    }
}
