package api.innocv.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="ROLES")
public class Rol {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
	private Integer id;
	
	@Column(name="ROL")
	private String rol;
	
	@Column(name="FECHA_CREACION")
	@CreationTimestamp
	private Date fechaCreacion;
	
	@Override
    public String toString() {
        return "Rol [id=" + id + "rol=" +rol+ ", fechaCreacion=" +fechaCreacion+ "]";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
