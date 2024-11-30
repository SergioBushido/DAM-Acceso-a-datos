package com.fernandezjimenez.sergio.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Cargar la configuración de Hibernate desde hibernate.cfg.xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Manejar la excepción en caso de fallo al construir SessionFactory
            System.err.println("Error al inicializar la SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método para obtener la SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Método para cerrar la SessionFactory
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
