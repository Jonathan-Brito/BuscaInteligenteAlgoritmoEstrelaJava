/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscas;

import java.util.ArrayList;
import java.util.List;

import estruturas.Pilha;
import grafocidades.Adjacente;
import grafocidades.Cidade;
import grafocidades.Mapa;

/**
 *
 * @author Jonathan
 */
public class Profundidade {

	private Pilha fronteira;
	private Cidade inicio;
	private Cidade objetivo;
	private boolean achou;
	public List<String> caminhoCidades = new ArrayList<>();

	public Profundidade(Cidade inicio, Cidade objetivo) {
		this.inicio = inicio;
		this.inicio.setVisitado(true);
		this.objetivo = objetivo;

		fronteira = new Pilha(20);
		fronteira.empilhar(inicio);
		achou = false;
	}

	public List<String> buscar() {
		Cidade topo = fronteira.getTopo();
		System.out.println("Topo: " + topo.getNome());

		if (topo == objetivo) {
			achou = true;
		} else {
			for (Adjacente a : topo.getAdjacentes()) {
				if (!achou) {
					System.out.println("Verificando se já visitado: " + a.getCidade().getNome());
					if (!a.getCidade().isVisitado()) {
						a.getCidade().setVisitado(true);
						fronteira.empilhar(a.getCidade());

						/* Adiciona a cidade na lista de retorno */
						caminhoCidades.add(fronteira.getTopo().getNome());
						buscar();
					}
				}
			}
		}

		System.out.println("Desempilhou: " + fronteira.desempilhar().getNome());

		return caminhoCidades;

	}

}
