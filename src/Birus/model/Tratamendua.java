package Birus.model;

public class Tratamendua extends Karta {
	private String mota;
	
	public Tratamendua(String pKolorea,String pMota) {
		super(pKolorea);
		this.mota=pMota;
	}
	public void inprimatu() {
		System.out.println(this.mota);
	}
}
