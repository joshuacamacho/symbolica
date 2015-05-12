package integralcalc;
import java.util.*;


public class Integral {
	String s;
	String sIntegral;
	LinkedList<String> terms;
	Node head;
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
		}else if(str=="1/1+(x^2)"){
			ret= "arctan(x)";
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
	
	public void addTraverse(Node n, String s){
		n.data=s;
		if(!n.finished && !commonIntegral(n.data)){
			n.leftchild=new Node(getMult(n.data));
			addTraverse(n.rightchild,(getBase(n.data)));	
		}
		if(commonIntegral(n.data) && !n.finished){
			n.leftchild=null;
			n.finished=true;
			addTraverse(n.rightchild,getIntegral(n.data));
		}
		if(n.finished){
			n.leftchild=new Node(getMult(n.data));
			n.rightchild=new Node(getBase(n.data));
		}
	}
	private String getIntegral(String data) {
		// TODO Auto-generated method stub
		return null;
	}
	private String getBase(String data) {
		// TODO Auto-generated method stub
		return data.substring(getMult(data).length()-1) ;
	}
	private String getMult(String data) {
		String s="";
		int parenthesis=0;
		for(int i=0;i<data.length(); i++){
			if(data.charAt(i)=='(') parenthesis++;
			if((parenthesis==0) && (data.charAt(i)=='(' || data.charAt(i)=='*')){
				if(s=="-") s+="1";
				break;
			}
			if(data.charAt(i)=='(') parenthesis--;
			s+=data.charAt(i);
		}
		return s;
	}

	private boolean commonIntegral(String data) {
		// TODO Auto-generated method stub
		return false;
	}
}
