package Birus;
import java.util.Scanner;
public class Teklatua {
	private static Teklatua nireTeklatua=null;
	private Scanner sc;
	
	private Teklatua() {
		this.sc=new Scanner(System.in);
	}
	
	public static synchronized Teklatua getNireTeklatua() {
		if (nireTeklatua==null) {
			nireTeklatua= new Teklatua();
		}
		return nireTeklatua;
	}
	
	private boolean zenbakiaDa(String pHitza){
	    try{
	          Integer.parseInt(pHitza);
	          return true;
	    }
	    catch(NumberFormatException ex){
	        return false;
	    } 
	}
	
	public String irakurriHitz(){
		String sar=this.sc.nextLine();	
		boolean emaitza=this.zenbakiaDa(sar);
		if(emaitza==true){
			int zenbaki=Integer.parseInt(sar);
			String hitz=Integer.toString(zenbaki);
			return hitz;
		}
		else{
			return sar;
		}
	}
	
	public int irakurriHiruOpzioak() throws NumberFormatException, HiruOpzioException{
		String sar=this.sc.nextLine();
		int zenbaki=Integer.parseInt(sar);
		if(zenbaki<1 || zenbaki >3) {
			throw new HiruOpzioException();
		}
		return zenbaki;
	}
	
	public int irakurriLauOpzioak() throws NumberFormatException, LauOpzioException{
		String sar=this.sc.nextLine();
		int zenbaki=Integer.parseInt(sar);
		if(zenbaki<1 || zenbaki >4) {
			throw new LauOpzioException();
		}
		return zenbaki;
	}


	public int irakurriKartak() { 
		int zenb=-1;
		try {
			System.out.println("Sartu 1-3 zenbaki bat eskuko karta bat botatzeko edo sakatu 4 deskartatzeko:");
			Scanner scanner = new Scanner(System.in);
			zenb=scanner.nextInt()-1;
			//scanner.close();
			if(zenb>4 || zenb<-1) {
				throw new HiruOpzioException();
			}
		}
		catch (HiruOpzioException e) {
		e.inprimatu();
			int lag=this.irakurriKartak();
			while(lag>4 || lag<-1){
				e.inprimatu();
				lag=this.irakurriKartak();
			}
			zenb=lag;
		}
		return zenb;
	}
	public static void main(String[] args) {
		Teklatua.getNireTeklatua().irakurriKartak();
	}
	
	public int irakurriJKop() {
		int jKop=0;
		try {
			System.out.println("Sartu jokalari kopurua:");
			Scanner scanner = new Scanner(System.in);
			jKop=scanner.nextInt();
			if (jKop<2 || jKop>6) {
			throw new  jKopException();
			}
		} catch(jKopException j) {
			j.inprimatu();
			int lag=this.irakurriJKop();
		jKop=lag;
		}
		return jKop;
	}
}
