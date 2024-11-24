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
@Table(name="residencias")
public class residencias {
	@Id
	@Column ( columnDefinition= "integer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer codResidencia ;
	@Column ( columnDefinition= "varchar(30)")
	String 	nomResidencia ; 
	/*@Column ( columnDefinition= "char(6)")
	String 	codUniversidad ;*/
	@Column ( columnDefinition= "SmallInt")
	short precioMensual ; 
	@Column ( columnDefinition= "bit")
	boolean Comedor ; 
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@PrimaryKeyJoinColumn //no crea el campo 
	private residenciasobservaciones residenciasobservacion;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="residenciaobj" )
	//@JoinColumn(name="codResidencia")
	List<estancias> estancia = new ArrayList<estancias>(); 
	
	@ManyToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.EAGER )
	@JoinColumn(name="codUniversidad")
	private universidades universidadobj;
	
	public Integer getcodResidencia() {
		return codResidencia;
	}
	public void setcodResidencia(Integer codResidencia) {
		this.codResidencia = codResidencia;
	}
	
	public String getnomResidencia() {
		return nomResidencia;
	}
	public void setnomResidencia(String nomResidencia) {
		this.nomResidencia = nomResidencia;
	}
	
	/*public String getuniversidad() {
		return codUniversidad;
	}
	public void setuniversidad(String codUniversidad) {
		this.codUniversidad = codUniversidad;
	}*/
	
	public short getprecioMensual() {
		return precioMensual;
	}
	public void setprecioMensual(short precioMensual) {
		this.precioMensual = precioMensual;
	}
	
	public boolean getComedor() {
	return Comedor;
	}
	public void setComedor(boolean Comedor) {
		this.Comedor = Comedor;
	}
	
	public residenciasobservaciones getresidenciasobservacion() {
		return residenciasobservacion;
	}
	public void setresidenciasobservacion(residenciasobservaciones residenciasobservacion) {
		this.residenciasobservacion = residenciasobservacion;
	}
	
	public List<estancias> getestancia() {
		return estancia;
	}
	public void setestancia(List<estancias> estancia) {
		this.estancia = estancia;
	}
	
	public universidades geteuniversidadobj() {
		return universidadobj;
	}
	public void setuniversidadobj(universidades universidadobj) {
		this.universidadobj = universidadobj;
	}
}
