package ar.edu.unlam.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlanificadorDeEventos {
	private HashSet<Usuario> usuarios;
	private Map<String, Evento> eventos;

	public PlanificadorDeEventos() {
		this.usuarios = new HashSet<Usuario>();
		this.eventos = new HashMap<String, Evento>();
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public Map<String, Evento> getEventos() {
		return eventos;
	}

	public void setUsuarios(HashSet<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setEventos(Map<String, Evento> eventos) {
		this.eventos = eventos;
	}

	public void add(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public Usuario getUsuario(String mailOrganizador) {
		for (Usuario usuario : usuarios) {
			if (usuario.getMail().equals(mailOrganizador)) {
				return usuario;
			}
		}
		return null;
	}

	public void crear(String nombreDelEvento, Evento evento) {
		this.eventos.put(nombreDelEvento, evento);
		this.usuarios.addAll(evento.obtenerAgasajados());
	}

	public Evento getEvento(String nombreDelEvento) {
		return this.eventos.get(nombreDelEvento);
	}

	public Integer getCantidadDeUsuarios() {
		return this.usuarios.size();
	}

	public Integer getCantidadDeEventos() {
		// TODO Auto-generated method stub
		return this.eventos.size();
	}

	public Integer getCantidadDeCumpleanios() {
		Integer cantidadDeCumpleaños = 0;

		for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
			Evento val = entry.getValue();
			if (val instanceof Cumpleaños) {
				cantidadDeCumpleaños++;
			}
		}
		return cantidadDeCumpleaños;
	}

	public Integer getCantidadDeCasamientos() {
		Integer cantidadDeCasamientos = 0;

		for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
			Evento val = entry.getValue();
			if (val instanceof Casamiento) {
				cantidadDeCasamientos++;
			}
		}
		return cantidadDeCasamientos;
	}

	public void invitar(Evento elCumpleDeLeo, Usuario usuario) {
		if (this.eventos.containsValue(elCumpleDeLeo)) {
			elCumpleDeLeo.agregarInvitado(usuario);
		}
	}

	public Integer getCantidadDeInvitados() {
		Integer cantidadDeInvitados= 0;

		for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
			Evento val = entry.getValue();
			cantidadDeInvitados+=val.getInvitados().size();
		}
		return cantidadDeInvitados;
	}

	public void confirmar(Evento evento, Usuario usuario) throws UsuarioNoInvitadoException {
		if (this.eventos.containsValue(evento)) {
			if(!evento.getInvitados().contains(usuario)) {
				throw new UsuarioNoInvitadoException();
			}
			
			evento.confirmarAsistencia(usuario);
	}

}

	public Integer getCantidadDeInvitadosConfirmados() {
		Integer cantidadDeConfirmados= 0;

		for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
			Evento val = entry.getValue();
			cantidadDeConfirmados+=val.getInvitadosConfirmados();
		}
		return cantidadDeConfirmados;
	}
}
