package Birus.model;

import java.util.ArrayList;

public class Exekutagarria {

	public void jugar(ArrayList<String> pJugadores) {
		int jKop= pJugadores.size();
		boolean amaitu=false;
		Tableroa.getNiretableroa();
		ListaJokalariak.getNireListaJokalariak(jKop);
		Tableroa.getNiretableroa().kartakBanatu();
		int j=0;
		while(!amaitu) {
			//ListaJokalariak.getNireListaJokalariak(0).getLista()[j].jokatu();
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

	private static Exekutagarria exekutagarria =null;

	private Exekutagarria(){}


	public static Exekutagarria getNireExekutagarria(){
		if (exekutagarria==null){
			exekutagarria = new Exekutagarria();
		}
		return exekutagarria;
	}
}



