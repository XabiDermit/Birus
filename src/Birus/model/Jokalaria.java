package Birus.model;
import Birus.Main;

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
	

	
	public boolean organoaMahaianSartu(Organoak pOr) {
		
		int i = bilatuLekua(); //recoge la posicion donde se mete el organo o un -1 en caso de que no puedas meterlo
		if (i != -1) {
			this.mahaia[i] = pOr;
			return true;
		}
		else {
			//mostrar ventana de mensaje
			return false;
		}
	}
	
	
	public boolean infektatuJokalaria(Birusa pBi, int jugadorPos) {

		if(pBi.getKolorea().equals("Guztiak")){
			return this.sartuBirusaMailan(pBi, jugadorPos);
		}else if (!ListaJokalariak.getNireListaJokalariak(0).getLista()[jugadorPos].koloreBerdinekoOrganoDago(pBi)) {
			//mostrar pantalla de mensaje --> el jugador al que atacamos no tiene ese organo
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
			k = (Organoak)getCartaOptima(mesa);
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

	private Karta getCartaOptima(Karta[] mesaEnemigo){

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
	
	public boolean bilatuLekuaBotikarentzat(Botika pBo) {
		int i = 0;
		boolean aurk =  false;
		Karta k = null;
		if (pBo.kolorea.equals("Guztiak")){
			k = getCartaOptima(mahaia);
			aurk=true;
		}else{
			while (i < 4 && !aurk) {
				if (this.mahaia[i] != null && this.mahaia[i].kolorea.equals(pBo.kolorea)) {
					aurk = true;
					k = this.mahaia[i];
				}
				else {
					i++;
				}
			}
			
		}
		if (aurk) {
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
		return aurk;
	}
	
	public Karta[] getMahaia() {
		return this.mahaia;
	}
	
	public void tratamentuaJolastu(Tratamendua tratamendua, Jokalaria pJugador){
		if (tratamendua.getMota().equals("Kutsatu")){
			//pasar viruses al jugador elegido
		}else if (tratamendua.getMota().equals("Lapurra")){
			//robarle un organo a otro jugador
			Karta[] pMesaJugador = pJugador.getMahaia();
			ArrayList<Integer> betados = new ArrayList<>();
			Organoak carta = getMejorOrgano(pMesaJugador,betados);
			//mientra no se pueda meter un organo en la mesa pasa a buscar el siguiente mejor
			for (int i=2; !organoaMahaianSartu(carta) && i>-2;i--){
				betados.add(i);
				carta = getMejorOrgano(pMesaJugador,betados);
			}
			pMesaJugador[getPosFromCarta(carta,pMesaJugador)] = null;
		}else if (tratamendua.getMota().equals("Organo aldaketa")){
			//intercambiar organo con otro jugador
		}else if (tratamendua.getMota().equals("Deskartatu guztiak")){
			//descartar mano del jugador elegido
			pJugador.getEskua().cambiarTodaLaMano();
		}else{ // Esku aldaketa
			//cambia nuestra mano por la de otro
			pJugador.getEskua().intercambiarMano(this.eskua);
		}
	}

	private Organoak getMejorOrgano(Karta[] mesa, ArrayList<Integer> betados) {
		ArrayList<Integer> estados = new ArrayList<>();
		ArrayList<String> coloresMiMesa = new ArrayList<>();
		for (int i=0; i<4;i++){
			if (mesa[i] != null && mesa[i] instanceof Organoak){
				estados.add(((Organoak) mesa[i]).getEstado());
				coloresMiMesa.add(mahaia[i].getKolorea());
			}

		}
		if (estados.contains(2) && !betados.contains(2) && !coloresMiMesa.contains(mesa[estados.indexOf(2)].getKolorea())){
			return (Organoak) mesa[estados.indexOf(2)];
		}else if (estados.contains(1) && !betados.contains(1) && !coloresMiMesa.contains(mesa[estados.indexOf(1)].getKolorea())){
			return (Organoak) mesa[estados.indexOf(1)];
		}else if (estados.contains(0) && !betados.contains(0)&& !coloresMiMesa.contains(mesa[estados.indexOf(0)].getKolorea())){
			return (Organoak) mesa[estados.indexOf(0)];
		}else if (estados.contains(-1) && !betados.contains(-1)&& !coloresMiMesa.contains(mesa[estados.indexOf(-1)].getKolorea())){
			return (Organoak) mesa[estados.indexOf(-1)];
		}
		return null;
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
