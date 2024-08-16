/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafocidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class Mapa implements Serializable {
	private Cidade portoUniao;
	private Cidade pauloFrontin;
	private Cidade canoinhas;
	private Cidade irati;
	private Cidade palmeira;
	private Cidade campoLargo;
	private Cidade curitiba;
	private Cidade balsaNova;
	private Cidade araucaria;
	private Cidade saoJose;
	private Cidade contenda;
	private Cidade mafra;
	private Cidade tijucas;
	private Cidade lapa;
	private Cidade saoMateus;
	private Cidade tresBarras;
	private List<Cidade> listCidades;

	public Mapa() {
		listCidades = new ArrayList<>();
		portoUniao = new Cidade("Porto União", 203);
		pauloFrontin = new Cidade("Paulo Frontin", 172);
		canoinhas = new Cidade("Canoinhas", 141);
		irati = new Cidade("Irati", 139);
		palmeira = new Cidade("Palmeira", 59);
		campoLargo = new Cidade("Campo Largo", 27);
		curitiba = new Cidade("Curitiba", 0);
		balsaNova = new Cidade("Balsa Nova", 41);
		araucaria = new Cidade("Araucária", 23);
		saoJose = new Cidade("São José dos Pinhais", 13);
		contenda = new Cidade("Contenda", 39);
		mafra = new Cidade("Mafra", 94);
		tijucas = new Cidade("Tijucas do Sul", 56);
		lapa = new Cidade("Lapa", 74);
		saoMateus = new Cidade("São Mateus do Sul", 123);
		tresBarras = new Cidade("Três Barras", 131);

		portoUniao.addCidadeAdjacente(new Adjacente(pauloFrontin, 46));
		portoUniao.addCidadeAdjacente(new Adjacente(canoinhas, 78));
		portoUniao.addCidadeAdjacente(new Adjacente(saoMateus, 87));
		listCidades.add(portoUniao);

		pauloFrontin.addCidadeAdjacente(new Adjacente(portoUniao, 46));
		pauloFrontin.addCidadeAdjacente(new Adjacente(irati, 75));
		listCidades.add(pauloFrontin);

		canoinhas.addCidadeAdjacente(new Adjacente(portoUniao, 78));
		canoinhas.addCidadeAdjacente(new Adjacente(tresBarras, 12));
		canoinhas.addCidadeAdjacente(new Adjacente(mafra, 66));
		listCidades.add(canoinhas);

		irati.addCidadeAdjacente(new Adjacente(pauloFrontin, 75));
		irati.addCidadeAdjacente(new Adjacente(palmeira, 75));
		irati.addCidadeAdjacente(new Adjacente(saoMateus, 57));
		listCidades.add(irati);

		palmeira.addCidadeAdjacente(new Adjacente(irati, 75));
		palmeira.addCidadeAdjacente(new Adjacente(saoMateus, 77));
		palmeira.addCidadeAdjacente(new Adjacente(campoLargo, 55));
		listCidades.add(palmeira);

		campoLargo.addCidadeAdjacente(new Adjacente(palmeira, 55));
		campoLargo.addCidadeAdjacente(new Adjacente(balsaNova, 22));
		campoLargo.addCidadeAdjacente(new Adjacente(curitiba, 29));
		listCidades.add(campoLargo);

		curitiba.addCidadeAdjacente(new Adjacente(campoLargo, 29));
		curitiba.addCidadeAdjacente(new Adjacente(balsaNova, 51));
		curitiba.addCidadeAdjacente(new Adjacente(araucaria, 37));
		curitiba.addCidadeAdjacente(new Adjacente(saoJose, 15));
		listCidades.add(curitiba);

		balsaNova.addCidadeAdjacente(new Adjacente(curitiba, 51));
		balsaNova.addCidadeAdjacente(new Adjacente(campoLargo, 22));
		balsaNova.addCidadeAdjacente(new Adjacente(contenda, 19));
		listCidades.add(balsaNova);

		araucaria.addCidadeAdjacente(new Adjacente(curitiba, 37));
		araucaria.addCidadeAdjacente(new Adjacente(contenda, 18));
		listCidades.add(araucaria);

		saoJose.addCidadeAdjacente(new Adjacente(curitiba, 15));
		saoJose.addCidadeAdjacente(new Adjacente(tijucas, 49));
		listCidades.add(saoJose);

		contenda.addCidadeAdjacente(new Adjacente(balsaNova, 19));
		contenda.addCidadeAdjacente(new Adjacente(araucaria, 18));
		contenda.addCidadeAdjacente(new Adjacente(lapa, 26));
		listCidades.add(contenda);

		mafra.addCidadeAdjacente(new Adjacente(tijucas, 99));
		mafra.addCidadeAdjacente(new Adjacente(lapa, 57));
		mafra.addCidadeAdjacente(new Adjacente(canoinhas, 66));
		listCidades.add(mafra);

		tijucas.addCidadeAdjacente(new Adjacente(mafra, 99));
		tijucas.addCidadeAdjacente(new Adjacente(saoJose, 49));
		listCidades.add(tijucas);

		lapa.addCidadeAdjacente(new Adjacente(contenda, 26));
		lapa.addCidadeAdjacente(new Adjacente(saoMateus, 60));
		lapa.addCidadeAdjacente(new Adjacente(mafra, 57));
		listCidades.add(lapa);

		saoMateus.addCidadeAdjacente(new Adjacente(palmeira, 77));
		saoMateus.addCidadeAdjacente(new Adjacente(irati, 57));
		saoMateus.addCidadeAdjacente(new Adjacente(lapa, 60));
		saoMateus.addCidadeAdjacente(new Adjacente(tresBarras, 43));
		saoMateus.addCidadeAdjacente(new Adjacente(portoUniao, 87));
		listCidades.add(saoMateus);

		tresBarras.addCidadeAdjacente(new Adjacente(saoMateus, 43));
		tresBarras.addCidadeAdjacente(new Adjacente(canoinhas, 12));
		listCidades.add(tresBarras);
	}

	public Cidade getPortoUniao() {
		return portoUniao;
	}

	public void setPortoUniao(Cidade portoUniao) {
		this.portoUniao = portoUniao;
	}

	public Cidade getPauloFrontin() {
		return pauloFrontin;
	}

	public void setPauloFrontin(Cidade pauloFrontin) {
		this.pauloFrontin = pauloFrontin;
	}

	public Cidade getCanoinhas() {
		return canoinhas;
	}

	public void setCanoinhas(Cidade canoinhas) {
		this.canoinhas = canoinhas;
	}

	public Cidade getIrati() {
		return irati;
	}

	public void setIrati(Cidade irati) {
		this.irati = irati;
	}

	public Cidade getPalmeira() {
		return palmeira;
	}

	public void setPalmeira(Cidade palmeira) {
		this.palmeira = palmeira;
	}

	public Cidade getCampoLargo() {
		return campoLargo;
	}

	public void setCampoLargo(Cidade campoLargo) {
		this.campoLargo = campoLargo;
	}

	public Cidade getCuritiba() {
		return curitiba;
	}

	public void setCuritiba(Cidade curitiba) {
		this.curitiba = curitiba;
	}

	public Cidade getBalsaNova() {
		return balsaNova;
	}

	public void setBalsaNova(Cidade balsaNova) {
		this.balsaNova = balsaNova;
	}

	public Cidade getAraucaria() {
		return araucaria;
	}

	public void setAraucaria(Cidade araucaria) {
		this.araucaria = araucaria;
	}

	public Cidade getSaoJose() {
		return saoJose;
	}

	public void setSaoJose(Cidade saoJose) {
		this.saoJose = saoJose;
	}

	public Cidade getContenda() {
		return contenda;
	}

	public void setContenda(Cidade contenda) {
		this.contenda = contenda;
	}

	public Cidade getMafra() {
		return mafra;
	}

	public void setMafra(Cidade mafra) {
		this.mafra = mafra;
	}

	public Cidade getTijucas() {
		return tijucas;
	}

	public void setTijucas(Cidade tijucas) {
		this.tijucas = tijucas;
	}

	public Cidade getLapa() {
		return lapa;
	}

	public void setLapa(Cidade lapa) {
		this.lapa = lapa;
	}

	public Cidade getSaoMateus() {
		return saoMateus;
	}

	public void setSaoMateus(Cidade saoMateus) {
		this.saoMateus = saoMateus;
	}

	public Cidade getTresBarras() {
		return tresBarras;
	}

	public void setTresBarras(Cidade tresBarras) {
		this.tresBarras = tresBarras;
	}

	public List<Cidade> getListCidades() {
		return listCidades;
	}

	public void setListCidades(List<Cidade> listCidades) {
		this.listCidades = listCidades;
	}

}
