import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        USD usd=new USD();
        ILS ils= new ILS();
        double value=0;
        int DorS;
        boolean  continueCalc= true;
        boolean isNotValid= false;
        boolean notValidAns=false;
        boolean notValidAmount=false;
        double amount=0;
        List<Double> results= new ArrayList<>();// a list of all the results.
        System.out.println("Wellcome to currency converter!");
        while (continueCalc) {//will continue the loop if the user will insert "y"
            System.out.println("please choose an option (1/2): ");
            System.out.println("1. Dollars to Shekels");
            System.out.println("2. Shekels to Dollars");
             do{  DorS=0;
                 Scanner s = new Scanner(System.in);// will get an input from the user.
                 try {
                     DorS = s.nextInt();
                 }catch (InputMismatchException i){
                     i.printStackTrace();
                     //String dors=s.next();
                 }
                 if (DorS == 1) {
                     value = usd.getvalue();//  getvalue function-will enter to 'value' the usd value from USD class.
                     isNotValid=false;// it's a valid input.
                 } else if (DorS == 2) {
                     value = ils.getvalue();//getvalue function-will enter to 'value' the ils value from ILS class.
                     isNotValid=false;// it's a valid input.
                 } else {
                     System.out.println("error\n invalid choice, please try again (1/2)");
                     isNotValid=true;//  not valid input,will continue the loop.
                 }

            }while (isNotValid);//will continue getting inputs till a valid input will be inserted.
             System.out.println("please enter an amount to convert:");
            Scanner a = new Scanner(System.in);
  do{      notValidAmount=false;

        try {
             amount = a.nextDouble();// will get an input from the user.
            if (amount<0) {
                throw new negetiveNumberExepetion();//will throw a new exeption  defined-negative number exeption.
            }
        }catch (InputMismatchException I){//catch an exeption-when the input isn't a number.
            I.printStackTrace();
            String input =  a.next();//read the invalid input.
            System.out.println("error\nthe input you have inserted: {"+input+ "} isn't valid\n please enter just  a number");
            notValidAmount=true;


        } catch (negetiveNumberExepetion negetiveNumberExepetion) {// catch the one more exeption-(the new exeption)-when the input it's a negetive number.
            System.out.println("error\n please enter a positive number");
            negetiveNumberExepetion.printStackTrace();
            notValidAmount=true;//it's a negative input.

        }}while (notValidAmount);//will continue getting inputs till a positive input will be inserted.

            double result = convert(amount,value);// will call the convert function and enter the result to 'result'.
            System.out.println(result);
            results.add(result);//add the result to the list.
            do{System.out.println("Do you want to start over? y/n");
                //Scanner b = new Scanner(System.in);
            String goBack  = a.next();// get an input from the user.
            if ((goBack.equals("N"))||(goBack.equals("n"))) {
                continueCalc = false;//will break the loop.
                notValidAns=false;// it's a valid input.
            }else if ((goBack.equals("Y"))||(goBack.equals("y"))){
                continueCalc=true;// continue in the loop.
                notValidAns=false;// it's a valid input.
            }else {
                notValidAns=true;//it's an invalid input.
                System.out.println("error\n please choose just y/n");
            }
            }while (notValidAns);//will continue getting inputs till a valid input will be inserted.
    }
        System.out.println("Thanks for using our currency converter!");
        System.out.println("your results are:");
        for (double result:results) {// will print the results list.
            System.out.println(result);
        }



    }

    ////////////////////////////////////////////////////////////
    //   this function calculates the sum of the specific coin.
    ////////////////////////////////////////////////////////////
       private static double convert(double amount,double value){
       return value*amount;
   }
    

}
