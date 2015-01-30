package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
	private static final long serialVersionUID = 23793453456454629L;
	
	public static final int INITIAL_CAPACITY = 1;
	
	private Map<String, Publication> publications;
	private Map<String, LibraryUser> users;

	public int getPublicationsNumber() {
		return publications.size();
	}

	public Map<String, Publication> getPublications() {
		return publications;
	}
	
	public Map<String, LibraryUser> getUsers() {
		return users;
	}

	public Library() {
		publications = new HashMap<>();
		users = new HashMap<>();
	}

	public void addBook(Book book) {
		addPublication(book);
	}

	public void addMagazine(Magazine magazine) {
		addPublication(magazine);
	}
	
	public void addUser(LibraryUser user) {
		users.put(user.getPpsNo(), user);
	}
	
	public void removePublication(Publication pub) {
		if(publications.containsValue(pub)) {
			publications.remove(pub.getTitle());
		}
	}

	public void addPublication(Publication pub) throws ArrayIndexOutOfBoundsException {
		if (publicationsNumber == publications.length) {
			publications = Arrays.copyOf(publications, publications.length * 2);
		}
		publications[publicationsNumber] = pub;
		publicationsNumber++;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < publicationsNumber; i++) {
			builder.append(publications[i]);
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public static class AlphabeticalComparator implements Comparator<Publication> {
		@Override
		public int compare(Publication o1, Publication o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			return o1.getTitle().compareTo(o2.getTitle());
		}
	}
	
	public static class DateComparator implements Comparator<Publication> {
		@Override
		public int compare(Publication o1, Publication o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			Integer i1 = o1.getYear();
			Integer i2 = o2.getYear();
			return -i1.compareTo(i2);
		}
	}
}