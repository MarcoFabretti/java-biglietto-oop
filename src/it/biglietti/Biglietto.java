package it.biglietti;

import java.math.BigDecimal;

public class Biglietto {
	// Variabili
	private int km;
	private int eta;

	// Costanti
	private final BigDecimal costoKm = new BigDecimal("0.21");
	private final BigDecimal scontoOver = new BigDecimal("0.6");
	private final BigDecimal scontoUnder = new BigDecimal("0.8");

	// Costruttore
	public Biglietto(int km, int eta) {
		this.km = km;
		this.eta = eta;
	}

	// Get and set

	public int getKm() {
		return km;
	}

	public void setKm (int km){
				this.km = km;
			}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	// Metodi
	public static boolean isValidKm(int km) {
		boolean valid = false;
		if (km > 0) {
			valid = true;
		} else System.out.println("il valore deve essere positivo.");
		return valid;
	}

	public static boolean isValidEta(int eta) {
		boolean valid = false;
		if (eta >= 0 && eta < 120) {
			valid = true;
		} else System.out.println("l'eta deve essere compresea tra 0 e 120.");
		return valid;
	}

	private BigDecimal calcolaSconto() {
		if (eta > 65) {
			return scontoOver;
		} else if (eta < 18) {
			return scontoUnder;
		} else {
			return new BigDecimal("1");
		}
	}

	public BigDecimal calcolaPrezzo() {
		BigDecimal x = new BigDecimal(km);
		x = x.multiply(costoKm);
		return x.multiply(calcolaSconto());
	}
}
