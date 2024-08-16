package grafocidades;

import java.io.Serializable;

public class MethodVO implements Serializable {

	private String cidadeInicial;
	private String cidadeDestino;
	private Integer metodo;

	public String getCidadeInicial() {
		return cidadeInicial;
	}

	public void setCidadeInicial(String cidadeInicial) {
		this.cidadeInicial = cidadeInicial;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public Integer getMetodo() {
		return metodo;
	}

	public void setMetodo(Integer metodo) {
		this.metodo = metodo;
	}

}
