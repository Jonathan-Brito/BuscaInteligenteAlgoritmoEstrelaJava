package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import buscas.AEstrela;
import grafocidades.Cidade;
import grafocidades.Mapa;
import grafocidades.MethodVO;

@Path("/buscar")
public class ServicesBuscas {

	@GET
	@Path("/buscarRota")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> buscarRotas() {

		/*
		 * Método que será responsável por chamar os metodos de busca
		 * 
		 * AEstrela Gulosa Largura Profundidade
		 * 
		 */
		Mapa mapa = new Mapa();
		AEstrela a = new AEstrela(mapa.getCuritiba());
		List<String> list = a.buscar(mapa.getPortoUniao());
		for (int i = 0; i < list.size(); i++) {
            System.out.println("bbbb");
            System.out.println("aaaa"+ list.get(i));
        }

		return list;

	}

}
