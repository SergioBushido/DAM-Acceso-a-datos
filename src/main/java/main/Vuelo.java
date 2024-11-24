package main;

import jakarta.persistence.*;

@Entity
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @Column(name = "COD_VUELO")
    private String codVuelo;

    @Column(name = "HORA_SALIDA")
    private String horaSalida;

    @Column(name = "DESTINO")
    private String destino;

    @Column(name = "PROCEDENCIA")
    private String procedencia;

    @Column(name = "PLAZAS_FUMADOR")
    private int plazasFumador;

    @Column(name = "PLAZAS_NO_FUMADOR")
    private int plazasNoFumador;

    @Column(name = "PLAZAS_TURISTA")
    private int plazasTurista;

    @Column(name = "PLAZAS_PRIMERA")
    private int plazasPrimera;

    // Constructor vacío (requerido por Hibernate)
    public Vuelo() {}

    // Constructor con todos los parámetros
    public Vuelo(String codVuelo, String horaSalida, String destino, String procedencia,
                 int plazasFumador, int plazasNoFumador, int plazasTurista, int plazasPrimera) {
        this.codVuelo = codVuelo;
        this.horaSalida = horaSalida;
        this.destino = destino;
        this.procedencia = procedencia;
        this.plazasFumador = plazasFumador;
        this.plazasNoFumador = plazasNoFumador;
        this.plazasTurista = plazasTurista;
        this.plazasPrimera = plazasPrimera;
    }

    // Getters y setters
    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public int getPlazasFumador() {
        return plazasFumador;
    }

    public void setPlazasFumador(int plazasFumador) {
        this.plazasFumador = plazasFumador;
    }

    public int getPlazasNoFumador() {
        return plazasNoFumador;
    }

    public void setPlazasNoFumador(int plazasNoFumador) {
        this.plazasNoFumador = plazasNoFumador;
    }

    public int getPlazasTurista() {
        return plazasTurista;
    }

    public void setPlazasTurista(int plazasTurista) {
        this.plazasTurista = plazasTurista;
    }

    public int getPlazasPrimera() {
        return plazasPrimera;
    }

    public void setPlazasPrimera(int plazasPrimera) {
        this.plazasPrimera = plazasPrimera;
    }
}
