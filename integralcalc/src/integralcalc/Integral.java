package integralcalc;

public class Integral {
	String s;
	String sIntegral;
	public Integral(){
	}
	public void eval(String str){
		this.s=str;
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
}
