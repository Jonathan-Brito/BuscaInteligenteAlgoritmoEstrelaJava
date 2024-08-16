/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscas;

import java.util.ArrayList;
import java.util.List;

import estruturas.VetorOrdenadoAdjacente;
import grafocidades.Adjacente;
import grafocidades.Cidade;
import grafocidades.Mapa;

/**
 *
 * @author Jonathan
 */
public class AEstrela {
	private VetorOrdenadoAdjacente fronteira;
	private Cidade objetivo;
	private boolean achou;
	public List<String> caminhoCidades = new ArrayList<>();

	public AEstrela(Cidade objetivo) {
		this.objetivo = objetivo;
		achou = false;
	}

	public List<String> buscar(Cidade atual) {

		atual.setVisitado(true);

		if (atual == objetivo) {
			achou = true;
		} else {
			fronteira = new VetorOrdenadoAdjacente(atual.getAdjacentes().size());
			for (Adjacente a : atual.getAdjacentes()) {
				if (!a.getCidade().isVisitado()) {
					a.getCidade().setVisitado(true);
					fronteira.inserir(a);
				}
			}
			fronteira.mostrar();
			if (fronteira.getPrimeiro() != null) {
				caminhoCidades.add(fronteira.getPrimeiro().getNome());
				buscar(fronteira.getPrimeiro());
			}
		}

		return caminhoCidades;
	}

}
