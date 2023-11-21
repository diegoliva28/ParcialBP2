package ar.edu.unlam.test;

import java.util.Objects;

public class Usuario implements Invitado,Agasajado, Organizador{

	private String mail;
	private String nombre;
	private Integer edad;
	private boolean asistenciaAEvento;
	
	public Usuario(String mail, String nombre, Integer edad) {
		this.mail = mail;
		this.nombre = nombre;
		this.edad = edad;
	}
	

	public String getMail() {
		return mail;
	}



	public String getNombre() {
		return nombre;
	}



	public Integer getEdad() {
		return edad;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}



	public boolean isAsistenciaAEvento() {
		return asistenciaAEvento;
	}


	public void setAsistenciaAEvento(boolean asistenciaAEvento) {
		this.asistenciaAEvento = asistenciaAEvento;
	}


	@Override
	public void confirmarAsistencia() {
		this.asistenciaAEvento=true;
	}

	@Override
	public Boolean asisteAEvento() {
		return this.asistenciaAEvento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(mail);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(mail, other.mail);
	}
	
	

}
