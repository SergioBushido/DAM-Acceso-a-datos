package main;

import java.awt.Component;

import java.text.*;

import java.util.*;

import java.util.List;

import java.util.Scanner;

import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.*;

public class main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Session  sesion = HibernateUtil.getSessionFactory().openSession(); //crea la sesion
	
		String OpcionMenu,pausa;
		
		Scanner sc = new Scanner(System.in);
		
		do 
			{OpcionMenu = JOptionPane.showInputDialog(null, "Elige bases de datos: \n"
				+ "(1) Insertar Datos \n"
				+ "(2) Eliminar Residencia \n"
				+ "(3) Actualizar Residencia \n"
				+ "(4) Visualizar Residencias Observaciones \n"
				+ "(5) Visualizar Residencias Estancias Estudiantes Universidad \n"
				+ "(6) Salir");
		
			switch (OpcionMenu) {
				case "1":
					InsertarDatos(sesion);	
									
					System.out.println("Return para salir:");
					pausa = sc.nextLine();
					break;
				case "2":
					EliminarResidencia(sesion);
					
					System.out.println("Return para salir:");
					pausa = sc.nextLine();
					break;
			case "3":
					ActualizarResidencia(sesion);
					
					System.out.println("Return para salir:");
					pausa = sc.nextLine();
					break;
			case "4":
					VisualizarResidenciasObservaciones(sesion);
					
					System.out.println("Return para salir:");
					pausa = sc.nextLine();
					break;
			case "5":
					VisualizarResidenciasEstanciasEstudiantesUniversidad(sesion);
					
					System.out.println("Return para salir:");
					pausa = sc.nextLine();
					break;
			case "6":
					JOptionPane.showMessageDialog(null, "Salimos.");
					break;
			default:
				JOptionPane.showMessageDialog(null, "Hay que eleguir entre las opciones.");
				sesion.close();
				System.exit(0);
				}
			}
		while (!OpcionMenu.equals("6"));	
		
		sesion.close();
	
		
	}
	private static void InsertarDatos(Session sesion) throws ParseException {
		//Transaction tx = null;
		
		try 
		{
		sesion.beginTransaction();					//inicia transacción
		//tx = sesion.beginTransaction();
			
		estudiantes estudiante1 = new estudiantes();				//Crea el objeto, un registro
		
		estudiante1.setcodEstudiante(4);
		estudiante1.setestudiante("Sofia");
		estudiante1.setdni("49");
		estudiante1.settelefonoEstudiante("923");
				
		sesion.persist(estudiante1);
		
		estudiante1 = new estudiantes();				//Crea el objeto, un registro
		
		estudiante1.setcodEstudiante(5);
		estudiante1.setestudiante("Sara");
		estudiante1.setdni("50");
		estudiante1.settelefonoEstudiante("924");
				
		sesion.persist(estudiante1);
		
		// Universidades
		// Introducir 2 universidades
		universidades universidad1 = new universidades();				//Crea el objeto, un registro
						
		universidad1.setcodUniversidad("Upv");
		universidad1.setnomUniversidad("Valencia");
								
		sesion.persist(universidad1);
		
		universidad1 = new universidades();				//Crea el objeto, un registro
		
		universidad1.setcodUniversidad("Upg");
		universidad1.setnomUniversidad("Galicia");
								
		sesion.persist(universidad1);
			
		// Residencias
		// Introducir 3 residencias
				
		// 1º Residencia
					
		residencias residencias1 = new residencias();				//Crea el objeto, un registro
								
		residencias1.setnomResidencia("San Marcos");
	/*	residencias1.setuniversidad("Ull");*/
		
		universidades uni1 = new universidades();
		uni1 = (universidades) sesion.get(universidades.class, "Upg");
		residencias1.setuniversidadobj(uni1);
		
				
		residencias1.setprecioMensual((short)600);
		residencias1.setComedor(false);
				
		// Crear estancia
		estancias  estancias1 = new estancias();
		
		estudiantes est3 = new estudiantes();
		est3 = (estudiantes) sesion.get(estudiantes.class, 4);
		estancias1.setestudianteobj(est3);
		
		estancias1.setresidenciaobj(residencias1);
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");		
		
		estancias1.setfechaInicio(formatoDelTexto.parse("01-07-2019"));
		estancias1.setfechaFin(formatoDelTexto.parse("01-08-2019"));
		
		estancias1.setpreciopagado((short)600);
						
		List<estancias> listaestancias = new ArrayList<estancias>();
		listaestancias.add(estancias1);
		residencias1.setestancia(listaestancias);
				
		sesion.persist(residencias1);
		
		// 2º Residencia
		residencias residencias2 = new residencias();				//Crea el objeto, un registro
										
		residencias2.setnomResidencia("San Carlos");
	/*	residencias2.setuniversidad("Upm");*/
		
		universidades uni2 = new universidades();
		uni2 = (universidades) sesion.get(universidades.class, "Upv");
		residencias2.setuniversidadobj(uni2);
		
		residencias2.setprecioMensual((short)700);
		residencias2.setComedor(true);
				
		//Crea Residencias Observaciones
		// 1º Observacion
		residenciasobservaciones  residenciasobservacion1 = new residenciasobservaciones();
		residenciasobservacion1.setobservaciones("Buena");
		// asigna residencia a observacion 
		
		// No se puede asignar el objeto residenciaobservacion1 a residencia2
		//residencias2.setresidenciasobservacion(residenciasobservacion1);
		
		residenciasobservacion1.setResidenciaXXX(residencias2);
		
		sesion.persist(residenciasobservacion1);
				
		// No se puede guardar el objeto residencia2 porque tiene observación
		//sesion.persist(residencias2);  
				
		// 3º Residencia
		residencias residencias3 = new residencias();				//Crea el objeto, un registro
										
		residencias3.setnomResidencia("San Alejandro");

		
		universidades uni3 = new universidades();
		uni3 = (universidades) sesion.get(universidades.class, "Upg");
		residencias3.setuniversidadobj(uni3);
		
		residencias3.setprecioMensual((short)500);
		residencias3.setComedor(false);
					

		// Crear 2º estancia y añadir 2 estancias
		estancias  estancias2 = new estancias();

		
		estudiantes est2 = new estudiantes();
		est2 = (estudiantes) sesion.get(estudiantes.class, 4);
		estancias2.setestudianteobj(est2);
		
		estancias2.setresidenciaobj(residencias3);	
		
		estancias2.setfechaInicio(formatoDelTexto.parse("01-07-2017"));
		estancias2.setfechaFin(formatoDelTexto.parse("01-08-2017"));
		estancias2.setpreciopagado((short)500);
		
		estancias  estancias3 = new estancias();
		
		estudiantes est1 = new estudiantes();
		est1 = (estudiantes) sesion.get(estudiantes.class, 5);
		estancias3.setestudianteobj(est1);
		
		estancias3.setresidenciaobj(residencias3);
		
		estancias3.setfechaInicio(formatoDelTexto.parse("01-07-2018"));
		estancias3.setfechaFin(formatoDelTexto.parse("01-08-2018"));
		estancias3.setpreciopagado((short)400);
						
		List<estancias> listaestancias2 = new ArrayList<estancias>();
		listaestancias2.add(estancias2);
		listaestancias2.add(estancias3);
		residencias3.setestancia(listaestancias2);

		//Crea Residencias Observaciones
		// 2º Observacion
		// asigna observacion a residencia
		
		residenciasobservaciones  residenciasobservacion2 = new residenciasobservaciones();
		residenciasobservacion2.setobservaciones("Regular");	
		//  asigna residencia a observacion 
		
		// No se puede asignar el objeto residenciaobservacion2 a residencia3
		//residencias3.setresidenciasobservacion(residenciasobservacion2);
		
		residenciasobservacion2.setResidenciaXXX(residencias3);
		
		sesion.persist(residenciasobservacion2);
		
		// No se puede guardar el objeto residencia3 porque tiene observación
		//sesion.persist(residencias3);  
		
		// Añadir solo una estancia
		
		estancias  estancias4 = new estancias();
		
		estudiantes est4 = new estudiantes();
		est4 = (estudiantes) sesion.get(estudiantes.class, 5);
		estancias4.setestudianteobj(est4);
		
		residencias residencias4 = new residencias();				
		residencias4 = (residencias) sesion.get(residencias.class, 4);
		estancias4.setresidenciaobj(residencias4);
		
		estancias4.setfechaInicio(formatoDelTexto.parse("01-07-2019"));
		estancias4.setfechaFin(formatoDelTexto.parse("01-08-2020"));
		estancias4.setpreciopagado((short)525);
		
		
		sesion.persist(estancias4);
		
		sesion.getTransaction().commit();
		//tx.commit();
		
		}
	catch (Exception e)
		{
		System.out.println("No se puede insertar Datos: "+ e.getMessage());
		sesion.getTransaction().rollback();
		//tx.rollback();
		}	
	}
	
	private static void EliminarResidencia(Session sesion) {
		Transaction tx = null;
		
		try 
		{Scanner sc = new Scanner(System.in);
			
		System.out.println("Codigo de residencia:");
		String codResidencia = sc.nextLine();
					
		if (isNumeric(codResidencia) == true)
			{
			tx = sesion.beginTransaction();
			
			residencias residencia = new residencias();

			residencia=(residencias) sesion.get(residencias.class, Integer.parseInt(codResidencia));  // es el identificador de la residencia que elimina
			
			if (residencia ==null)
				{sesion.getTransaction().commit();
			
				System.out.println("Residencia no existe.");
			
				return;
				}
			
			if (residencia.getresidenciasobservacion() == null)
				{// Eliminamos la residencia con sus estancias, la residencia no tiene observaci�n. 
				sesion.remove(residencia);}
			else
				{// Eliminamos la observaci�n de la residencia, no se puede eliminar directamente la residencia con su observaci�n 
				// se eliminar� la observaci�n de la residencia y despu�s la residencia con sus estancias.
				residenciasobservaciones residenciaobservacion = residencia.getresidenciasobservacion();
				sesion.remove(residenciaobservacion);}
		
			tx.commit();
			
			System.out.println("Residencia borrada.");
			}
		else
			{
			System.out.println("Codigo de residencia debe ser númerico.");
			}
		}
	catch (Exception e)
		{
		System.out.println("No se puede eliminar esa residencia: "+ e.getMessage());
		tx.rollback();
		}
	}
	
	
	private static void ActualizarResidencia(Session sesion) {

		try 
		{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Codigo de residencia:");
		String codResidencia = sc.nextLine();
					
		if (isNumeric(codResidencia) == true)
			{
			sesion.beginTransaction();
			residencias residencia = new residencias();
			residencia=(residencias) sesion.get(residencias.class, Integer.parseInt(codResidencia));
			
			if (residencia ==null)
				{sesion.getTransaction().commit();
				
				System.out.println("Residencia no existe.");
				
				return;
				}
			
			System.out.println("Nombre Residencia: "+residencia.getnomResidencia());
			System.out.println("Código Universidad: "+residencia.geteuniversidadobj().getcodUniversidad());
			System.out.println("Nombre Universidad: "+residencia.geteuniversidadobj().getnomUniversidad());
			System.out.println("Precio Mensual: "+residencia.getprecioMensual());
			System.out.println("Comedor: "+residencia.getComedor());
				
			if (residencia.getresidenciasobservacion() == null )	{
				System.out.println("Sin Observaci�n. ");
				}
			else
				System.out.println("Observacion : " + residencia.getresidenciasobservacion().getobservaciones());
			
			System.out.println("Rellena solo los campos a modificar:");
				
			System.out.println("Nombre Residencia:");
			String nomResidencia = sc.nextLine();
			if (!nomResidencia.equals(""))
				{residencia.setnomResidencia(nomResidencia);
				}
			
			System.out.println("Código Universidad:");
			String codUniversidad = sc.nextLine();
			if (!codUniversidad.equals(""))
				{
				universidades universidad = new universidades();
				universidad=(universidades) sesion.get(universidades.class, codUniversidad);
				
				if (universidad ==null)
					{sesion.getTransaction().commit();
					
					System.out.println("Universidad no existe.");
					
					return;
					}
				
				residencia.setuniversidadobj(universidad);
				}
			
			System.out.println("Precio Mensual:");
			String precioMensual= sc.nextLine();
				
			if ((!precioMensual.equals("")) &&  (isNumeric(precioMensual) == true))
				{residencia.setprecioMensual(Short.valueOf(precioMensual));
				}
						
			System.out.println("Comedor (True/False):");
			String Comedor= sc.nextLine();
						
			if (!Comedor.equals("") && ((Comedor.toLowerCase().equals("true")) || (Comedor.toLowerCase().equals("false")))) 
				{residencia.setComedor(Boolean.parseBoolean(Comedor));
				}
			
			if (residencia.getresidenciasobservacion() != null )	{
				System.out.println("Observación:");
				String observación= sc.nextLine();
				
				if (!observación.equals(""))
					{residencia.getresidenciasobservacion().setobservaciones(observación);
					}
				}
			
			sesion.merge(residencia);
			
			sesion.getTransaction().commit();
			
			System.out.println("Residencia actualizada.");
			}
		else
			{
			System.out.println("Codigo de residencia debe ser númerico.");
			}
	}
	catch (Exception e)
	{
		System.out.println("No se puede modificar esa residencia: "+ e.getMessage());
		sesion.getTransaction().rollback();
	}	
	}
	
	private static void VisualizarResidenciasObservaciones(Session sesion) {

		try 
		{
		System.out.println("--------------- Visualiza Residencias Observaciones ------------------");
		Query<residencias> q = sesion.createQuery("from residencias", residencias.class);
		List<residencias> listaResidencias = q.getResultList();
		 
		
		System.out.println("Hay " + listaResidencias.size() + " residencias en la base de datos");
		
		for(residencias r : listaResidencias)
			{
			System.out.println("Codigo residencia: " + r.getcodResidencia() ); 
			System.out.println("Nombre residencia: " + r.getnomResidencia() ); 
/*			System.out.println("Codigo universidad: " + r.getuniversidad() ); */
			System.out.println("Codigo universidad: " + r.geteuniversidadobj().getcodUniversidad() );
			System.out.println("Precio residencia: " + r.getprecioMensual() );
			
			if (r.getComedor()==true )
				{System.out.println("Comedor: SI"); 
				}
			else
				{System.out.println("Comedor: NO"); 	
				}
					
			residenciasobservaciones ro = new residenciasobservaciones();
			ro = (residenciasobservaciones) sesion.get(residenciasobservaciones.class, r.getcodResidencia());
			
			if (ro == null )	
					{
					System.out.println("Sin Observación. ");
					}
				else
					System.out.println("Observacion : " + ro.getobservaciones() );
			
			System.out.println("");
			}
		}
	catch (Exception e)
		{
		System.out.println("No se puede visualizar Residencias Observaciones: "+ e.getMessage());
		}	
	}
	
	private static void VisualizarResidenciasEstanciasEstudiantesUniversidad(Session sesion) {

		try 
		{
		System.out.println("--------------- Visualiza Residencias Estancias Estudiantes Universidad ------------------");
		
		Query<residencias> q = sesion.createQuery("from residencias", residencias.class);
		List<residencias> listaResidencias = q.getResultList();
		System.out.println("Hay " + listaResidencias.size() + " residencias en la base de datos");
		
		for(residencias r : listaResidencias)
			{	
			System.out.println("Codigo residencia: " + r.getcodResidencia() ); 
			System.out.println("Nombre residencia: " + r.getnomResidencia() ); 
		
			System.out.println("Codigo universidad: " + r.geteuniversidadobj().getcodUniversidad() );
			System.out.println("Nombre universidad: " + r.geteuniversidadobj().getnomUniversidad() );
			
			System.out.println("Esta residencia tiene "+ r.getestancia().size() +" estancias:");
			
			for (estancias e :  r.getestancia())
				{
				System.out.println("DNI: " + e.getestudianteobj().getdni()); 	
				System.out.println("Nombre: " + e.getestudianteobj().getnomEstudiante()); 
							
				System.out.println("Estancia fecha inicio: " +e.getfechaInicio());
				System.out.println("Estancia fecha fin: "  +e.getfechaFin());
				System.out.println("Estancia precio pagado: " +e.getpreciopagado());
				System.out.println("");
				}
		System.out.println("");
		}
	}
	catch (Exception e)
		{
		System.out.println("No se puede visualizar Residencias Estancias Estudiante Universidad: "+ e.getMessage());
		}	
	}
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
}

	
