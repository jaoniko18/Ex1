import java.util.Locale;
import java.util.Scanner;

/********************/
//342854965 nickolai korgan
/********************/

//class that has all functionalities
public class Ex1 {

//function that gets a string and returns an int
    public static int number2Int(String num) {
        int ans = -1;
        int indexB = -1; //looking for char b
        int  base, temp;
        double  tempNumber = 0;
        char ch;
        num=num.trim();
        String a1 = "";
        String a2 = "";
        indexB = num.indexOf('b'); // looking for char b
        if(num.length()==0){ //empty string
            return -1;
        }
        if(indexB != -1) { //found b chat in string
            a1 = num.substring(0,indexB); //substring before b
            a2 = num.substring(indexB+1); //substring after b
            if (a2.length() == 1 && a2.charAt(0) >= 'A' && a2.charAt(0) <= 'G') {
                a2 = String.valueOf(10 + (a2.charAt(0) - 'A'));  //working w letters in the string
            }
            if(a1.length()==1) {     //switch case. checks if substring before b is only 1 letter.
                switch (a1){
                    case "A": return 10;
                    case "B": return 11;
                    case "C": return 12;
                    case "D": return 13;
                    case "E": return 14;
                    case "F": return 15;
                    case "G": return 16;

                }
            }
            if (a1.length() == 1 && a1.charAt(0) >= 'A' && a1.charAt(0) <= 'F') {
                a1 = String.valueOf(10 + (a1.charAt(0) - 'A')); //working with letters
            }
            if(!isNumeral(a2)) {
                return -1; //empty substring
            }
            // here is the main algorithm for converting string
            base = Integer.parseInt(a2);
            if(isNumeral(a1, base) && isNumeral(a2, base+1)) { //checking if both base and number are numbers
                String reversed = new StringBuilder(a1).reverse().toString();
                for(int i=0;i<reversed.length();i++) {
                    ch = reversed.charAt(i);
                    if('0' <= ch && ch <= '9') {   //workg
                        temp = ch - '0';
                        tempNumber = tempNumber + (Math.pow(base,i)*temp);
                        ans = (int) tempNumber;
                    }
                    else {
                        temp = ch - 'A' + 10;
                        tempNumber = tempNumber + (Math.pow(base,i)*temp);
                        ans = (int) tempNumber;
                    }
                }
            }
        }
        else {
            if(isNumber(num)){
                ans = Integer.parseInt(num); // no letters in the string
            }
        }
        return ans;
    }

    //checking if symbols are ok: 2b2 not okay because there is no number "2" in binary
    public static boolean isDigit(char a, int index){
        String digits = "0123456789ABCDEFG";
        digits = digits.substring(0, index);
        for(int i=0; i<digits.length();i++){
            if(a==digits.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    //checking if the base is correct
    public static boolean isNumeral(String a) {
        int base = 16;
        for(int i=0; i<a.length();i++) {
            if(!isDigit(a.charAt(i), base)) {
                return false;
            }
        }
        return true;
    }

    //checking if symbols are okay
    public static boolean isNumeral(String a, int base) {
        for(int i=0; i<a.length();i++) {
            if(!isDigit(a.charAt(i), base)) {
                return false;
            }
        }
        return true;
    }
    //checking if the number is number and not gibberish
    public static boolean isNumber(String a) {
        boolean ans = true;
        int indexB = -1; //looking for char b
        int base;
        String a1 = "";
        String a2 = "";
        indexB = a.indexOf('b');
        // add your code here
        if(indexB != -1) {
            a=a.trim();
            a1 = a.substring(0,indexB);
            a2 = a.substring(indexB+1);
            // switch case to catch wrong enter of b11-16
            switch (a2){
                case "11": return false;
                case "12": return false;
                case "13": return false;
                case "14": return false;
                case "15": return false;
                case "16": return false;
            }
            //////
            if (a2.length() == 1 && a2.charAt(0) >= 'A' && a2.charAt(0) <= 'G') {
                a2 = String.valueOf(10 + (a2.charAt(0) - 'A'));
            } //check if base is smthing
            if(a2.length()==0 || a1.length()==0) {
                return false;
            }
            if(!isNumeral(a2)) {
                return false;     //base is not right
            }
            base = Integer.parseInt(a2);
            if(!isNumeral(a1, base) || !isNumeral(a2, base+1)) {  //substring are wrong
                return false;
            }
        } else if(!isNumeral(a,10)){
            ans = false;            //if there is no "b" character that it is a basis 10
        }
        return ans;
    }


    public static String int2Number(int num, int base) {
        String ans = "";
        boolean key = true;
        boolean key1 = false;
        int tempNum = num;
        int temp = 0;
        String str = "" + num;
        // main algorithm of representing number in another basis //
        if(num < 0 || base < 2 || base > 16 ) {
            return ans;
        } else {
            while (key) {
                temp = tempNum % base;
                if (temp >= 10 && temp <= 16) {
                    ans += (char) ('A' + (temp - 10));
                    temp = 0;
                    key1 = true;
                }
                if (key1) {
                    ans = ans;
                    tempNum = tempNum / base;
                    key1 = false;
                } else {
                    ans = ans + temp;
                    tempNum = tempNum / base;
                }
                if (tempNum == 1 || tempNum < base) {
                    if(tempNum >=10){
                        ans += (char) ('A' + (tempNum - 10));
                    }else {
                        String s = String.valueOf(tempNum);
                        ans = ans + s;
                    }
                    key = false;
                }
            }
            String ans1 = new StringBuilder(ans).reverse().toString();
            ans = ans1;
            if (ans.length() == 2 && (Ex1.equals(ans, "00"))) {
                return "0" + "b" + base;
            } else {
                ans = ans.replaceFirst("^0+", "");
                String str_base = "";
                if (base >= 11 && base <= 16) {
                    str_base += (char) ('A' + (base - 10));
                    ans = ans + "b" + str_base;
                } else {
                    ans = ans + "b" + base;
                }
            }
        }
        //
        return ans;
    }

    //checking if 2 string have the same values
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here
        if(number2Int(n1)!=number2Int(n2)) {
            return false;
        }
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        int max = 0;
        // looking for biggest number in array
        max = number2Int(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(max < number2Int(arr[i])) {
                max = number2Int(arr[i]);
            }
        }
        ans = max;
        return ans;
    }
}

