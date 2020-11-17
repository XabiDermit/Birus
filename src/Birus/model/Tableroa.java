package Birus.model;
import javafx.scene.image.Image;

import java.util.Collections;
import java.util.HashMap;

public class Tableroa {
	private static Tableroa nireTableroa;
	private ListaKartak mazoa;

	private Tableroa() {
		this.mazoa=new ListaKartak();
		Karta k;

		/*
		Se intenta hacer de la manera mas proporcionada posible:
			- 50 organos de cada
			- 100 virus y 100 botiquines, ya que se necesitan dos de cada para matar o blindar un organo
			- 20 cartas de cada comodin (virus, organo, botiquin)
			- 10 cartas de cada tratamiento

		Se intenta aprovechar los bucles for de la manera mas eficiente posible:
			- Primer bucle: de 10 --> se crean los 10 tratamientos, y 10 del resto
			- Segundo bucle: de 10 --> se crean los 10 comodines (de cada) que faltan, y otros 10 del resto
			- Tercer bucle: de 30 --> se crean los 30 oraganos (de cada) que faltan (en total ya van 50), y otros 30 del resto
			- Cuartoo bucle: de 50 --> se crean los 50 viruses y botiquines que faltan (habiamos creado 50; 10+10+30)
		 */
		for (int i=0;i<10;i++){
			//10 cartas por tratamiento
			k=new Tratamendua ("Zuria","Kutsatu", new Image("/Birus/ui/Imagenes/contaminarmorado.png"));
			this.mazoa.kartaGehitu(k);
			k=new Tratamendua ("Zuria","Lapurra", new Image("/Birus/ui/Imagenes/ladronmorado.png"));
			this.mazoa.kartaGehitu(k);
			k=new Tratamendua ("Zuria","Organo aldaketa", new Image("/Birus/ui/Imagenes/cambiarmorado.png"));
			this.mazoa.kartaGehitu(k);
			k=new Tratamendua ("Zuria","Deskartatu guztiak", new Image("/Birus/ui/Imagenes/papeleramorada.png"));
			this.mazoa.kartaGehitu(k);
			k=new Tratamendua ("Zuria","Esku aldaketa", new Image("/Birus/ui/Imagenes/guantemorado.png"));
			this.mazoa.kartaGehitu(k);

			//10 cartas por comodin
			k=new Organoak ("Guztiak",true,0, new Image("/Birus/ui/Imagenes/organocomodin.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Guztiak",true, new Image("/Birus/ui/Imagenes/viruscomodin.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Guztiak",true, new Image("/Birus/ui/Imagenes/botiquincomodin.png"));
			this.mazoa.kartaGehitu(k);

			//10 cartas por organo
			k=new Organoak ("Gorria",false,0, new Image("/Birus/ui/Imagenes/corazonrojo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Berdea",false,0, new Image("/Birus/ui/Imagenes/estomagoverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Horia",false,0, new Image("/Birus/ui/Imagenes/huesoamarillo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Urdina",false,0, new Image("/Birus/ui/Imagenes/cerebroazul.png"));
			this.mazoa.kartaGehitu(k);

			//10 cartas por virus y botiquin
			k=new Birusa ("Gorria",false, new Image("/Birus/ui/Imagenes/virusrojo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Berdea",false, new Image("/Birus/ui/Imagenes/virusverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Horia",false, new Image("/Birus/ui/Imagenes/virusamarillo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Urdina",false, new Image("/Birus/ui/Imagenes/virusazul.png"));
			this.mazoa.kartaGehitu(k);

			k=new Botika ("Gorria",false, new Image("/Birus/ui/Imagenes/jeringaroja.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Berdea",false, new Image("/Birus/ui/Imagenes/jarabeverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Horia",false, new Image("/Birus/ui/Imagenes/tiritaamarilla.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Urdina",false, new Image("/Birus/ui/Imagenes/pirulaazul.png"));
			this.mazoa.kartaGehitu(k);

		}

		for (int i=0;i<10;i++){
			//las 10 cartas de comodin que faltaban
			k=new Organoak ("Guztiak",true,0, new Image("/Birus/ui/Imagenes/organocomodin.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Guztiak",true, new Image("/Birus/ui/Imagenes/viruscomodin.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Guztiak",true, new Image("/Birus/ui/Imagenes/botiquincomodin.png"));
			this.mazoa.kartaGehitu(k);

			//10 cartas por organo
			k=new Organoak ("Gorria",false,0, new Image("/Birus/ui/Imagenes/corazonrojo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Berdea",false,0, new Image("/Birus/ui/Imagenes/estomagoverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Horia",false,0, new Image("/Birus/ui/Imagenes/huesoamarillo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Urdina",false,0, new Image("/Birus/ui/Imagenes/cerebroazul.png"));
			this.mazoa.kartaGehitu(k);

			//10 cartas por virus y botiquin
			k=new Birusa ("Gorria",false, new Image("/Birus/ui/Imagenes/virusrojo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Berdea",false, new Image("/Birus/ui/Imagenes/virusverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Horia",false, new Image("/Birus/ui/Imagenes/virusamarillo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Urdina",false, new Image("/Birus/ui/Imagenes/virusazul.png"));
			this.mazoa.kartaGehitu(k);

			k=new Botika ("Gorria",false, new Image("/Birus/ui/Imagenes/jeringaroja.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Berdea",false, new Image("/Birus/ui/Imagenes/jarabeverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Horia",false, new Image("/Birus/ui/Imagenes/tiritaamarilla.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Urdina",false, new Image("/Birus/ui/Imagenes/pirulaazul.png"));
			this.mazoa.kartaGehitu(k);
		}

		for (int i=0;i<30;i++){
			//los 30 organos que faltaban
			k=new Organoak ("Gorria",false,0, new Image("/Birus/ui/Imagenes/corazonrojo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Berdea",false,0, new Image("/Birus/ui/Imagenes/estomagoverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Horia",false,0, new Image("/Birus/ui/Imagenes/huesoamarillo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Organoak ("Urdina",false,0, new Image("/Birus/ui/Imagenes/cerebroazul.png"));
			this.mazoa.kartaGehitu(k);

			//30 cartas por virus y botiquin
			k=new Birusa ("Gorria",false, new Image("/Birus/ui/Imagenes/virusrojo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Berdea",false, new Image("/Birus/ui/Imagenes/virusverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Horia",false, new Image("/Birus/ui/Imagenes/virusamarillo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Urdina",false, new Image("/Birus/ui/Imagenes/virusazul.png"));
			this.mazoa.kartaGehitu(k);

			k=new Botika ("Gorria",false, new Image("/Birus/ui/Imagenes/jeringaroja.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Berdea",false, new Image("/Birus/ui/Imagenes/jarabeverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Horia",false, new Image("/Birus/ui/Imagenes/tiritaamarilla.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Urdina",false, new Image("/Birus/ui/Imagenes/pirulaazul.png"));
			this.mazoa.kartaGehitu(k);

		}

		for (int i=0; i<50;i++){
			//los 50 virus y botiquin que faltaban
			k=new Birusa ("Gorria",false, new Image("/Birus/ui/Imagenes/virusrojo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Berdea",false, new Image("/Birus/ui/Imagenes/virusverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Horia",false, new Image("/Birus/ui/Imagenes/virusamarillo.png"));
			this.mazoa.kartaGehitu(k);
			k=new Birusa ("Urdina",false, new Image("/Birus/ui/Imagenes/virusazul.png"));
			this.mazoa.kartaGehitu(k);

			k=new Botika ("Gorria",false, new Image("/Birus/ui/Imagenes/jeringaroja.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Berdea",false, new Image("/Birus/ui/Imagenes/jarabeverde.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Horia",false, new Image("/Birus/ui/Imagenes/tiritaamarilla.png"));
			this.mazoa.kartaGehitu(k);
			k=new Botika ("Urdina",false, new Image("/Birus/ui/Imagenes/pirulaazul.png"));
			this.mazoa.kartaGehitu(k);
		}

		//barajatu
		Collections.shuffle(this.mazoa.getLista());

		//diferentes tratamendus para la demo

		/*
		k=new Tratamendua ("Zuria","Deskartatu guztiak", new Image("/Birus/ui/Imagenes/papeleramorada.png"));
		this.mazoa.getLista().add(0,k);
		*/

		/*
		k=new Tratamendua ("Zuria","Esku aldaketa", new Image("/Birus/ui/Imagenes/guantemorado.png"));
		this.mazoa.getLista().add(0,k);
		*/

		/*
		k=new Tratamendua ("Zuria","Lapurra", new Image("/Birus/ui/Imagenes/ladronmorado.png"));
		this.mazoa.getLista().add(0,k);

		*/


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
