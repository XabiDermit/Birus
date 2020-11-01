package Birus;

public class Botika extends Karta {
	private boolean komodin;
	
	public Botika (String pKolorea,boolean pKomodin) {
		super(pKolorea);
		this.komodin=pKomodin;
	}
	public void inprimatu() {
		System.out.println("Botika "+ super.kolorea);
	}
}