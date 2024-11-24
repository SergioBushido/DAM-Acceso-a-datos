package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        // Configuración de Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();

        // Crear ventana principal
        JFrame frame = new JFrame("Gestión de Vuelos y Pasajeros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Crear panel con pestañas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear contenedores para las pestañas de vuelos y pasajeros
        JPanel vuelosPanel = new JPanel(new BorderLayout());
        JPanel pasajerosPanel = new JPanel(new BorderLayout());

        // Agregar pestañas al `JTabbedPane`
        tabbedPane.addTab("Vuelos", vuelosPanel);
        tabbedPane.addTab("Pasajeros", pasajerosPanel);
        tabbedPane.addTab("Insertar Pasajero", crearPanelInsertarPasajero());
        tabbedPane.addTab("Borrar Pasajero", crearPanelBorrarPasajero());

        // Listener para actualizar datos al cambiar de pestaña
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                if (selectedIndex == 0) { // Pestaña de vuelos
                    actualizarPanelVuelos(vuelosPanel);
                } else if (selectedIndex == 1) { // Pestaña de pasajeros
                    actualizarPanelPasajeros(pasajerosPanel);
                }
            }
        });

        // Inicializar datos al inicio
        actualizarPanelVuelos(vuelosPanel);
        actualizarPanelPasajeros(pasajerosPanel);

        // Agregar el panel de pestañas al marco
        frame.add(tabbedPane);

        // Mostrar ventana
        frame.setVisible(true);
    }

    private static void actualizarPanelVuelos(JPanel vuelosPanel) {
        vuelosPanel.removeAll(); // Limpiar el panel

        String[] columnNames = {"Código", "Hora Salida", "Destino", "Procedencia", "Fumador", "No Fumador", "Turista", "Primera"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Consultar datos de vuelos
        try (Session session = sessionFactory.openSession()) {
            List<Vuelo> vuelos = session.createQuery("FROM Vuelo", Vuelo.class).getResultList();
            for (Vuelo vuelo : vuelos) {
                Object[] rowData = {
                    vuelo.getCodVuelo(),
                    vuelo.getHoraSalida(),
                    vuelo.getDestino(),
                    vuelo.getProcedencia(),
                    vuelo.getPlazasFumador(),
                    vuelo.getPlazasNoFumador(),
                    vuelo.getPlazasTurista(),
                    vuelo.getPlazasPrimera()
                };
                tableModel.addRow(rowData);
            }
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        vuelosPanel.setBorder(BorderFactory.createTitledBorder("Vuelos"));
        vuelosPanel.add(scrollPane, BorderLayout.CENTER);

        vuelosPanel.revalidate(); // Actualizar el panel
        vuelosPanel.repaint(); // Redibujar el panel
    }

    private static void actualizarPanelPasajeros(JPanel pasajerosPanel) {
        pasajerosPanel.removeAll(); // Limpiar el panel

        String[] columnNames = {"Número", "Código de Vuelo", "Tipo de Plaza", "Fumador"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Consultar datos de pasajeros
        try (Session session = sessionFactory.openSession()) {
            List<Pasajero> pasajeros = session.createQuery("FROM Pasajero", Pasajero.class).getResultList();
            for (Pasajero pasajero : pasajeros) {
                Object[] rowData = {
                    pasajero.getNum(),
                    pasajero.getCodVuelo(),
                    pasajero.getTipoPlaza(),
                    pasajero.getFumador()
                };
                tableModel.addRow(rowData);
            }
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        pasajerosPanel.setBorder(BorderFactory.createTitledBorder("Pasajeros"));
        pasajerosPanel.add(scrollPane, BorderLayout.CENTER);

        pasajerosPanel.revalidate(); // Actualizar el panel
        pasajerosPanel.repaint(); // Redibujar el panel
    }

    private static JPanel crearPanelInsertarPasajero() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel labelCodVuelo = new JLabel("Código de Vuelo:");
        JTextField textCodVuelo = new JTextField();

        JLabel labelTipoPlaza = new JLabel("Tipo de Plaza:");
        JTextField textTipoPlaza = new JTextField();

        JLabel labelFumador = new JLabel("Fumador (SI/NO):");
        JTextField textFumador = new JTextField();

        JButton buttonInsertar = new JButton("Insertar Pasajero");

        panel.add(labelCodVuelo);
        panel.add(textCodVuelo);
        panel.add(labelTipoPlaza);
        panel.add(textTipoPlaza);
        panel.add(labelFumador);
        panel.add(textFumador);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(buttonInsertar);

        buttonInsertar.addActionListener(e -> {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                try {
                    Pasajero pasajero = new Pasajero();
                    pasajero.setCodVuelo(textCodVuelo.getText());
                    pasajero.setTipoPlaza(textTipoPlaza.getText());
                    pasajero.setFumador(textFumador.getText());
                    session.persist(pasajero);
                    transaction.commit();
                    JOptionPane.showMessageDialog(panel, "Pasajero insertado correctamente.");
                } catch (Exception ex) {
                    transaction.rollback();
                    JOptionPane.showMessageDialog(panel, "Error al insertar pasajero: " + ex.getMessage());
                }
            }
        });

        return panel;
    }

    private static JPanel crearPanelBorrarPasajero() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel labelNum = new JLabel("Número del Pasajero a Borrar:");
        JTextField textNum = new JTextField();
        JButton buttonBorrar = new JButton("Borrar Pasajero");

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(labelNum);
        inputPanel.add(textNum);
        inputPanel.add(new JLabel()); // Espacio vacío
        inputPanel.add(buttonBorrar);

        panel.add(inputPanel, BorderLayout.NORTH);

        buttonBorrar.addActionListener(e -> {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                try {
                    int num = Integer.parseInt(textNum.getText());
                    Pasajero pasajero = session.find(Pasajero.class, num);
                    if (pasajero != null) {
                        session.remove(pasajero);
                        transaction.commit();
                        JOptionPane.showMessageDialog(panel, "Pasajero borrado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(panel, "No se encontró un pasajero con ese número.");
                    }
                } catch (Exception ex) {
                    transaction.rollback();
                    JOptionPane.showMessageDialog(panel, "Error al borrar pasajero: " + ex.getMessage());
                }
            }
        });

        return panel;
    }
}
