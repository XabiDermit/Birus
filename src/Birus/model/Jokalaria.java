package Birus.model;
import java.util.ArrayList;
import java.util.Scanner;

public class Jokalaria {
	private ListaKartak eskua;
	private Karta [] mahaia;
	private int turnoa;
	private Scanner scanner;
	
	public Jokalaria(int j) {
		this.turnoa=j+1;
		this.eskua=new ListaKartak();
		this.mahaia=new Karta [4];
	}
	
	public void kartaHartu(Karta pKarta) {
		this.eskua.kartaGehitu(pKarta);
	}
	public ListaKartak getEskua () {
		return this.eskua;
	}
	
	public Karta KartaHautatu(int j) {
		return this.eskua.getKarta(j);
	}

	private int getPosFromCarta(Karta pCarta, Karta[] mesaEnemigo){
		for (int i=0; i<4; i++){
			if (mesaEnemigo[i].equals(pCarta)){return i;}
		}
		return -1;
	}


	public String jokatu(Karta pKarta, int posCarta) {

		Karta k= pKarta;
		if (k instanceof Organoak){ //en caso de que sea un organo
			Organoak or = (Organoak)k; //casteas de karta a organoak
			if (!this.koloreBerdinekoOrganoDago(or)) { //metodo que comprueba que no haya un organo del mismo color
				this.organoaMahaianSartu(or); //metodo que mete el organo en la mesa
				this.eskua.kartaKendu(posCarta);	//quita la carta de tu mano
				this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().repartirCarta());	//nos da una nueva carta del mazo
				return "OK";
			}else {
				//añadir ventana para mensajes
				System.out.println("Ya está esta carta ");
				return "ERROR";
			}
		//cuando no es un organo tenemos que elegir a quien o que carta atacamos o curamos

		}else if (k instanceof Birusa) {
			return "ATACAR";
		}else if (k instanceof Botika) {
			return "CURAR";
		} else { //tratamendua
			return "ATACAR";
		}
	}
	
	public void descartar(int posCarta) {
		this.eskua.kartaKendu(posCarta);
		this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().repartirCarta());
	}


	public boolean irabaziDu() {
		boolean amaitu=false;
		int i = 0;
		int osaKop = 0;
		while (i<4) {
			if (this.mahaia[i] instanceof Organoak) {
				Organoak o = (Organoak)this.mahaia[i];
				if (o.osasuntsuDago()) {
					osaKop++;
				}
			}
			i++;
		}
		if (osaKop == 4) {
			amaitu = true;
		}
		return amaitu;
	}
	
	public int bilatuLekua() {
		boolean ema = false;
		int i = 0;
		while (i <4 && !ema) {
			if (this.mahaia[i] ==null) { //comprueba que hay sitio donde meter el organo (porque podria darse el caso de que el jugador tenga un organo en la mano que no comparta color con ninguno de los organos que tiene en su mesa (si tiene un comodin)
				ema = true;
			}
			else {
				i++;
			}
		}
		if (!ema) {
			i = -1;
		}
		return i;
	}
	

	
	public void organoaMahaianSartu(Organoak pOr) {
		
		int i = bilatuLekua(); //recoge la posicion donde se mete el organo o un -1 en caso de que no puedas meterlo
		if (i != -1) {
			this.mahaia[i] = pOr;
		}
		else {
			//mostrar ventana de mensaje
		}
	}
	
	
	public boolean infektatuJokalaria(Birusa pBi, int jugadorPos) {

		if(pBi.getKolorea().equals("Guztiak")){
			return this.sartuBirusaMailan(pBi, jugadorPos);
		}else if (!ListaJokalariak.getNireListaJokalariak(0).getLista()[jugadorPos].koloreBerdinekoOrganoDago(pBi)) {
			//mostrar pantalla de mensaje --> el jugador al que atacamos no tiene ese organo
			System.out.println("");
			return false;
		}else { //tiene un organo del mismo color que el birus que le quieres meter
			return this.sartuBirusaMailan(pBi, jugadorPos);
		}
	}
	
	public boolean sartuBirusaMailan(Birusa pBirusa, int zenb) {
		// si nos ha dejado infectar a otro devuelve true, si el organo estaba blindado false
		Karta[] mesa = ListaJokalariak.getNireListaJokalariak(0).getLista()[zenb].getMahaia();
		boolean aurk = false;
		Organoak k;
		if (pBirusa.kolorea.equals("Guztiak")){
			k = (Organoak)getCartaOptima(pBirusa,mesa);
			aurk=true;

		}else{
			int i = 0;
			while (i < 4 && !aurk) {
				if ((mesa[i] !=null) && (mesa[i].koloreBerdina(pBirusa))) {
					aurk = true;
				}
				else {
					i++;
				}

			}
			k = (Organoak) mesa[i];
		}

		if (aurk) {
			Organoak or = k;
			if (or.getEstado() == 2) {
				//mostrar ventana de mensaje --> el organo esta blindado
				return false;
			}
			else if (or.getEstado() == 1) {
				//dejamos la carta "de fabrica"
				or.birusKopHanditu();
				//actualizar la carta
				or.actualizarEstadoCarta();
				this.eskua.deskartatu(pBirusa);
				this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().repartirCarta());
				return true;
			}
			else if (or.getEstado() == -1) {
				//matamos la carta

				//añade la carta eliminada al mazo
				//antes de volver a meterla en el mazo la dejamos como estaba al principio
				k.setEstado(0);
				k.actualizarEstadoCarta();
				Tableroa.getNiretableroa().deskartatu(k);
				//pone en null la carta de mi mesa
				mesa[getPosFromCarta(k,mesa)] = null;
				this.eskua.deskartatu(pBirusa);
				this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().repartirCarta());
				return  true;
			}
			else { //no tiene nada
				//la carta se queda con solo una vida
				or.birusKopHanditu();
				or.actualizarEstadoCarta();
				this.eskua.deskartatu(pBirusa);
				this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().repartirCarta());
				return true;
			}
			
		}
		else {
			//mostrar ventana de mensaje --> no tiene ningun organo de ese color
			return false;
		}
	}

	private Karta getCartaOptima(Karta pCarta, Karta [] mesaEnemigo){

		//prioridad de ataque/defensa  --> si una carta esta apunto de blindarse >> si una carta esta apunto de morir >> estado = 0
		ArrayList<Integer> estados = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			if (mesaEnemigo[i] != null && mesaEnemigo[i] instanceof Organoak) {
				estados.add(((Organoak) mesaEnemigo[i]).getEstado());
			}

		}
		if (estados.contains(1)){
			return mesaEnemigo[estados.indexOf(1)];
		}else if (estados.contains(-1)){
			return mesaEnemigo[estados.indexOf(-1)];
		}else {
			return mesaEnemigo[estados.indexOf(0)];
		}

	}
	
	public void bilatuLekuaBotikarentzat(Botika pBo) {
		int i = 0;
		boolean aurk =  false;
			while (i < 4 && !aurk) {
				if ((this.mahaia[i] != null) && ((this.mahaia[i].kolorea.equals(pBo.kolorea)) || pBo.kolorea.equals("Guztiak"))) {
					aurk = true;
				}
				else {
					i++;
				}
			}
			
			if (aurk) {
				Karta k = this.mahaia[i];
				Organoak or = (Organoak)k;
				if (or.getEstado() == 2) {
					//organo ya blindado
					//mostrar ventana de mensaje
				}
				else if (or.getEstado() == 1) {
					or.bakunaKopHanditu();
					or.actualizarEstadoCarta();
					this.eskua.deskartatu(pBo);
					this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().repartirCarta());
				}
				else if (or.getEstado() == -1) {

					or.bakunaKopHanditu();
					or.actualizarEstadoCarta();
					this.eskua.deskartatu(pBo);
					this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().repartirCarta());
				}
				else { //no tiene nada
					or.bakunaKopHanditu();
					or.actualizarEstadoCarta();
					this.eskua.deskartatu(pBo);
					this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().repartirCarta());
				}
			}
			else {
				System.out.println("Oraindik ez daukazu kolore horretako organorik zure mahaian!!");
			}
	}
	
	public Karta[] getMahaia() {
		return this.mahaia;
	}
	

	
	public boolean koloreBerdinekoOrganoDago(Karta pOr) {
		boolean ema = false;
		int i = 0;
		while (i<4 && !ema) {
				if (this.mahaia[i]!=null && this.mahaia[i] instanceof Organoak && (this.mahaia[i].koloreBerdina(pOr))) {
					ema = true; //ya hay un organo de ese color
				}
				i++; //mira la siguiente pos
		}
		return ema;
	}

}
