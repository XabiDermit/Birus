package Birus;

import java.util.Scanner;

public class HiruOpzioException extends Exception{
	
	private String testua= "Mota Okerra, sartu 1,2 edo 3 zenbakiak:";
			
	public HiruOpzioException (){
		super ();
	}
	
	public void inprimatu(){
		System.out.println(this.testua);
	}
	
	

}
