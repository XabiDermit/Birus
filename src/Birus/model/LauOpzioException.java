package Birus.model;

public class LauOpzioException extends Exception{
	
	private String testua= "Mota Okerra, sartu 1,2,3 edo 4 zenbakiak:";
			
	public LauOpzioException (){
		super ();
	}
	
	public void inprimatu(){
		System.out.println(this.testua);
	}
}
