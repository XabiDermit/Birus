package Birus;

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
	
	public void inprimatuEskua() {
		this.eskua.inprimatuEskua();
	}
	public void jokatu() {
		System.out.println("============================");
		System.out.println("");
		System.out.println(this.turnoa + ". jokalariaren txanda");
		System.out.println("============================");
		System.out.println("Mahaia:");
		System.out.println("");
		this.mahaiaInprimatu();
		System.out.println("============================");
		System.out.println("Eskua:");
		System.out.println("");
		this.eskua.inprimatuEskua();
		System.out.println("============================");
		int j=Teklatua.getNireTeklatua().irakurriKartak();
		if(j==0||j==1||j==2) {
			Karta k=this.KartaHautatu(j);
			if (k instanceof Organoak){ //en caso de que sea un organo
				Organoak or = (Organoak)k; //casteas de karta a organoak
				if (!this.koloreBerdinekoOrganoDago(or)) { //metodo que comprueba que no haya un organo del mismo color
					this.organoaMahaianSartu(or); //metodo que mete el organo en la mesa
					or.inprimatu();
					System.out.println("Mahaian sartu da.");
					this.irabaziDu();
					this.eskua.kartaKendu(j);
					this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
				}else {
					System.out.println("Kolore berdineko organo bat mahaian daukazu!!");
				}
			}else if (k instanceof Birusa) {
				Birusa bi = (Birusa)k;
				this.infektatuJokalaria(bi);
			}else if (k instanceof Botika) {
				Botika bo = (Botika)k;
				this.bilatuLekuaBotikarentzat(bo);
			} else { //tratamendua
				
			}
		} else { //4 da.
			this.aukeratuDeskarteak();
		}
	
	}
	
	public void aukeratuDeskarteak() {
		boolean b0=false;
		boolean b1=false;
		boolean b2=false;
		int kont=0;
		int zenb=0;
		System.out.println("Karta hau deskartatu nahi duzu? (0 -> geratu | beste zenbaki bat -> deskartatu)");
		this.eskua.getKarta(0).inprimatu();
		Scanner scanner = new Scanner(System.in);
		zenb=scanner.nextInt();
		if (zenb!=0) {
			b0=true;
			kont++;
		}
		System.out.println("Karta hau deskartatu nahi duzu?");
		this.eskua.getKarta(1).inprimatu();
		zenb=scanner.nextInt();
		if (zenb!=0) {
			b1=true;
			kont++;
		}
		System.out.println("Karta hau deskartatu nahi duzu?");
		this.eskua.getKarta(2).inprimatu();
		zenb=scanner.nextInt();
		if (zenb!=0) {
			b2=true;
			kont++;
		}
		if (b2) {
			this.eskua.deskartatu(this.eskua.getKarta(2));
		}
		if (b1) {
			this.eskua.deskartatu(this.eskua.getKarta(1));
		}
		if (b0) {
			this.eskua.deskartatu(this.eskua.getKarta(0));
		}
		while (kont!=0) {
			this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
			kont--;
		}
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
			System.out.println("4 organo dituzu mahaian jadanik!!");
		}
	}
	
	
	public void infektatuJokalaria(Birusa pBi) {
		int zenb = 0;
		System.out.println("Zein jokalari infektatu nahi duzu?");
		Scanner scanner = new Scanner(System.in);
		zenb=scanner.nextInt()-1;
		if(zenb>4 || zenb<0) {
			System.out.println("HACER EXCEPCION");
		}
		else {
			if (!ListaJokalariak.getNireListaJokalariak(0).getLista()[zenb].koloreBerdinekoOrganoDago(pBi)) {
				System.out.println("Jokalari hau ez dauka kolore horretako organorik!!");
			}
			else { //tiene un organo del mismo color que el birus que le quieres meter
				this.sartuBirusaMailan(pBi, zenb);
			}
			
		}
	}
	
	public void sartuBirusaMailan(Birusa pBirusa, int zenb) { 
		Karta[] mahaiaAur = ListaJokalariak.getNireListaJokalariak(0).getLista()[zenb].getMahaia();
		boolean aurk = false;
		int i = 0;
		while (i < 4 && !aurk) {
			if ((mahaiaAur[i] !=null) && ((mahaiaAur[i].koloreBerdina(pBirusa))|| pBirusa.kolorea.equals("Guztiak"))) {
				aurk = true;
			}
			else {
				i++;
			}

		}
		if (aurk) {
			Karta k = mahaiaAur[i];
			Organoak or = (Organoak)k;
			if (or.getMedikamentuKop() == 2) {
				System.out.println("Ezin da organo hau infektatu bakunatuta dagoelako");
			}
			else if (or.getMedikamentuKop() == 1) {
				or.setMedikamentuKop(0);
				System.out.println("Organo hau medikamentu bat zuen eta zure birusa erabiliz medikamentu hau kendu zaio");
				this.eskua.deskartatu(pBirusa);
				this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
			}
			else if (or.getBirusKop() == 1) {
				or.setBirusKop(0);
				System.out.println("Jokalari horren organoa suntzitu duzu!!");
				Tableroa.getNiretableroa().deskartatu(mahaiaAur[i]);
				mahaiaAur[i] = null;
				this.eskua.deskartatu(pBirusa);
				this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
			}
			else { //no tiene nada
				or.setBirusKop(1);
				System.out.println("Jokalari horren organoa infektatu duzu!!");
				this.eskua.deskartatu(pBirusa);
				this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
			}
			
		}
		else {
			System.out.println("Oraindik ez dauka kolore horretako organorik mahaian!!");
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
				if (or.getMedikamentuKop() == 2) {
					System.out.println("Organo hau jada bakunatuta dago!!");
				}
				else if (or.getMedikamentuKop() == 1) {
					or.setMedikamentuKop(2);
					System.out.println("Zure organoa bakunatu duzu");
					this.eskua.deskartatu(pBo);
					this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
				}
				else if (or.getBirusKop() == 1) {
					System.out.println("Zure organoa zeukan birusa sendatu duzu!");
					or.setBirusKop(0);
					this.eskua.deskartatu(pBo);
					this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
				}
				else { //no tiene nada
					or.setMedikamentuKop(1);
					System.out.println("Zure organoari medikamentu bat jarri diozu");
					this.eskua.deskartatu(pBo);
					this.eskua.kartaGehitu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
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
	
	public void mahaiaInprimatu() {
		int i = 0;
		while (i < 4) {
			if(this.mahaia[i] != null) {
				Karta k  = this.mahaia[i];
				Organoak or = (Organoak)k;
				or.mahaianInprimatu();		
			}
			else {
				System.out.println("Hutsik");
			}
			i++;
		}
	}
	
			

}
