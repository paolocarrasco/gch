package pe.edu.cibertec.gch.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa a un docente de la institucion.
 */
@Entity
@Table(name="tprofesor")
public class Profesor implements Serializable {

    @Id
    @Column(name="profesor")
    private String codigo;
    @Column(name="nombre")   
    private String nombres;
    @Column(name="paterno")   
    private String apellidoPaterno;
    @Column(name="materno")
    private String apellidoMaterno;
    private String direccion;
    private String referencia;
    @Column(name="nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String sexo;
    @Column(name="estado")
    private String estadoCivil;

    public Profesor() {
    }

    public Profesor(String codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String referencia, Date fechaNacimiento, String sexo, String estadoCivil) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.referencia = referencia;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean esValido() {
        boolean profesorValido = true;
        if(nombres.trim().isEmpty()) {
            profesorValido = false;
        }
        else if(apellidoPaterno.trim().isEmpty()) {
            profesorValido = false;
        }
        else if(!(sexo.equalsIgnoreCase("m")) && !(sexo.equalsIgnoreCase("f"))) {
            profesorValido = false;
        }
        return profesorValido;
    }

}
