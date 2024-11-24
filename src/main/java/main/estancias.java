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
@Table(name = "estancias")
public class estancias {
		
		@Id
		@Column ( columnDefinition= "integer")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		Integer codEstancia;
			
		/*@Column ( columnDefinition= "integer")
		Integer codEstudiante ;*/
		
		/*@Column ( columnDefinition= "integer")
		Integer codResidencia ;*/
		
		@Column ( columnDefinition= "date")
		Date fechaInicio ;
		
		@Column ( columnDefinition= "date")
		Date 	fechaFin ; 
				
		@Column ( columnDefinition= "SmallInt")
		short 	preciopagado ; 
		
		@ManyToOne (cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER )
		@JoinColumn(name="codEstudiante")
		private estudiantes estudianteobj;
		
		@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name="codResidencia")
		private residencias residenciaobj;
		
		public Integer getcodEstancia() {
			return codEstancia;
		}
		public void setcodEstancia(Integer codEstancia) {
			this.codEstancia = codEstancia;
		}
		
		/*public Integer getcodEstudiante() {
			return codEstudiante;
		}
		public void setcodEstudiante(Integer codEstudiante) {
			this.codEstudiante = codEstudiante;
		}*/
		
		/*public Integer getcodResidencia() {
			return codResidencia;
		}
		public void setcodResidencia(Integer codResidencia) {
			this.codResidencia = codResidencia;
		}*/
		
		public Date getfechaInicio() {
			return fechaInicio;
		}
		public void setfechaInicio(Date fecha) {
			this.fechaInicio = fecha;
		}
		
		public Date getfechaFin() {
			return fechaFin;
		}
		public void setfechaFin(Date fechaFin) {
			this.fechaFin = fechaFin;
		}
		
		public short getpreciopagado() {
			return preciopagado;
		}
		public void setpreciopagado(short preciopagado) {
			this.preciopagado = preciopagado;
		}
		
		public estudiantes getestudianteobj() {
			return estudianteobj;
		}
		public void setestudianteobj(estudiantes estudianteobj) {
			this.estudianteobj = estudianteobj;
		}
		
		public residencias getresidenciaobj() {
			return residenciaobj;
		}
		public void setresidenciaobj(residencias residenciaobj) {
			this.residenciaobj = residenciaobj;
		}
	}

