package pedro.jogoDavelha.UI;

import br.com.softblue.commons.io.Console;

public class UI {
	
	public static void printText(String text) {
		System.out.println(text);
	}
	public static void printTextNoNewLine(String text) {
		System.out.print(text);
	}
	
	public static void newLine(String text) {
		System.out.println();
	}
	
	public static String InputString(String text) {
		System.out.println(text);
		return Console.readString();
	}
	
	public static void titleOfGame() {
		System.out.println("=============");
		System.out.println("JOGO DA VELHA");
		System.out.println("=============");
	}

}
