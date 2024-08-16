/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscas;

import java.util.ArrayList;
import java.util.List;

import estruturas.Fila;
import grafocidades.Adjacente;
import grafocidades.Cidade;
import grafocidades.Mapa;

/**
 *
 * @author Jonathan
 */
public class Largura {

	private Fila fronteira;
	private Cidade inicio;
	private Cidade objetivo;
	private boolean achou;
	public List<String> caminhoCidades = new ArrayList<>();

	public Largura(Cidade inicio, Cidade objetivo) {
		this.inicio = inicio;
		this.inicio.setVisitado(true);
		this.objetivo = objetivo;

		fronteira = new Fila(20);
		fronteira.enfileirar(inicio);
		achou = false;
	}

	public List<String> buscar() {
		Cidade primeiro = fronteira.getPrimeiro();
		System.out.println("Primeiro: " + primeiro.getNome());

		if (primeiro == objetivo) {
			achou = true;
		} else {
			System.out.println("Desenfileirou: " + fronteira.desenfileirar().getNome());
			for (Adjacente a : primeiro.getAdjacentes()) {
				System.out.println("Verificando se já visitado: " + a.getCidade().getNome());
				if (!a.getCidade().isVisitado()) {
					a.getCidade().setVisitado(true);
					fronteira.enfileirar(a.getCidade());
				}
			}
			if (fronteira.getNumeroElementos() > 0) {

				caminhoCidades.add(fronteira.getPrimeiro().getNome());
				buscar();
			}
		}

		return caminhoCidades;
	}

	public static void main(String args[]) {
		Mapa mapa = new Mapa();
		Largura l = new Largura(mapa.getPortoUniao(), mapa.getIrati());
		l.buscar();
	}
}
