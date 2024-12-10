
 /********************/
 /********************/
import java.util.Scanner;

//main
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        String num3 = "";
        String num_sum, num_multi;
        int sum=0;
        String str_arr[] = new String[4];
        int base;
        int multiplication = 0;
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.nextLine();
            if (!num1.equals("quit")) {
                 if(Ex1.isNumber(num1)) {
                     System.out.println("num1 is number: " + Ex1.isNumber(num1) + ", value: " + Ex1.number2Int(num1));
                     System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                     num2 = sc.nextLine();
                     if(!num2.equals("quit")) {
                         if(Ex1.isNumber(num2)){
                             System.out.println(Ex1.isNumber(num2) + ", value: " + Ex1.number2Int(num2));
                             //main solution
                             System.out.println("Enter a base for output[2,16]: ");
                             num3 = sc.nextLine();
                             if(Ex1.isNumeral(num3) && (Integer.parseInt(num3) >= 2 && Integer.parseInt(num3) <= 16)){
                                 base = Integer.parseInt(num3);
                                 sum = Ex1.number2Int(num1) + Ex1.number2Int(num2);
                                 multiplication = Ex1.number2Int(num1) * Ex1.number2Int(num2);
                                 System.out.println(Ex1.int2Number(sum,base));
                                 System.out.println(Ex1.int2Number(multiplication,base));
                                 str_arr[0] = num1;
                                 str_arr[1] = num2;
                                 num_sum = (Ex1.int2Number(sum,base));
                                 num_multi =Ex1.int2Number(multiplication,base);
                                 str_arr[2] = num_sum;
                                 str_arr[3] = num_multi;
                                 System.out.println("max number over [" + str_arr[0] + ", " + str_arr[1] + ", " + str_arr[2] + ", " + str_arr[3] + "] is " +
                                         Ex1.int2Number(Ex1.maxIndex(str_arr),base));
                             }
                             else{
                                 System.out.println("ERR: wrong base, should be [2,16), got: " + num3);
                             }
                         }
                         else {
                             System.out.println("num2 is " + Ex1.isNumber(num2) + ", value: " + num2);
                             System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
                         }
                     }
                 }
                 else {
                     System.out.println("num1 is "+ Ex1.isNumber(num1) + ", value: " + num1);
                     System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
                 }
            }
        }
        System.out.println("quiting now...");
    }
}