package Birus.model;
import javafx.scene.image.Image;

import java.util.Collections;
import java.util.HashMap;

public class Tableroa {
	private static Tableroa nireTableroa;
	private ListaKartak mazoa;
	private HashMap<String,Karta> cartas;

	private Tableroa() {
		this.mazoa=new ListaKartak();
		this.cartas = new HashMap<>();
		//organoak
		Karta k;
		int i=0;
		while (i<50) {
			k=new Organoak ("Gorria",false,0, new Image("/Birus/ui/Imagenes/corazonrojo.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/corazonrojo.png",k);
			i++;
		}
		i=0;
		while (i<50) {
			k = new Organoak ("Berdea",false,0, new Image("/Birus/ui/Imagenes/estomagoverde.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/estomagoverde.png",k);

			i++;
		}
		i=0;
		while (i<50) {
			k=new Organoak ("Horia",false,0, new Image("/Birus/ui/Imagenes/huesoamarillo.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/huesoamarillo.png",k);
			i++;
		}
		i=0;
		while (i<50) {
			k=new Organoak ("Urdina",false,0, new Image("/Birus/ui/Imagenes/cerebroazul.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/cerebroazul.png",k);

			i++;
		}
		k=new Organoak ("Guztiak",true,0, new Image("/Birus/ui/Imagenes/organocomodin.png"));
		this.mazoa.kartaGehitu(k);
		this.cartas.put("/Birus/ui/Imagenes/organocomodin.png",k);

		//Birusak
		i=0;
		while (i<40) {
			k=new Birusa ("Gorria",false, new Image("/Birus/ui/Imagenes/virusrojo.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/virusrojo.png",k);

			i++;
		}
		i=0;
		while (i<40) {
			k=new Birusa ("Berdea",false, new Image("/Birus/ui/Imagenes/virusverde.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/virusverde.png",k);
			i++;
		}
		i=0;
		while (i<40) {
			k=new Birusa ("Horia",false, new Image("/Birus/ui/Imagenes/virusamarillo.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/virusamarillo.png",k);
			i++;
		}
		i=0;
		while (i<40) {
			k=new Birusa ("Urdina",false, new Image("/Birus/ui/Imagenes/virusazul.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/virusazul.png",k);
			i++;
		}
		k=new Birusa ("Guztiak",true, new Image("/Birus/ui/Imagenes/viruscomodin.png"));
		this.mazoa.kartaGehitu(k);
		this.cartas.put("/Birus/ui/Imagenes/viruscomodin.png",k);
		//Botikak
		i=0;
		while (i<40) {
			k=new Botika ("Gorria",false, new Image("/Birus/ui/Imagenes/jeringaroja.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/jeringaroja.png",k);
			i++;
		}
		i=0;
		while (i<40) {
			k=new Botika ("Berdea",false, new Image("/Birus/ui/Imagenes/jarabeverde.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/jarabeverde.png",k);
			i++;
		}
		i=0;
		while (i<40) {
			k=new Botika ("Horia",false, new Image("/Birus/ui/Imagenes/tiritaamarilla.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/tiritaamarilla.png",k);
			i++;
		}
		i=0;
		while (i<4) {
			k=new Botika ("Urdina",false, new Image("/Birus/ui/Imagenes/pirulaazul.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/pirulaazul.png",k);
			i++;
		}
		i=0;
		while (i<40) {
			k=new Botika ("Guztiak",true, new Image("/Birus/ui/Imagenes/botiquincomodin.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/botiquincomodin.png",k);
			i++;
		}
		//Tratamenduak
		i=0;
		while (i<20) {
			k=new Tratamendua ("Zuria","Kutsatu", new Image("/Birus/ui/Imagenes/contaminarmorado.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/contaminarmorado.png",k);
			i++;
		}
		i=0;
		while (i<30) {
			k=new Tratamendua ("Zuria","Lapurra", new Image("/Birus/ui/Imagenes/ladronmorado.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/ladronmorado.png",k);
			i++;
		}
		i=0;
		while (i<30) {
			k=new Tratamendua ("Zuria","Organo aldaketa", new Image("/Birus/ui/Imagenes/cambiarmorado.png"));
			this.mazoa.kartaGehitu(k);
			this.cartas.put("/Birus/ui/Imagenes/cambiarmorado.png",k);
			i++;
		}
		k=new Tratamendua ("Zuria","Deskartatu guztiak", new Image("/Birus/ui/Imagenes/papeleramorada.png"));
		this.mazoa.kartaGehitu(k);
		this.cartas.put("/Birus/ui/Imagenes/papeleramorada.png",k);
		k=new Tratamendua ("Zuria","Esku aldaketa", new Image("/Birus/ui/Imagenes/guantemorado.png"));
		this.mazoa.kartaGehitu(k);
		this.cartas.put("/Birus/ui/Imagenes/guantemorado.png",k);
		
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

	public Karta getCartaFromIv(String url){
		return this.cartas.get(url);
	}
}
