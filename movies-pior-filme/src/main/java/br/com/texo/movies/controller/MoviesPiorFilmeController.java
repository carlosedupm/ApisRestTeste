package br.com.texo.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.texo.movies.dto.ProdutorPremiado;
import br.com.texo.movies.dto.ProdutoresPremiados;
import br.com.texo.movies.service.MoviesPiorFilmeService;

@RestController
@RequestMapping(path = "filmes")
public class MoviesPiorFilmeController {

	@Autowired
	private MoviesPiorFilmeService service;
	
	@GetMapping()
	public ProdutoresPremiados consultarProdutorPremiados(){
		return service.consultarProdutorPremiados();
	}
	
	@GetMapping("/produtor-premiado-mais-rapido")
	public List<ProdutorPremiado> consultarProdutorPremiadosMaisRapido(){
		return service.consultarProdutorMaisRapido();
	}
	
	@GetMapping("/produtor-com-maior-intervalo")
	public List<ProdutorPremiado> consultarProdutorPremiadosComMaiorIntervalo() {
		return service.consultarProdutorComMaiorIntervalo();
		
	}
}
