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
@Table(name="universidades")
public class universidades {
	@Id
	@Column ( columnDefinition= "char(6)")
	String 	codUniversidad ; 
	@Column ( columnDefinition= "varchar(30)")
	String nomUniversidad ; 
	
	@OneToMany (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.EAGER, mappedBy="universidadobj" )
	//@JoinColumn(name="codUniversidad")
	List<residencias> residencia = new ArrayList<residencias>(); 
		
	public String getcodUniversidad() {
		return codUniversidad;
	}
	public void setcodUniversidad(String codUniversidad) {
		this.codUniversidad = codUniversidad;
	}
	
	public String getnomUniversidad() {
		return nomUniversidad;
	}
	public void setnomUniversidad(String nomUniversidad) {
		this.nomUniversidad = nomUniversidad;
	}
	
	public List<residencias> getresidencia() {
		return residencia;
	}
	public void setresidencia(List<residencias> residencia) {
		this.residencia = residencia;
	}
}
