package Birus.model;

public class Birusa extends Karta {
	private boolean komodin;
	
	public Birusa (String pKolorea,boolean pKomodin) {
		super(pKolorea);
		this.komodin=pKomodin;
	}
	public void inprimatu() {
		System.out.println("Birus "+ super.kolorea);
	}
}
