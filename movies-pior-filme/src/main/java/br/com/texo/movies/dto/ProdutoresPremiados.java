package br.com.texo.movies.dto;

import java.util.List;

public class ProdutoresPremiados {
	private List<ProdutorPremiado> min;
	private List<ProdutorPremiado> max;
	
	public ProdutoresPremiados() {
	
	}
	
	public ProdutoresPremiados(List<ProdutorPremiado> min, List<ProdutorPremiado> max) {
		this.min = min;
		this.max = max;
	}
	public List<ProdutorPremiado> getMin() {
		return min;
	}
	public void setMin(List<ProdutorPremiado> min) {
		this.min = min;
	}
	public List<ProdutorPremiado> getMax() {
		return max;
	}
	public void setMax(List<ProdutorPremiado> max) {
		this.max = max;
	}
	
	
	

}
