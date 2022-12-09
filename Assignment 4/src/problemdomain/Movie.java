package problemdomain;

public class Movie {
	
	private int duration;
	private String title;
	private String year;
	
	private Movie() {
		
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [duration=" + duration + ", title=" + title + ", year=" + year + ", getDuration()="
				+ getDuration() + ", getTitle()=" + getTitle() + ", getYear()=" + getYear() + "]";
	}
	
	
	
}
