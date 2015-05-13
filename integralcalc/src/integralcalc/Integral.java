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
		Node head=new Node();
		System.out.println(recurse(head,s));
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
		return data.substring(getMult(data).length()+1) ;
	}
	private String getMult(String data) {
		String s="";
		int parenthesis=0;
		for(int i=0;i<data.length(); i++){
			if(data.charAt(i)=='(') parenthesis++;
			if(data.charAt(i)==')') parenthesis--;
			if((parenthesis==0) &&  data.charAt(i)=='*') break;
			s+=data.charAt(i);
		}
		return s;
	}

	private boolean commonIntegral(String data) {
		boolean common=false;
		if(data=="cos(x)"){
			common= true;
		}else if(data=="sin(x)"){
			common= true;
		}else if(data=="1/x"){
			common= true;
		}else if(data=="1/1+(x^2)"){
			common= true;
		}
		return common;
	}
	
	public String recurse(Node n, String s){
		n.data=s;
		if(multipleTerms(s)){
			String top=getTopTerm(s);
			String bottom=getBottomTerm(s);
			n.leftchild=new Node();
			n.rightchild=new Node();
			n.leftchild.data=recurse(n.leftchild,top);
			n.rightchild.data=recurse(n.rightchild,bottom);
			return n.leftchild.data + "+" + n.rightchild.data;
		}
		if(constantMultiplier(s)){
			if(multipleTerms(getBase(s))){
				String mult=getMult(s);
				s=getBase(s);
				String top=getTopTerm(s);
				String bottom=getBottomTerm(s);
				n.leftchild=new Node();
				n.rightchild=new Node();
				n.leftchild.data=recurse(n.leftchild,top);
				n.rightchild.data=recurse(n.rightchild,bottom);
				return mult+ "*" + n.leftchild.data + "+" + n.rightchild.data;
			}else{
				String mult=getMult(s);
				s=getBase(s);
				return mult+"*"+evaluateIntegral(s);
			}
		}
		if(!multipleTerms(s)){
			return evaluateIntegral(s);
		}
		return "Unable to evaluate";
	}
	private String evaluateIntegral(String s) {
		String ret;
		if(s.charAt(0)=='+')s=s.substring(1);
		if(s.equals("cos(x)")){
			ret= "sin(x)";
		}else if(s.equals("sin(x)")){
			ret= "-cos(x)";
		}else if(s.equals("1/x")){
			ret= "ln(x)";
		}else if(s.equals("1/1+(x^2)")){
			ret= "arctan(x)";
		}else ret="";
		return ret;
	}
	
	private String getBottomTerm(String s2) {
		int parenthesis=0;
		String temp = "";
		for(int i=0; i<s.length(); i++){
			if (s.charAt(i)=='(') parenthesis++;
			if (s.charAt(i)==')') parenthesis--;
			if ( (s.charAt(i)=='+' || s.charAt(i) == '-') &&
					parenthesis==0 && i!=0)
			{ 
				s=s.substring(i);
				return s;
			}
			temp+=s.charAt(i);
			
		}
		return s;
	}
	private String getTopTerm(String s) {
		int parenthesis=0;
		String temp = "";
		for(int i=0; i<s.length(); i++){
			if (s.charAt(i)=='(') parenthesis++;
			if (s.charAt(i)==')') parenthesis--;
			if ( (s.charAt(i)=='+' || s.charAt(i) == '-') &&
					parenthesis==0 && i!=0)
			{ 
				s=s.substring(i);
				return temp;
			}
			temp+=s.charAt(i);
			
		}
		return s;
	}
	private boolean multipleTerms(String s) {
		if(s==getTopTerm(s))return false;
		return true;
	}
	private boolean constantMultiplier(String s) {
		boolean foundnum=false;
		boolean hasMultiplier=false;
		for(int i=0;i<s.length();i++){
			if(Character.isDigit(s.charAt(i))){
				foundnum=true;
			}
			if(foundnum && s.charAt(i)=='*'){
				hasMultiplier=true;
			}
			if(s.charAt(i)=='x') break;
		}
		return hasMultiplier;
	}
}
