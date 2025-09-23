import java.util.Scanner;

public class P_3_Calculator {

    public static void main(String[] args){

       
        Scanner sc = new Scanner(System.in);
      

while (true) {
    
    System.out.println("Enter the two numbers");
      int num1 = sc.nextInt(); 
        int num2 = sc.nextInt(); 
        System.out.println("Enter the operation to perform base upon + - * / % ");
        String operation = sc.next();
        char  op = operation.charAt(0);
     if( op == '+' || op == '-' || op == '*' || op == '/' || op=='%')
        {
            
                  switch (op) {
            case '+':
                
                System.out.println(num1 + num2);
                
                break;

                 case '-':

                 System.out.println(num1 - num2);
                
                break;

                 case '/':
                 if(num2 == 0 )
                 {
                    System.out.println("you cannot divide number by 0");
                    break;
                 }

                 System.out.println(num1 / num2);
                
                break;

                 case '*':

                 System.out.println(num1 * num2);
                
                break;

                     case '%':

                     System.out.println(num1 % num2);
                
                break;
        
            default:
              System.out.println("Enter the valid operation");
                break;

                
        }


        }
        else if( op != '+' || op != '-' || op != '*' || op != '/' || op !='%')
         {
            System.out.println("enter the valid character");
           sc.next();

        }
      
      
}
       

  


    }
     
}