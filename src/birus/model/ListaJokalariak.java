package Birus;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaJokalariak {
	private static ListaJokalariak nireListaJokalariak=null;
	private Jokalaria [] lista;
	private  int jKop;
	
	private ListaJokalariak(int i) {
		this.jKop=i;
		this.lista=new Jokalaria[i];
		for (int j=0;j<i;j++) {
			this.lista[j]=new Jokalaria(j);
		}
	}
	public static ListaJokalariak getNireListaJokalariak(int i) {
		if(i>1 && i<7) {
			if (nireListaJokalariak==null) {
				nireListaJokalariak=new ListaJokalariak(i);
			}
		}
		return nireListaJokalariak;
		
	}
	public void kartakBanatu(ListaKartak pMazoa) {
		for(int j=0;j<this.jKop;j++) {
			for (int i=0;i<3;i++) {
				this.lista[j].kartaHartu(Tableroa.getNiretableroa().getMazoa().kartaKendu(0));
			}
		}
	}
			
	public void partidaHasieratu() {
		Tableroa.getNiretableroa();
		Tableroa.getNiretableroa().kartakBanatu();
	}
	
	public Jokalaria[] getLista() {
		return this.lista;
	}
	public int getJkop() {
		return this.jKop;
	}
	}
