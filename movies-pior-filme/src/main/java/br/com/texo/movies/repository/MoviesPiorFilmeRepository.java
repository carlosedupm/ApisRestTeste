package br.com.texo.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.texo.movies.dto.ProdutorPremiado;
import br.com.texo.movies.model.MoviesPiorFilme;

public interface MoviesPiorFilmeRepository extends JpaRepository<MoviesPiorFilme, Long>{

	@Query("Select new br.com.texo.movies.dto.ProdutorPremiado(max(m.producers), max(m.year) - min(m.year), min(m.year) ,max(m.year) )"
			+ "FROM MoviesPiorFilme m "
			+ "WHERE m.winner  = 'yes' "
			+ "group by m.producers "
			+ "having max(m.year) - min(m.year) = 1 "
			+ "order by max(m.year) - min(m.year) asc")
	List<ProdutorPremiado> findProdutorDoisPremiosMaisRapidos();
	@Query("Select new br.com.texo.movies.dto.ProdutorPremiado(max(m.producers), max(m.year) - min(m.year), min(m.year) ,max(m.year) )"
			+ "FROM MoviesPiorFilme m "
			+ "WHERE m.winner  = 'yes' "
			+ "group by m.producers "
			+ "having max(m.year) - min(m.year) > 1 "
			+ "order by max(m.year) - min(m.year) asc")
	List<ProdutorPremiado> findProdutorDoisPremiosMaiorIntervalo();

}
