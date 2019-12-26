/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author farias
 */
public class medicion {
    private String fecha;
    private int estatura;
    private int peso;
    private int medidaCintura;
    private float porcentajeGrasa;
    private float imc;
    private float indiceGrasaInstrumento;
    private String pathFoto;
    private String usuario;
    private String entrenador;
    private int id;
    public medicion(int id,String fecha, int estatura, int peso, int medidaCintura, float porcentajeGrasa, float imc, float indiceGrasaInstrumento, String pathFoto, String usuario, String entrenador) {
        this.id = id;
        this.fecha = fecha;
        this.estatura = estatura;
        this.peso = peso;
        this.medidaCintura = medidaCintura;
        this.porcentajeGrasa = porcentajeGrasa;
        this.imc = imc;
        this.indiceGrasaInstrumento = indiceGrasaInstrumento;
        this.pathFoto = pathFoto;
        this.usuario = usuario;
        this.entrenador = entrenador;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getMedidaCintura() {
        return medidaCintura;
    }

    public void setMedidaCintura(int medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public float getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(float porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public float getIndiceGrasaInstrumento() {
        return indiceGrasaInstrumento;
    }

    public void setIndiceGrasaInstrumento(float indiceGrasaInstrumento) {
        this.indiceGrasaInstrumento = indiceGrasaInstrumento;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }
    
    
    
}
