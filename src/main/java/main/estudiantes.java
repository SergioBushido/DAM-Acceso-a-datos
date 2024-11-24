package main;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import javax.persistence.*;
import jakarta.persistence.*;


@Entity
@Table(name="estudiantes")
public class estudiantes {
	
	@Id
	@Column ( columnDefinition= "integer")
	Integer codEstudiante ;
	@Column ( columnDefinition= "varchar(9)")
	String 	dni ; 
	@Column ( columnDefinition= "varchar(50)")
	String 	nomEstudiante ; 
	@Column ( columnDefinition= "varchar(9)")
	String telefonoEstudiante ; 
	
	@OneToMany (cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER , mappedBy="estudianteobj")
	//@JoinColumn(name="codEstudiante")
	List<estancias> estancia = new ArrayList<estancias>(); 
	
	public Integer getcodEstudiante() {
		return codEstudiante;
	}
	public void setcodEstudiante(Integer codEstudiante) {
		this.codEstudiante = codEstudiante;
	}
	
	public String getnomEstudiante() {
		return nomEstudiante;
	}
	public void setestudiante(String nomEstudiante) {
		this.nomEstudiante = nomEstudiante;
	}
	
	public String getdni() {
		return dni;
	}
	public void setdni(String dni) {
		this.dni = dni;
	}
	
	public String gettelefonoEstudiante() {
		return telefonoEstudiante;
	}
	public void settelefonoEstudiante(String telefonoEstudiante) {
		this.telefonoEstudiante = telefonoEstudiante;
	}
	
	public List<estancias> getestancia() {
		return estancia;
	}
	public void setestancia(List<estancias> estancia) {
		this.estancia = estancia;
	}
	
}
