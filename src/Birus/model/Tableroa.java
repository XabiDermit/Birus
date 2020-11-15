package Birus.model;
import javafx.scene.image.Image;

import java.util.Collections;

public class Tableroa {
	private static Tableroa nireTableroa;
	private ListaKartak mazoa;

	private Tableroa() {
		this.mazoa=new ListaKartak();
		
		//organoak
		Karta k;
		int i=0;
		while (i<5) {
			k=new Organoak ("Gorria",false,0, new Image("/Birus/ui/Imagenes/corazonrojo.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<5) {
			k = new Organoak ("Berdea",false,0, new Image("/Birus/ui/Imagenes/estomagoverde.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<5) {
			k=new Organoak ("Horia",false,0, new Image("/Birus/ui/Imagenes/huesoamarillo.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<5) {
			k=new Organoak ("Urdina",false,0, new Image("/Birus/ui/Imagenes/cerebroazul.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		k=new Organoak ("Guztiak",true,0, new Image("/Birus/ui/Imagenes/organocomodin.png"));
		this.mazoa.kartaGehitu(k);

		//Birusak
		i=0;
		while (i<4) {
			k=new Birusa ("Gorria",false, new Image("/Birus/ui/Imagenes/virusrojo.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Birusa ("Berdea",false, new Image("/Birus/ui/Imagenes/virusverde.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Birusa ("Horia",false, new Image("/Birus/ui/Imagenes/virusamarillo.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Birusa ("Urdina",false, new Image("/Birus/ui/Imagenes/virusazul.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		k=new Birusa ("Guztiak",true, new Image("/Birus/ui/Imagenes/viruscomodin.png"));
		this.mazoa.kartaGehitu(k);
		//Botikak
		i=0;
		while (i<4) {
			k=new Botika ("Gorria",false, new Image("/Birus/ui/Imagenes/jeringaroja.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Berdea",false, new Image("/Birus/ui/Imagenes/jarabeverde.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Horia",false, new Image("/Birus/ui/Imagenes/tiritaamarilla.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Urdina",false, new Image("/Birus/ui/Imagenes/pirulaazul.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Guztiak",true, new Image("/Birus/ui/Imagenes/botiquincomodin.png"));
			this.mazoa.kartaGehitu(k);
			i++;
		}
		//Tratamenduak
		i=0;
		while (i<2) {
			k=new Tratamendua ("Zuria","Kutsatu", new Image("/Birus/ui/Imagenes/contaminarmorado.png"));
			this.mazoa.kartaGehitu(k);			
			i++;
		}
		i=0;
		while (i<3) {
			k=new Tratamendua ("Zuria","Lapurra", new Image("/Birus/ui/Imagenes/ladronmorado.png"));
			this.mazoa.kartaGehitu(k);			
			i++;
		}
		i=0;
		while (i<3) {
			k=new Tratamendua ("Zuria","Organo aldaketa", new Image("/Birus/ui/Imagenes/cambiarmorado.png"));
			this.mazoa.kartaGehitu(k);			
			i++;
		}
		k=new Tratamendua ("Zuria","Deskartatu guztiak", new Image("/Birus/ui/Imagenes/papeleramorada.png"));
		this.mazoa.kartaGehitu(k);
		k=new Tratamendua ("Zuria","Esku aldaketa", new Image("/Birus/ui/Imagenes/guantemorado.png"));
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
