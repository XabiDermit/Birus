package Birus.model;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaKartak {
	private ArrayList <Karta> lista;
	
	public ListaKartak() {
		this.lista=new ArrayList <Karta>();
	}
	
	private Iterator<Karta> getIteradorea() {
		return this.lista.iterator();
	}
	
	public void kartaGehitu (Karta pKarta) {
		this.lista.add(pKarta);
	}
	
	public Karta kartaKendu(int pos) {
		return this.lista.remove(pos);
	}

	public Karta repartirCarta(){
		return this.lista.remove(0);
	}
	public ArrayList <Karta> getLista(){
		return this.lista;
	}
	public int getTamaina() {
		return this.lista.size();
	}
	public Karta getKarta (int i) {
		return this.lista.get(i);
	}
	public void organoaKendu(Organoak pOrganoa) {
		this.lista.remove(pOrganoa);
	}
	public boolean organoGuztiakOsasuntsu() {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		boolean osasuntsu=true;
		Organoak organoa;
		int kont=0;
		while(itr.hasNext() && osasuntsu) {
			kartaBat=itr.next();
			if(kartaBat instanceof Organoak) {
				organoa=(Organoak)kartaBat;
				if(!organoa.osasuntsuDago()) {
					osasuntsu=false;
				}
				else {
					kont++;
				}
			}
		}
		if(osasuntsu && kont==4) {
			osasuntsu=true;
		}
		else {
			osasuntsu=false;
		}
		return osasuntsu;
	}
	public Organoak koloreBerdinekoOrganoaLortu(Karta pKarta) {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		boolean aurkitua=false;
		while(itr.hasNext() && !aurkitua) {
			kartaBat=itr.next();
			if(kartaBat instanceof Organoak) {
				if(kartaBat.koloreBerdina(pKarta)) {
					aurkitua=true;
				}
			}
		}
		if(!aurkitua) {
			System.out.println("Ez dago kolore berdineko organorik");
			kartaBat=null;
		}
		return (Organoak)kartaBat;
	}
	public boolean koloreBerdinekoOrganoaDago(Karta pKarta) {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		boolean aurkitua=false;
		while(itr.hasNext() && !aurkitua) {
			kartaBat=itr.next();
			if(kartaBat instanceof Organoak) {
				if(kartaBat.koloreBerdina(pKarta)) {
					aurkitua=true;
				}
			}
		}
		return aurkitua;
	}
	public boolean organoaJadaDago(Organoak pOrganoa) {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		boolean aurkitua=false;
		while(itr.hasNext() && !aurkitua) {
			kartaBat=itr.next();
			if(kartaBat instanceof Organoak) {
				if(kartaBat.koloreBerdina(pOrganoa)) {
					aurkitua=true;
				}
			}
		}
		return aurkitua;
	}
	public void inprimatuEskua() {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		while(itr.hasNext()) {
			kartaBat=itr.next();
			kartaBat.inprimatu();
		}
	}
	public boolean hutsik() {
		 boolean ema = false;
	        if (this.lista.size() == 0) {
	            ema = true;
	        }
	        return ema;
	}
	
	public void deskartatu (Karta pKarta) {
		this.lista.remove(pKarta);
        Tableroa.getNiretableroa().getMazoa().kartaGehitu(pKarta);
    }

    public void cambiarTodaLaMano(){
		lista.clear();
		for (int i=0;i<3;i++){
			lista.add(Tableroa.getNiretableroa().getMazoa().repartirCarta());
		}
	}

	public void intercambiarMano(ListaKartak cartasRival){
		Karta cartaAux1 = cartasRival.getKarta(0);
		Karta cartaAux2 = cartasRival.getKarta(1);
		Karta cartaAux3 = cartasRival.getKarta(2);

		cartasRival.getLista().clear();

		cartasRival.getLista().add(this.lista.get(0));
		cartasRival.getLista().add(this.lista.get(1));
		cartasRival.getLista().add(this.lista.get(2));

		this.lista.clear();

		kartaGehitu(cartaAux1);
		kartaGehitu(cartaAux2);
		kartaGehitu(cartaAux3);
	}
}
