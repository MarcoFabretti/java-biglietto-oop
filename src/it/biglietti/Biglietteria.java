package it.biglietti;

import java.util.Scanner;

// @author MarcoFabretti,  AndreaConti33, LucaVigentini, FrancescaPompi

public class Biglietteria {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean valido = true;
		Biglietto biglietto = new Biglietto(0, 0);
		System.out.println("Inserire numero di chilometri da percorrere: ");
		do {

			try {
				biglietto.setKm(scan.nextInt());
				valido = Biglietto.isValidKm(biglietto.getKm());
			} catch (Exception e) {
				System.out.println("Il valore deve essere int ");
				scan.nextLine();
				valido = false;
			}
		} while (valido == false);

		System.out.println("Hai digitato " + biglietto.getKm() + " chilometri.");
		valido = true;

		System.out.println("Inserire l'età del passeggero: ");
		do {
			try {
				biglietto.setEta(scan.nextInt());
				valido = Biglietto.isValidEta(biglietto.getEta());
			} catch (Exception e) {
				System.out.println("Il valore deve essere int");
				scan.nextLine();
				valido = false;
			}
		} while (valido == false);

		System.out.println("Hai digitato " + biglietto.getEta() + " anni");
		System.out.println("Il costo del biglietto è: " + biglietto.calcolaPrezzo() + " euro");
		scan.close();

	}
}
