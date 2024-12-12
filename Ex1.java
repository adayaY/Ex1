package assignments.ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    static String digits = "0123456789ABCDEFG";

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    //The number2Int function is designed to convert a string (string) represented by a number to a decimal (decimal) base.
    // The function detects the number base and performs a conversion accordingly.

    public static int number2Int(String num) {
        int ans = -1;
        int base = num.length();

        if (!isNumber(num)) {//Calling a function 'isNumber' to check if the value is correct
            return ans;
        }
//The function checks if the string  contains only digits (by using the regular expression [0-9]+).
//If so, the function converts the string to an int by Integer.parseInt(num)

        if (num.matches("[0-9]+")) { //
            ans = Integer.parseInt(num);
            return ans;
        }

        String num1 = num.substring(0, num.length() - 2);//A command that inserts the string minus 2 last members


        base = valuebase(num);
        ans = (Integer.parseInt(num1, base));// פקודה שמחשבת מספר בססיס מסוייםif ()

        return ans;



    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {


        boolean ans = true;
        if(a.equals(" ")){
            return false;}

        if (a == null) // סקירה ובדירה שהמרחוזת לא שווה לNULL
            ans = false;
        else {
            String n = a.split("b")[0];
            if (n == "") return false;
            if (a == "")
                ans = false;

            else {
                 for (int i = 0; i < a.length()-1; i++) {
                     char A =a.charAt(i);  // התו הנוכחי
                     char B = a.charAt(i + 1); // התו הבא

                     if (Character.isLetter(A) && Character.isLetter(B) && a.charAt(i + 1) == ' ') {
                        return false;}
                    if (Character.isLetter(A) && B == ' ' && !Character.isLetter(a.charAt(i + 2))) {
                        return false;
                    }
                }
                for (int i = 0; i < n.length(); i++) {

                        if (!digits.contains(n.charAt(i) + "")) {// פונגציה הסורקת את תוי המחרוזרת ובודקת אם לא שווה לdigits
                            return false;
                        }

                    }

                    if (a.contains("b")) {
                        for (int i = 0; i < a.length() - 2; i++) {
                            if (a.charAt(i) >= a.charAt(a.length() - 1)) {
                                ans = false;
                            }
                        }
                    }
                    if (a.charAt(a.length() - 1) == 'b') {
                        ans = false;
                    }
                    if (!a.contains("b")) {//בדיקה אם זוהיא מחרוזת שלא מכילה את b
                        for (int i = 0; i < n.length(); i++) {
                            if (!digits.substring(0, 10).contains(n.charAt(i) + "")) {//
                                return false;
                            }
                        }
                    }
                }
            }

            return ans;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         *
         * @param num  the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number ( int num, int base){//פקודה שמקבלת מספר והיא תמיר אותו לבסיס נדרש
            String ans = "";
            if (num < 0 || base < 2 || base > 16)// בדיקה שהבייס תקין
                return ans;

            String a = Integer.toString(num, base).toUpperCase();// מקבלת מספר בבסיס 10 ובסיס שנמיר אליו והמרה לאותיות גדולות
            ans = a + "b" + digits.charAt(base);//מקבל את הערך (אותיות) במיקום של הבסיס

            return ans;

            //  להוסיף פןנגציה שמדפיסה תוצאה סופיתשל בסיס חד ספרתית
        }


    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        int N1=0,N2=0;
        N1=number2Int(n1);
        N2=number2Int(n2);

        if (N1==N2) {//פןנגציה המוושה אם ל2 המחרוזותיש אותו ערך
            return ans;
        } else return false; // 5bA 101b2
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param a arr array of numbers*
     * @return the index in the array in with the largest number (in value).
     */

    public static int valuebase(String a) {

        String[]arr=a.split("b");
        char ch=arr[1].charAt(0);//  מכניסה לCH את הערך של הבסיס
        int base=0 ;
        if (ch == 'A') {
            base = 10;
        }
        if (ch == 'B') {
            base = 11;
        }
        if (ch == 'C') {
            base = 12;
        }
        if (ch == 'D') {
            base = 13;

        }
        if (ch == 'E') {
            base = 14;
        }

        if (ch == 'F') {
            base = 15;
        }
        if (ch == 'G') {
            base = 16;
        }
      //  char c=base.charAt(0);
        if(base==0)
            base=Integer.parseInt(arr[1]);// במקרה והבסיס מספר ולא אות מחזיר אותו כINY


        return base;
    }

    public static int maxIndex(String[] arr) {
        int ans = 0;
        int maxValue=0;
        for (int i = 0; i <3; i++) {
            if (number2Int(arr[i])>number2Int(arr[i+1])) {
                maxValue = number2Int(arr[i]);
                ans = i;
            }
        }
        if(number2Int(arr[3])>number2Int(arr[2])){
            maxValue = number2Int(arr[3]);
            ans=3;
        }



        return ans;
        }
    }


