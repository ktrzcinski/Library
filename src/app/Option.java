package app;

import java.util.NoSuchElementException;

public enum Option {
	EXIT(0, "Exit the program"), ADD_BOOK(1, "Add new book"), ADD_MAGAZINE(2,
			"Add new magazine"), PRINT_BOOKS(3, "Print available books"), PRINT_MAGAZINES(
			4, "Print available magazines");

	private int value;
	private String description;

	public int getValue() {
		return this.value;
	}

	public String getDescription() {
		return this.description;
	}

	Option(int value, String description) {
		this.value = value;
		this.description = description;
	}

	@Override
	public String toString() {
		return value + " " + description;
	}

	public static Option createFromInt(int option) throws NoSuchElementException {
		Option result = null;
		try {
			result = Option.values()[option];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoSuchElementException("Invalid element");
		}
		return result;
	}
}
