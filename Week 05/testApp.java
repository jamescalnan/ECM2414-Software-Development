import java.io.Console;

public class testApp {

	 Console console = System.console();



	public static void main(String[] args) {
		System.out.println("Starting program...");
		something();


		
		
	}

	static void something() {
		System.out.println("Hello");

		for (;;) {
			String text = System.console().readLine();
			System.out.println("Output: " + text);
		}
	}
}