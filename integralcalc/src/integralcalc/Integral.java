package integralcalc;
import java.util.*;

public class Integral {
	String s;
	String sIntegral;
	LinkedList<String> terms;
	public Integral(){
		terms = new LinkedList<String>();
	}
	public void eval(String str){
		this.s=str;
		termsplit(s);
	}
	public String commonCheck(String str){
		String ret="";
		if(str=="cos(x)"){
			ret= "sin(x)";
		}else if(str=="sin(x)"){
			ret= "-cos(x)";
		}else if(str=="1/x"){
			ret= "ln(x)";
		}else if(str=="1/1+x"){
			ret= "tan(x)";
		}
		return ret;
	}
	public void termsplit(String str){
		int parenthesis=0;
		String temp = "";
		for(int i=0; i<str.length(); i++){
			if (str.charAt(i)=='(') parenthesis++;
			if (str.charAt(i)==')') parenthesis--;
			if ( (str.charAt(i)=='+' || str.charAt(i) == '-') &&
					parenthesis==0)
			{ 
				terms.add(temp);
				temp="";
			}
			temp+=str.charAt(i);
			if(i+1==str.length()) terms.add(temp);
		}
	}
	public void displayterms(){
		for(String s: terms){
			System.out.println(s);
		}
	}
}
