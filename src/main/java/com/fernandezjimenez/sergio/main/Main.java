package com.fernandezjimenez.sergio.main;

import com.fernandezjimenez.sergio.view.MainPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gestión de Empleados");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setContentPane(new MainPanel());
            frame.setVisible(true);
        });
    }
}
