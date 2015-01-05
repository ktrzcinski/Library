package data;

public class Library {

	public static final int MAX_PUBLICATIONS = 2000;
	private Publication[] publications;
	private int publicationsNumber;

	public int getPublicationsNumber() {
		return this.publicationsNumber;
	}

	public Publication[] getPublications() {
		return publications;
	}

	public Library() {
		publications = new Publication[MAX_PUBLICATIONS];
	}

	public void addBook(Book book) {
		addPublication(book);
	}

	public void addMagazine(Magazine magazine) {
		addPublication(magazine);
	}

	public void addPublication(Publication pub) {
		if (publicationsNumber < MAX_PUBLICATIONS) {
			publications[publicationsNumber] = pub;
			publicationsNumber++;
		} else {
			System.out.println("Max amount of publications has been reached");
		}
	}

	public void printBooks() {
		int countBooks = 0;
		for (int i = 0; i < publicationsNumber; i++) {
			if (publications[i] instanceof Book) {
				System.out.println(publications[i]);
				countBooks++;
			}
		}
		if (countBooks == 0) {
			System.out.println("No books in library");
		}
	}

	public void printMagazines() {
		int countMagazines = 0;
		for (int i = 0; i < publicationsNumber; i++) {
			if (publications[i] instanceof Magazine) {
				System.out.println(publications[i]);
				countMagazines++;
			}
		}
		if (countMagazines == 0) {
			System.out.println("No magazines in library");
		}
	}
}