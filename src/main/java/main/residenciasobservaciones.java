package main;

import java.text.DecimalFormat;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;


@Entity
@Table(name="residenciasobservaciones")
public class residenciasobservaciones {
	@Id
	
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator( name = "myForeign",  strategy = "foreign",
	parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "ResidenciaXXX")})
	
	Integer codResidencia ;
	
	@Column ( columnDefinition= "varchar(200)")
	String 	observaciones ; 
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	/*cascade={CascadeType.PERSIST,CascadeType.REMOVE}*/
	@PrimaryKeyJoinColumn
	private residencias ResidenciaXXX;
	
	public Integer getcodResidencia() {
		return codResidencia;
	}
	public void setcodResidencia(Integer codResidencia) {
		this.codResidencia = codResidencia;
	}
	
	public String getobservaciones() {
		return observaciones;
	}
	public void setobservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public residencias getResidenciaXXX() {
		return ResidenciaXXX;
	}

	public void setResidenciaXXX(residencias ResidenciaXXX) {
		this.ResidenciaXXX = ResidenciaXXX;
	}
}
