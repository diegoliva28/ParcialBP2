package ar.edu.unlam.test;

public class Casamiento extends Evento {

	private final Integer CANTIDAD_DE_AGASAJADOS=2;
	
	@Override
	public void add(Agasajado nuevo) {
		if(getAgasajados().size()<this.CANTIDAD_DE_AGASAJADOS) {
			getAgasajados().add(nuevo);
		}
	}

}
