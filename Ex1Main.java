package assignments.ex1;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
                String quit = "quit";

                while (true) {
                    String num1 = "", num2 = "", num3 = "";
                    int N3 = 0;

                    System.out.println();
                    System.out.println("Ex1 class solution:");
                    System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
                    num1 = sc.nextLine();

                    if (num1.equals(quit)) {
                        System.out.println("Quitting now...");
                        break; // Exit the program if user types "quit"
                    }

                    if (!Ex1.isNumber(num1)) {
                        System.out.println("ERR: num1 is the wrong format! (" + num1 + ")");
                        continue; // Restart the loop if num1 is invalid
                    } else {
                        System.out.println("num 1= " + num1 + " is a valid number: " + Ex1.isNumber(num1));
                        System.out.println("Value: " + Ex1.number2Int(num1));
                    }


                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.nextLine();

                    if (num2.equals(quit)) {
                        System.out.println("Quitting now...");
                        break; // Exit the program if user types "quit"
                    }

                    if (!Ex1.isNumber(num2)) {
                        System.out.println("ERR: num2 is the wrong format! (" + num2 + ")");
                        continue; // Restart the loop if num2 is invalid
                    } else {
                        System.out.println("num 2= " + num2 + " is a valid number: " + Ex1.isNumber(num2));
                        System.out.println("Value: " + Ex1.number2Int(num2));
                    }


                    System.out.println("Enter a base for output: (a number [2,16])");
                    num3 = sc.nextLine();

                    //The code attempts to convert the input `num3` to a number, checks if it is in the range between 2 and 16,
                        // and if unsuccessful or if the value is out of range, prints an error message and returns the loop to the beginning.
                    try {
                        N3 = Integer.parseInt(num3);
                        if (N3 < 2 || N3 > 16) {
                            System.out.println("ERROR: Invalid base. Base should be between 2 and 16.");
                            continue; // Restart the loop if base is invalid
                        }
                    }

                   catch (NumberFormatException e) {
                        System.out.println("ERROR: Invalid input for base.");
                        continue; // Restart the loop if base is invalid
                    }


                    int N2IN1 = Ex1.number2Int(num1);
                    int N2IN2 = Ex1.number2Int(num2);
                    int SN2IN12 = N2IN1 + N2IN2;
                    int CN2IN12 = N2IN1 * N2IN2;

                    String I2NS12 = Ex1.int2Number(SN2IN12, N3);
                    String I2NC12 = Ex1.int2Number(CN2IN12, N3);


                    System.out.println(num1 + " + " + num2 + " = " + I2NS12);
                    System.out.println(num1 + " * " + num2 + " = " + I2NC12);


                    String[] arr = {num1, num2, I2NS12, I2NC12};
                    int MIndex1 = Ex1.maxIndex(arr);

                    System.out.printf(" Max number over [" + num1 + "," + num2 + "," + I2NS12 + "," + I2NC12 + "]  is:" + arr[MIndex1]);}

                sc.close(); // Close scanner after the program ends
            }
        }




/*public class Ex1Main {
    public static void main(String[] args) {

        String num1 = "", num2 = "", num3 = "", quit = "quit";
        int N3 = 0, MIndex1 = 0;

        Scanner sc = new Scanner(System.in);

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.nextLine();

            if (!num1.equals("quit")) {
                if (!Ex1.isNumber(num1)) {
                    System.out.print("num 1= " + num1 + "  is number:");
                    System.out.println(Ex1.isNumber(num1));
                    System.out.printf("ERR: num1 is the wrong fornat!  (" + num1 + ")");
                    continue;
                } else {
                    System.out.print("num 1= " + num1 + "  is number:");
                    System.out.print(Ex1.isNumber(num1));
                    System.out.print(", value:");
                    System.out.println(Ex1.number2Int(num1));
                }
            } else {
                continue;
            }

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.nextLine();

            if (!num2.equals("quit")) {
                if (!Ex1.isNumber(num2)) {
                    System.out.print("num 2= " + num2 + "  is number:");
                    System.out.print(Ex1.isNumber(num2));
                    System.out.print(", value:");
                    System.out.println(Ex1.number2Int(num2));
                    System.out.printf("ERR: num2 is the wrong fornat!  (" + num2 + ")");
                    continue;
                } else {
                    System.out.print("num 2= " + num2 + "  is number:");
                    System.out.print(Ex1.isNumber(num2));
                    System.out.print(", value:");
                    System.out.println(Ex1.number2Int(num2));
                }
            } else {
                continue;
            }

            System.out.println("Enter a base for output: (a number [2,16] ");
            num3 = sc.next();


            N3 = Integer.parseInt(num3);
            int N2IN1 = 0, N2IN2 = 0;
            int SN2IN12 = 0, CN2IN12 = 0;
            String I2NS12 = "0", I2NC12 = "0";


            N2IN1 = Ex1.number2Int(num1);
            N2IN2 = Ex1.number2Int(num2);
            SN2IN12 = N2IN1 + N2IN2;
            CN2IN12 = N2IN1 * N2IN2;

            I2NS12 = Ex1.int2Number(SN2IN12, N3);
            I2NC12 = Ex1.int2Number(CN2IN12, N3);

            System.out.println(num1 + "+" + num2 + "=" + I2NS12);
            System.out.println(num1 + "*" + num2 + "=" + I2NC12);

            String[] arr = new String[4];
            arr[0] = num1;
            arr[1] = num2;
            arr[2] = I2NS12;
            arr[3] = I2NC12;

            MIndex1 = Ex1.maxIndex(arr);
            System.out.printf(" Max number over [" + num1 + "," + num2 + "," + I2NS12 + "," + I2NC12 + "]  is:" + arr[MIndex1]);}
            System.out.println();
            System.out.printf("quitting now...");
        }

    }
*/




