package br.com.texo.movies.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import br.com.texo.movies.dto.ProdutorPremiado;
import br.com.texo.movies.dto.ProdutoresPremiados;
import br.com.texo.movies.model.MoviesPiorFilme;
import br.com.texo.movies.opencsv.MoviesCSV;
import br.com.texo.movies.repository.MoviesPiorFilmeRepository;

@Service
public class MoviesPiorFilmeService {

	@Autowired
	private MoviesPiorFilmeRepository repository;
	
	@PostConstruct
	private void readCSV() {
		List<MoviesPiorFilme> movies = new ArrayList<MoviesPiorFilme>();
		Resource resource = new ClassPathResource("movielist.csv");

		try {
			this.parseFile(resource.getFile(), movies);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void parseFile(File file, List<MoviesPiorFilme> movies) throws FileNotFoundException {
		Reader reader = new BufferedReader(new FileReader(file));
		CsvToBean<MoviesCSV> csvReader = new CsvToBeanBuilder<MoviesCSV>(reader).withSkipLines(1)
				.withType(MoviesCSV.class).withSeparator(';').withIgnoreLeadingWhiteSpace(true)
				.withIgnoreEmptyLine(true).build();
		List<MoviesCSV> results = csvReader.parse();
		for (MoviesCSV m : results) {
			MoviesPiorFilme movieModel = new MoviesPiorFilme();
			movieModel.setYear(Integer.valueOf(m.getYear()));
			movieModel.setTitle(m.getTitle());
			movieModel.setStudios(m.getStudios());
			movieModel.setProducers(m.getProducers());
			movieModel.setWinner(m.getWinner());
			movies.add(movieModel);
		}
		repository.saveAll(movies);
		movies.forEach(System.out::println);

	}

	public ProdutoresPremiados consultarProdutorPremiados() {
		
		return new ProdutoresPremiados(repository.findProdutorDoisPremiosMaisRapidos(),repository.findProdutorDoisPremiosMaiorIntervalo());
		
	}

	public List<ProdutorPremiado> consultarProdutorComMaiorIntervalo() {
		return repository.findProdutorDoisPremiosMaiorIntervalo();
	}
	public List<ProdutorPremiado> consultarProdutorMaisRapido() {
		return repository.findProdutorDoisPremiosMaisRapidos();
	}
}
