package ar.edu.unlam.test;

import java.util.Comparator;

public class OrdenarPorNombre implements Comparator<Invitado>{

	@Override
	public int compare(Invitado o1, Invitado o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
