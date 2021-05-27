package api.innocv.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="USUARIOS")
@Proxy(lazy = false) 
public class User implements Serializable{
	
	
	private static final long serialVersionUID = -2214121640953591525L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	@NotEmpty(message = "Debe de insertar un nombre")
	private String name;
	
	
	@Column(name="BIRTHDATE")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Debe de insertar una fecha de nacimiento")
	@PastOrPresent
	private Date birthdate;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}
