package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KonsoliIO implements IO {

	private Scanner lukija;
	
	public KonsoliIO() {
		lukija = new Scanner(System.in);
	}
	
	@Override
	public String nextLine() {
		return lukija.nextLine();
	}

	@Override
	public void print(String teksti) {
		System.out.print(teksti);
	}

	@Override
	public void println(String teksti) {
		System.out.println(teksti);
	}

}
