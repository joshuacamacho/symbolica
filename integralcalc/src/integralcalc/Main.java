package integralcalc;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integral i=new Integral();
		i.eval("cos(x)+sin(x)+1/x+1/x+cos(x)");
		i.eval("3*1/x");
		
		//i.displayterms();
		
	}

}
