package Birus.model;

import javafx.scene.image.Image;

public class Birusa extends Karta {
	private boolean komodin;
	
	public Birusa (String pKolorea, boolean pKomodin, Image pKarta) {
		super(pKolorea, pKarta);
		this.komodin=pKomodin;
	}
	public void inprimatu() {
		System.out.println("Birus "+ super.kolorea);
	}
}
