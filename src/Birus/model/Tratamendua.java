package Birus.model;

import javafx.scene.image.Image;

public class Tratamendua extends Karta {
	private String mota;
	
	public Tratamendua(String pKolorea, String pMota, Image pKarta) {
		super(pKolorea,pKarta);
		this.mota=pMota;
	}
	public void inprimatu() {
		System.out.println(this.mota);
	}

	public String getMota(){
		return mota;
	}
}
