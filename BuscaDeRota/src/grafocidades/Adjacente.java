/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafocidades;

import java.io.Serializable;

/**
 *
 * @author Jonathan
 */
public class Adjacente implements Serializable {
	private Cidade cidade;
	private int distancia;
	private int distanciaAEstrela;

	public Adjacente(Cidade cidade, int distancia) {
		this.cidade = cidade;
		this.distancia = distancia;
		// Distância em linha reta + distância pela estrada
		this.distanciaAEstrela = this.cidade.getDistanciaObjetivo() + this.distancia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getDistanciaAEstrela() {
		return distanciaAEstrela;
	}

}
