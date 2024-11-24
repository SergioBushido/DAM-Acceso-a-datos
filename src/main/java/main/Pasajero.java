package main;

import jakarta.persistence.*;

@Entity
@Table(name = "pasajeros")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM") // La columna "NUM" es la clave primaria
    private int num;

    @Column(name = "COD_VUELO") // Relación con "COD_VUELO" en la tabla "vuelos"
    private String codVuelo;

    @Column(name = "TIPO_PLAZA")
    private String tipoPlaza;

    @Column(name = "FUMADOR")
    private String fumador;

    // Constructor vacío
    public Pasajero() {}

    // Constructor con parámetros
    public Pasajero(int num, String codVuelo, String tipoPlaza, String fumador) {
        this.num = num;
        this.codVuelo = codVuelo;
        this.tipoPlaza = tipoPlaza;
        this.fumador = fumador;
    }

    // Getters y setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public String getTipoPlaza() {
        return tipoPlaza;
    }

    public void setTipoPlaza(String tipoPlaza) {
        this.tipoPlaza = tipoPlaza;
    }

    public String getFumador() {
        return fumador;
    }

    public void setFumador(String fumador) {
        this.fumador = fumador;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Pasajero{" +
               "num=" + num +
               ", codVuelo='" + codVuelo + '\'' +
               ", tipoPlaza='" + tipoPlaza + '\'' +
               ", fumador='" + fumador + '\'' +
               '}';
    }
}
