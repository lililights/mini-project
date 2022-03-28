package model;

public class MoviesDTO {

	private int movieId;
	private String titleKor;
	private String titleEng;
	private int ageLimit;
	private String genre;
	private String plot;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitleKor() {
		return titleKor;
	}

	public void setTitleKor(String titleKor) {
		this.titleKor = titleKor;
	}

	public String getTitleEng() {
		return titleEng;
	}

	public void setTitleEng(String titleEng) {
		this.titleEng = titleEng;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public String getAgeLimitText() {
		if (ageLimit == 12) {
			return "12세 관람가";
		} else if (ageLimit == 15) {
			return "15세 관람가";
		} else if (ageLimit == 18) {
			return "청소년 관람불가";
		}
		return "전체 관람가";
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public boolean equals(Object o) {
		if (o instanceof MoviesDTO) {
			MoviesDTO m = (MoviesDTO) o;
			if (movieId == m.movieId) {
				return true;
			}
		}
		return false;
	}
	
	public MoviesDTO() {
		
	}
	
	public MoviesDTO(MoviesDTO m) {
		movieId = m.movieId;
		titleKor = m.titleKor;
		titleEng = m.titleEng;
		ageLimit = m.ageLimit;
		genre = m.genre;
		plot = m.plot;
	}
}