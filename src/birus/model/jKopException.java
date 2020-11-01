package Birus;

public class jKopException extends Exception {
	private String testua="Partidek 2-6 arteko jokalari kopurua izan behar dute.";
	
	public jKopException() {
		super();
	}
	public void inprimatu() {
		System.out.println(this.testua);
	}
}
