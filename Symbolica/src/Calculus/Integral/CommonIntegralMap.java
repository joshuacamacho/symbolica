package Calculus.Integral;

import java.util.HashMap;

public class CommonIntegralMap {
	static HashMap<String, String> m=new HashMap<String, String>();
	CommonIntegralMap(){
		m.put("cos(x)", "sin(x)");
		m.put("sin(x)", "-cos(x)");
		m.put("e^x", "e^x");
		m.put("sec^2(x)", "tan(x)");
		m.put("csc^2(x)", "-cot(x)");
		m.put("sec(x)tan(x)", "sec(x)");
		m.put("csc(x)cot(x)", "-csc(x)");
		m.put("sec(x)", "ln|sec(x)+tan(x)|");
		m.put("csc(x)", "ln|csc(x)-cot(x)|");
		m.put("tan(x)", "ln|sec(x)|");
		m.put("cot(x)", "ln|sin(x)|");
		m.put("sinh(x)", "cosh(x)");
		m.put("cosh(x)", "sinh(x)");
		m.put("1/x", "ln|x|");
		m.put("x^(2)", "(1/3)*x^(3)");
		m.put("x", "(1/2)*x^(2)");
		m.put("1/(1+x^2)","arctan(x)");
		m.put("sin^2(x)", "(1/2)*(x-sin(x)cos(x))");
		m.put("cos^2(x)", "(1/2)*(x+sin(x)cos(x))");
		m.put("sin(x)cos(x)","-1*(1/2)cos^2(x)");
		m.put("cos(x)sin(x)","-1*(1/2)cos^2(x)");
	}
	public boolean contains(String s){
		boolean cont=false;
		if(m.containsKey(s)) cont=true;
		return cont;
	}
	public String getIntegral(String s){
		return m.get(s);
	}
}
