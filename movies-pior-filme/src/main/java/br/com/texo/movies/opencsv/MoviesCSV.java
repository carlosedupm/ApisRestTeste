package br.com.texo.movies.opencsv;

import com.opencsv.bean.CsvBindByPosition;

public class MoviesCSV {

	@CsvBindByPosition(position = 0)
    private String year;

    @CsvBindByPosition(position = 1)
    private String title;

    @CsvBindByPosition(position = 2)
    private String studios;

    @CsvBindByPosition(position = 3)
    private String producers;
    
    @CsvBindByPosition(position = 4)
    private String winner;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudios() {
		return studios;
	}

	public void setStudios(String studios) {
		this.studios = studios;
	}

	public String getProducers() {
		return producers;
	}

	public void setProducers(String producers) {
		this.producers = producers;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "MoviesCSV [year=" + year + ", title=" + title + ", studios=" + studios + ", producers=" + producers
				+ ", winner=" + winner + "]";
	}
    
    
    
}
