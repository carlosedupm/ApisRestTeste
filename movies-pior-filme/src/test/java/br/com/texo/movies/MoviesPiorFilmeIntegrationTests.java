package br.com.texo.movies;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.texo.movies.dto.ProdutoresPremiados;
import br.com.texo.movies.service.MoviesPiorFilmeService;

@SpringBootTest
class MoviesPiorFilmeIntegrationTests {

	@Autowired
	private MoviesPiorFilmeService service;
	
	@Test
	public void deveConsultarProdutorComMaiorIntervaloEntreDoisPremiosConsecutivosComDoisPremiosMaisRapido_QuandoRetornoComSucesso() {
		ProdutoresPremiados produtorPremiados = service.consultarProdutorPremiados();
		assertThat(produtorPremiados).isNotNull();
		assertThat(produtorPremiados.getMin().size()).isNotNull();
		assertThat(produtorPremiados.getMax().size()).isNotNull();
	}
	
	@Test
	public void deveConsultarProdutor_QuandoMinimoComIntervaloUm() {
		ProdutoresPremiados produtorPremiados = service.consultarProdutorPremiados();
		assertThat(produtorPremiados).isNotNull();
		assertThat(produtorPremiados.getMin().size()).isEqualTo(1);
	}
	
	@Test
	public void deveConsultarProdutor_QuandoMaximoComIntervaloTreze() {
		ProdutoresPremiados produtorPremiados = service.consultarProdutorPremiados();
		assertThat(produtorPremiados).isNotNull();
		assertThat(produtorPremiados.getMax().size()).isEqualTo(13);
	}
	
	
	

}
