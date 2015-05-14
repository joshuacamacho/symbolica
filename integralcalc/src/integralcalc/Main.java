package integralcalc;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integral i=new Integral();
		i.eval("cos(x)+(2/3)*sin(x)+2*1/x+3*1/x+49*cos(x)");
		i.eval("1/x+cos(x)+cos(x)sin(x)");
		i.eval("cosh(x)+5*(sin(x)+cosh(x))+1/x");
		i.eval("3*(1/x+3*1/x+(2/6)*cosh(x)+e^x)+3*(1/(1+x^2)+sin^2(x))");
		
		//i.displayterms();
		
	}

}
