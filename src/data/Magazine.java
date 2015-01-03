package data;

public class Magazine extends Publication {
	private int month;
	private int day;
	private String language;

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Magazine(String title, String publisher, String language, int year,
			int month, int day) {
		super(year, title, publisher);
		setLanguage(language);
		setMonth(month);
		setDay(day);
	}

	public void printInfo() {
		String info = getTitle() + "; " + getPublisher() + "; " + getYear()
				+ "; " + getMonth() + "; " + getDay() + "; " + getLanguage();
		System.out.println(info);
	}
}
