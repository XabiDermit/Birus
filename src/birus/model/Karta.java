package Birus;

public abstract class Karta {
	protected String kolorea;

	public Karta(String pKolorea) {
		this.kolorea=pKolorea;
	}
	protected void inprimatu() {}
	
	protected boolean koloreBerdina(Karta pKarta) {
		boolean emaitza=false;
		if(this.kolorea==pKarta.kolorea) {
			emaitza=true;
		}
		return emaitza;
	}
}
