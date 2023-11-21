package ar.edu.unlam.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cumpleaños extends Evento {

	private final Integer CANTIDAD_DE_AGASAJADOS=1;
	
//	public Cumpleaños(String nombre, Organizador organizador, HashSet<Agasajado> agasajados,
//			ArrayList<Invitado> invitados) {
//		super(nombre, organizador, agasajados, invitados);
//	}

	public Cumpleaños(Agasajado agasajado) {
		this.add(agasajado);
	}

	@Override
	public void add(Agasajado nuevo) {
		if(getAgasajados().size()<this.CANTIDAD_DE_AGASAJADOS) {
			getAgasajados().add(nuevo);
		}
	}
	
	public Set<Usuario> cantidadDeAgasajados(Agasajado nuevo) {
			HashSet<Usuario> agasajados=super.obtenerAgasajados();
			return agasajados;
			
	}
	
	
	
	

}
