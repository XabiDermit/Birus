package Birus;

import java.util.Scanner;

public class Exekutagarria {
	
	public static void main(String[] args) {
		int jKop=Teklatua.getNireTeklatua().irakurriJKop();
		boolean amaitu=false;
		Tableroa.getNiretableroa();
		ListaJokalariak.getNireListaJokalariak(jKop);
		Tableroa.getNiretableroa().kartakBanatu();
		int j=0;
		while(!amaitu) {
			ListaJokalariak.getNireListaJokalariak(0).getLista()[j].jokatu();
			if (ListaJokalariak.getNireListaJokalariak(0).getLista()[j].irabaziDu()) {
				amaitu=true;
			} else {
				j++;
				if (j==ListaJokalariak.getNireListaJokalariak(0).getJkop()) {
					j=0;
				}
			}
		}	
	}
			
}


