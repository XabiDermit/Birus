package Birus.model;

import javafx.scene.image.Image;

public abstract class Karta {
	protected String kolorea;
	private Image karta;

	public Karta(String pKolorea, Image pKarta) {
		this.kolorea=pKolorea;
		this.karta = pKarta;
	}
	protected void inprimatu() {}
	
	protected boolean koloreBerdina(Karta pKarta) {
		boolean emaitza=false;
		if(this.kolorea==pKarta.kolorea) {
			emaitza=true;
		}
		return emaitza;
	}

	public Image getKarta() {
		return karta;
	}

	public void setCarta(Image pCarta){
		karta = pCarta;
	}

	public String getKolorea(){
		return kolorea;
	}
}
