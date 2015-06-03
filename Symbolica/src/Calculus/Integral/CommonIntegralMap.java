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
    public boolean checkPowerRule(String s){
        if(s.charAt(0)!='x')return false;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='^')return true;
        }
        return false;
    }
    public String getIntegral(String s){
        if (contains(s)) return m.get(s);
        if(checkPowerRule(s)) return evalPowerRule(s);
        if(isConstant(s))return constantRule(s);
        return "NOEVAL";
    }

    private String evalPowerRule(String s) {
        boolean foundSign=false;
        String powNum="";
        for(int i=0; i<s.length();i++){
            
            if(foundSign && s.charAt(i)!='(' && s.charAt(i)!=')') 
                powNum+=s.charAt(i);
            if(s.charAt(i)=='^')foundSign=true;
        }
        
        
        return getMultPowRule(powNum)+"*x^"+getPowerPowRule(powNum);
    }

    private String getMultPowRule(String s) {
        if(isFraction(s)){
            return "("+reciprocal(addOneFraction(s))+")";
        }else{
            return "(1/"+addOne(s)+')';
        }
        
    }
    
    private boolean isFraction(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='/')return true;
        }
        return false;
    }
    
    private String getPowerPowRule(String s) {
        if(isFraction(s)) return "("+addOneFraction(s)+")";
        else return addOne(s);
    }

    private String addOne(String powNum) {
        int x=Integer.parseInt(powNum)+1;
        return Integer.toString(x);
    }

    private String addOneFraction(String s) {
       String top="";
       String bottom="";
        boolean foundDivide=false;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='/')foundDivide=true;
            if(foundDivide && s.charAt(i)!='/')bottom+=s.charAt(i);
            else if(s.charAt(i)!='/') top+=s.charAt(i);
        }
        int t = Integer.parseInt(top);
        int b = Integer.parseInt(bottom);
        t+=b;
       return Integer.toString(t)+"/"+Integer.toString(b);
    }

    private String reciprocal(String s) {
        String top="";
        String bottom="";
        boolean foundDivide=false;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='/')foundDivide=true;
            if(foundDivide && s.charAt(i)!='/')bottom+=s.charAt(i);
            else if(s.charAt(i)!='/') top+=s.charAt(i);
        }
        return bottom+"/"+top;
    }

    private boolean isConstant(String s) {
       for(int i=0;i<s.length();i++){
           if(!Character.isDigit(s.charAt(i))&& s.charAt(i)!='/' && s.charAt(i)!='('
                   && s.charAt(i)!=')' && s.charAt(i)!='-') return false;
       }
       return true;
    }

    private String constantRule(String s) {
        
        return s+"*x";
    }
}
