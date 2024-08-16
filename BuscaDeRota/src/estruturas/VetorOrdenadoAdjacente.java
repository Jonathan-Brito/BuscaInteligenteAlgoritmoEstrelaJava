/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import grafocidades.Adjacente;
import grafocidades.Cidade;
import grafocidades.Mapa;

/**
 *
 * @author Jonathan
 */
public class VetorOrdenadoAdjacente {
    private Adjacente[] adjacentes;
    private int numeroElementos;
    
    public VetorOrdenadoAdjacente(int tamanho) {
        adjacentes = new Adjacente[tamanho];
        numeroElementos = 0;
    }
    
    public void inserir(Adjacente adjacente) {
        int posicao;
        for (posicao = 0; posicao < numeroElementos; posicao++) {
            if (adjacentes[posicao].getDistanciaAEstrela() > adjacente.getDistanciaAEstrela()) {
                break;
            }
        }
        
        for (int k = numeroElementos; k > posicao; k--) {
            adjacentes[k] = adjacentes[k - 1];
        }
        
        adjacentes[posicao] = adjacente;
        numeroElementos++;
    }
    
    public Cidade getPrimeiro() {
        return adjacentes[0].getCidade();
    }
    
    public void mostrar() {
        for (int i = 0; i < numeroElementos; i++) {
            System.out.println(adjacentes[i].getCidade().getNome() + " - " + adjacentes[i].getDistanciaAEstrela());
        }
    }
}
