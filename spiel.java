package hangman;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class spiel {
	
	private static ArrayList <String> arr = new ArrayList <String>();
	private static int zahl = 0;
	private static String wort = "";
	private static int zustandsnr = 3;
	private static int versuche = 10;
	
	public static void dateiEinlesen1() {
		Scanner scan = null;
		try {
		    scan = new Scanner(new File("hangman.rdf"));
		    while (scan.hasNext()) {
		   arr.add(scan.nextLine());
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		scan.close();
		zustandsnr = 2;
	}
	
	public static void wortSuchen2() {
		Random wuerfel = new Random();
		zahl = wuerfel.nextInt();
		wort = arr.get(zahl);
		zustandsnr = 4;
	}
	
	public static void home3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Wollen Sie ein Spiel starten? 		j/n");
		String s = scan.next();
		if(s.equalsIgnoreCase("j")) {
			versuche = 10;
			zustandsnr = 1;
		}
		if(s.equalsIgnoreCase("n")) zustandsnr = 0;
	}
	
	public static void ende0() {
		System.out.println("Vielen Dank dass Sie Hangman gespielt haben!");
	}
	
	public static void spiel4() {
		char[] sternchen = new char [wort.length()];
		char[] cc = wort.toCharArray();
		for(int i = 0; i < wort.length(); i++) {
			sternchen[i] = '*';
		}
		while(versuche > 0) {
			String s = einlesen();
			if(s.equalsIgnoreCase(wort)) {
				System.out.println("Victory");
				zustandsnr = 3;
				return;
			}
			if(check(s)) {
				for(int i = 0; i < wort.length(); i++) {
					String ss = String.valueOf(cc[i]);
					if(s.equalsIgnoreCase(ss)) sternchen[i] = cc[i];
				}
				System.out.print(sternchen);
				System.out.println();
			}else {
				versuche = versuche - 1;
				System.out.println("Falsch! Sie haben noch "+ versuche +" Versuche!");
				skizze();
			}
		}
		if(versuche == 0) {
			System.out.println("Game over");
			zustandsnr = 3;
		}
	}
	
	public static boolean check(String s) {
		char[] c = wort.toCharArray();
		for(int i = 0; i < wort.length(); i++) {
			String f = String.valueOf(c[i]);
			if(s.equalsIgnoreCase(f)) { 
				return true;
			}
		}
		return false;
	}
	
	public static String einlesen() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ratten Sie bitte!");
		String s = scan.next();
		return s;
	}
	
	public static void skizze() {
		if(versuche == 0) {
			System.out.println(" ----------- ");
			System.out.println(" |         | ");
			System.out.println(" |         X ");
			System.out.println(" |         | ");
			System.out.println(" |        ---");
			System.out.println(" |         | ");
			System.out.println(" |        | |");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 1) {
			System.out.println(" ----------- ");
			System.out.println(" |         | ");
			System.out.println(" |         X ");
			System.out.println(" |         | ");
			System.out.println(" |        ---");
			System.out.println(" |         | ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 2) {
			System.out.println(" ----------- ");
			System.out.println(" |         | ");
			System.out.println(" |         X ");
			System.out.println(" |         | ");
			System.out.println(" |        ---");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 3) {
			System.out.println(" ----------- ");
			System.out.println(" |         | ");
			System.out.println(" |         X ");
			System.out.println(" |         | ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 4) {
			System.out.println(" ----------- ");
			System.out.println(" |         | ");
			System.out.println(" |         X ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 5) {
			System.out.println(" ----------- ");
			System.out.println(" |         | ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 6) {
			System.out.println(" ------      ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 7) {
			System.out.println("             ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 8) {
			System.out.println("             ");
			System.out.println("             ");
			System.out.println("             ");
			System.out.println("             ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
		if(versuche == 9) {
			System.out.println("             ");
			System.out.println("             ");
			System.out.println("             ");
			System.out.println("             ");
			System.out.println("             ");
			System.out.println("             ");
			System.out.println("             ");
			System.out.println(" |           ");
			System.out.println("---          ");
		}
	}

	public static void main(String[] args) {
		switch(zustandsnr) {
		case 0: ende0();
		break;
		case 1: dateiEinlesen1();
		break;
		case 2: wortSuchen2();
		break;
		case 3: home3();
		break;
		case 4: spiel4();
		break;
		default: System.out.println("!!!!!!!ALARM!!!!!!!!");
		break;
		}
	}

}
