package app;

public class LibraryApp {
	public static void main(String[] args) {
		final String APP_NAME = "Library 0.8";
		System.out.println(APP_NAME);
		LibraryControl libControl = new LibraryControl();
		libControl.controlLopp();
	}
}
