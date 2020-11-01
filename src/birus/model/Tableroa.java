package Birus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tableroa {
	private static Tableroa nireTableroa;
	private ListaKartak mazoa;

	private Tableroa() {
		this.mazoa=new ListaKartak();
		
		//organoak
		Karta k;
		int i=0;
		while (i<5) {
			k=new Organoak ("Gorria",false,0);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<5) {
			k = new Organoak ("Berdea",false,0);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<5) {
			k=new Organoak ("Horia",false,0);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<5) {
			k=new Organoak ("Urdina",false,0);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		k=new Organoak ("Guztiak",true,0);
		this.mazoa.kartaGehitu(k);

		//Birusak
		i=0;
		while (i<4) {
			k=new Birusa ("Gorria",false);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Birusa ("Berdea",false);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Birusa ("Horia",false);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Birusa ("Urdina",false);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		k=new Birusa ("Guztiak",true);
		this.mazoa.kartaGehitu(k);
		//Botikak
		i=0;
		while (i<4) {
			k=new Botika ("Gorria",false);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Berdea",false);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Horia",false);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Urdina",false);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Guztiak",true);
			this.mazoa.kartaGehitu(k);
			i++;
		}
		//Tratamenduak
		i=0;
		while (i<2) {
			k=new Tratamendua ("Zuria","Kutsatu");
			this.mazoa.kartaGehitu(k);			
			i++;
		}
		i=0;
		while (i<3) {
			k=new Tratamendua ("Zuria","Lapurra");
			this.mazoa.kartaGehitu(k);			
			i++;
		}
		i=0;
		while (i<3) {
			k=new Tratamendua ("Zuria","Organo aldaketa");
			this.mazoa.kartaGehitu(k);			
			i++;
		}
		k=new Tratamendua ("Zuria","Deskartatu guztiak");
		this.mazoa.kartaGehitu(k);
		k=new Tratamendua ("Zuria","Esku aldaketa");
		this.mazoa.kartaGehitu(k);
		
		//barajatu
		Collections.shuffle(this.mazoa.getLista());
	}
	
	public static synchronized Tableroa getNiretableroa() {
		if (nireTableroa==null) {
			nireTableroa=new Tableroa();
		}
		return nireTableroa;
	}
	
	public void kartakBanatu() {
		ListaJokalariak.getNireListaJokalariak(0).kartakBanatu(this.mazoa);
	}
	public void deskartatu(Karta pKarta) {
		this.mazoa.kartaGehitu(pKarta);
	}
	public ListaKartak getMazoa() {
		return this.mazoa;
	}
}
