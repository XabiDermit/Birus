package Birus.model;

import javafx.scene.image.Image;


public class Organoak extends Karta {
	private boolean komodin;
	private int estado;
	//estado = 0 --> normal
	//estado = 1 --> con un botiquin
	//estado = 2 --> blindado
	//estado = -1 --> un birus
	//estado = -2 --> muerto

	
	public Organoak (String pKolorea, boolean pKomodin, int pBakunaKop, Image pKarta) {
		super(pKolorea, pKarta);
		this.kolorea=pKolorea;
		this.komodin=pKomodin;
		this.estado =pBakunaKop;
	}
	public void inprimatu() {
		System.out.println("Organo "+ super.kolorea);
	}
	public boolean guztizBakunatuta() {
		boolean emaitza=false;
		if(this.estado ==2) {
			emaitza=true;
		}
		return emaitza;
	}
	public boolean guztizInfektatuta() {
		boolean emaitza=false;
		if(this.estado == -2) {
			emaitza=true;
		}
		return emaitza;
	}
	public void bakunaKopHanditu() {
		if(this.estado < 2) {
			this.estado++;
		}
	}
	public void birusKopHanditu() {
		if(this.estado > -2) {
			this.estado--;
		}
	}
	public boolean osasuntsuDago() {
		//devuelve si esta blindado o no
		return estado == 2;
	}

	public int getEstado() {
		return this.estado;
	}
	
	public void setEstado(int pKop) {
		this.estado = pKop;
	}

	public void actualizarEstadoCarta(){
		String tipoOrgano = this.getKarta().getUrl().split("/")[11];
		//asi consigo quitarle el + o - del final y el metodo funciona como deberia
		if (tipoOrgano.endsWith("plus.png")) {
			tipoOrgano =  tipoOrgano.replace("plus","");
		}else if (tipoOrgano.endsWith("minus.png")){
			tipoOrgano = tipoOrgano.replace("minus","");
		}
		if (tipoOrgano.equals("cerebroazul.png")) {
			if (estado == 2) {
				super.setCarta(new Image("/Birus/ui/Imagenes/test.jpeg"));
			} else if (estado == 1) {
				super.setCarta(new Image("/Birus/ui/Imagenes/cerebroazulplus.png"));
			} else if (estado == 0) {
				super.setCarta(new Image("/Birus/ui/Imagenes/cerebroazul.png"));
			} else if (estado == -1) {
				super.setCarta(new Image("/Birus/ui/Imagenes/cerebroazulminus.png"));
			} else {
				//esta muerta, ponemos contador de vidas a 0 para cuando vuelvan a meter la carta
				setEstado(0);
				super.setCarta(new Image("/Birus/ui/Imagenes/cerebroazul.png"));
			}
		}else if (tipoOrgano.equals("corazonrojo.png")) {
			if (estado == 2) {
				super.setCarta(new Image("/Birus/ui/Imagenes/test.jpeg"));
			} else if (estado == 1) {
				super.setCarta(new Image("/Birus/ui/Imagenes/corazonrojoplus.png"));
			} else if (estado == 0) {
				super.setCarta(new Image("/Birus/ui/Imagenes/corazonrojo.png"));
			} else if (estado == -1) {
				super.setCarta(new Image("/Birus/ui/Imagenes/corazonrojominus.png"));
			} else {
				//esta muerta, ponemos contador de vidas a 0 para cuando vuelvan a meter la carta
				setEstado(0);
				super.setCarta(new Image("/Birus/ui/Imagenes/corazonrojo.png"));
			}
		}else if (tipoOrgano.equals("estomagoverde.png")) {
			if (estado == 2) {
				super.setCarta(new Image("/Birus/ui/Imagenes/test.jpeg"));
			} else if (estado == 1) {
				super.setCarta(new Image("/Birus/ui/Imagenes/estomagoverdeplus.png"));
			} else if (estado == 0) {
				super.setCarta(new Image("/Birus/ui/Imagenes/estomagoverde.png"));
			} else if (estado == -1) {
				super.setCarta(new Image("/Birus/ui/Imagenes/estomagoverdeminus.png"));
			} else {
				//esta muerta, ponemos contador de vidas a 0 para cuando vuelvan a meter la carta
				setEstado(0);
				super.setCarta(new Image("/Birus/ui/Imagenes/estomagoverde.png"));
			}
		}else if (tipoOrgano.equals("huesoamarillo.png")){
			if (estado == 2){
				super.setCarta(new Image("/Birus/ui/Imagenes/test.jpeg"));
			}else if (estado == 1){
				super.setCarta(new Image("/Birus/ui/Imagenes/huesoamarilloplus.png"));
			}else if (estado == 0){
				super.setCarta(new Image("/Birus/ui/Imagenes/huesoamarillo.png"));
			}else if (estado == -1){
				super.setCarta(new Image("/Birus/ui/Imagenes/huesoamarillominus.png"));
			}else{
				//esta muerta, ponemos contador de vidas a 0 para cuando vuelvan a meter la carta
				setEstado(0);
				super.setCarta(new Image("/Birus/ui/Imagenes/huesoamarillo.png"));
			}
		}else{	//es el comodin
			if (estado == 2){
				super.setCarta(new Image("/Birus/ui/Imagenes/test.jpeg"));
			}else if (estado == 1){
				super.setCarta(new Image("/Birus/ui/Imagenes/organocomodinplus.png"));
			}else if (estado == 0){
				super.setCarta(new Image("/Birus/ui/Imagenes/organocomodin.png"));
			}else if (estado == -1){
				super.setCarta(new Image("/Birus/ui/Imagenes/organocomodinminus.png"));
			}else{
				//esta muerta, ponemos contador de vidas a 0 para cuando vuelvan a meter la carta
				setEstado(0);
				super.setCarta(new Image("/Birus/ui/Imagenes/organocomodin.png"));
			}
		}
	}
}
