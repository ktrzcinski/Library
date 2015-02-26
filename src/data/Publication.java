package data;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Publication implements Serializable, Comparable<Publication> {
	private static final long serialVersionUID = 2379462795627934629L;
	
	private LocalDate date;
	private String title;
	private String publisher;

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getYear() {
		return date.getYear();
	}
	
	protected Publication(int year, String title, String publisher) {
		setDate(LocalDate.of(year, 1, 1));
		setTitle(title);
		setPublisher(publisher);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		if(date == null) {
			if(other.date != null)
				return false;
		} else if(!date.equals(other.date))
				return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Publication o) {
		return title.compareTo(o.getTitle());
	}
}
