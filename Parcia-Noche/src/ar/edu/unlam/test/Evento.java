package ar.edu.unlam.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public abstract class Evento {
	private String nombre;
	private Organizador organizador;
	private HashSet<Agasajado> agasajados;
//	private HashSet<Usuario> agasajados;
	private ArrayList<Invitado> invitados;
	
	public Evento(String nombre, Organizador organizador) {
		super();
		this.nombre = nombre;
		this.organizador = organizador;
		this.agasajados = new HashSet<Agasajado>();
		this.invitados = new ArrayList<Invitado>();
	}
//
//	public Evento(String nombre, Organizador organizador, HashSet<Agasajado> agasajados, ArrayList<Invitado> invitados) {
//		super();
//		this.nombre = nombre;
//		this.organizador = organizador;
//		this.agasajados = agasajados;
//		this.invitados = invitados;
//	}
	
	public Evento() {
//		this.nombre=nombre;
		this.organizador=null;
		this.agasajados = new HashSet<Agasajado>();
//		this.agasajados = new HashSet<Usuario>();
		this.invitados = new ArrayList<Invitado>();
	}

	public abstract void add(Agasajado nuevo);
	
	public String getNombre() {
		return nombre;
	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public HashSet<Agasajado> getAgasajados() {
		return this.agasajados;
	}
	
	public HashSet<Usuario> obtenerAgasajados() {
		HashSet<Usuario> agasajados=new HashSet<>();
		//Anotar bien el nombre de las variables
		for (Agasajado agasajado : this.agasajados) {
			if(agasajado instanceof Usuario) {
				agasajados.add((Usuario) agasajado);
			}
		}
		return agasajados;
	}

	public ArrayList<Invitado> getInvitados() {
		return invitados;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	public void setAgasajados(HashSet<Agasajado> agasajados) {
		this.agasajados = agasajados;
	}

	public void setInvitados(ArrayList<Invitado> invitados) {
		this.invitados = invitados;
	}

	public void agregarInvitado(Usuario usuario) {
		this.invitados.add(usuario);
	}

	public void confirmarAsistencia(Usuario usuario) {
		Integer posicion=this.invitados.indexOf(usuario);
		this.invitados.get(posicion).confirmarAsistencia();
		}

	public Integer getInvitadosConfirmados() {
		Integer confirmados=0;
		for (Invitado invitados :this.invitados) {
			if(invitados.asisteAEvento()) {
				confirmados++;
			}
		}
		return confirmados;
	}
	
	public ArrayList<Invitado> getListaDeInvitadosOrdenados() {
		TreeSet<Invitado> invitados= new TreeSet<>(new OrdenarPorNombre());
		invitados.addAll(this.invitados);
		ArrayList<Invitado> nuevoArrayList=new ArrayList<>(invitados);
		
		return nuevoArrayList;
	}
}