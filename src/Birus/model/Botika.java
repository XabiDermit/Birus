package Birus.model;

import javafx.scene.image.Image;

public class Botika extends Karta {
	private boolean komodin;
	
	public Botika (String pKolorea, boolean pKomodin, Image pKarta) {
		super(pKolorea,pKarta);
		this.komodin=pKomodin;
	}
	public void inprimatu() {
		System.out.println("Botika "+ super.kolorea);
	}
}