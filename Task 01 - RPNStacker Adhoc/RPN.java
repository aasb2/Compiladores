import java.nio.file.*;
import java.io.*;
import java.util.Stack;

class RPN{
    public static String operation(String num1,String op,String num2){
        int numInt1 = Integer.parseInt(num1);
        int numInt2 = Integer.parseInt(num2);
        int result = 0;
        if(op.equals("+"))
            result = numInt1+numInt2;
        else if(op.equals("-"))
            result = numInt1-numInt2;
        else if(op.equals("*"))
            result = numInt1*numInt2;
        else if (op.equals("/"))
            result = numInt1/numInt2;

        return Integer.toString(result);
    }
    public static void main(String[] args){
        //It was supposedto have some logic to read the expression from a file
        //For now the expression will be a string
        
        Stack<String> stack = new Stack<String>();
        String expression = "4 8 + 3 *";
        String exp[] = expression.split(" ");
        String num1, num2;

        

        for(int i = 0; i<exp.length; i++){
            if(exp[i].equals("+") || exp[i].equals("-") || exp[i].equals("*")  || exp[i].equals("/")){
                
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(operation(num1,exp[i],num2));
                //System.out.println(num1);
                //System.out.println(num2);
                //System.out.println(operation(num1,exp[i],num2));
            }
            else
                stack.push(exp[i]);
        }
        
        System.out.println(stack.pop());
   
    }
 
}