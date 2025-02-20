package com.example;

import java.util.*;

/*
 * chavvi calc calculator
 */
public class ChavviCalcExampleApp {

  public static float valueA = 0.000f;
  public static float valueB = 0.000f;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Character command = '_';

    // loop until user quits
    while (command != 'q') {
      printMenu();
      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);

      executeCommand(scan, command);
    }

    scan.close();
  }

  //
  // menu functions
  //
  private static void printMenuLine() {
    System.out.println(
        "----------------------------------------------------------");
  }

  private static void printMenuCommand(Character command, String desc) {
    System.out.printf("%s\t%s\n", command, desc);
  }

  // prints the menu
  public static void printMenu() {
    printMenuLine();
    System.out.println("ChavviCalc");
    printMenuLine();
    System.out.println("A = " + String.format("%.3f", valueA) + "     " + "B = " + String.format("%.3f", valueB));
    printMenuLine();
    printMenuCommand('a', "Enter a value for A");
    printMenuCommand('b', "Enter a value for B");
    printMenuCommand('+', "Add");
    printMenuCommand('-', "Subtract");
    printMenuCommand('*', "Multiply");
    printMenuCommand('/', "Divide");
    printMenuCommand('c', "Clear");
    printMenuCommand('q', "Quit");
    printMenuLine();
  }

  // get first character from input
  private static Character menuGetCommand(Scanner scan) {
    Character command = '_';

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      command = rawInput.charAt(0);
    }

    return command;
  }

  // calculator functions
  private static Boolean executeCommand(Scanner scan, Character command) {
    Boolean success = true;

    switch (command) {
      case 'a':
        System.out.println("Enter a number:");
        float inputA = scan.nextFloat();
        valueA = inputA;
        break;
      case 'b':
        System.out.println("Enter a number:");
        float inputB = scan.nextFloat();
        valueB = inputB;
        break;
      case '+':
        valueA = valueA + valueB;
        break;
      case '-':
        valueA = valueA - valueB;
        break;
      case '*':
        valueA = valueA * valueB;
        break;
      case '/':
        if (valueB == 0.000f) {
          System.out.println("Can't divide by 0");
          break;
        }
        valueA = valueA / valueB;
        break;
      case 'c':
        valueA = 0.000f;
        valueB = 0.000f;
        break;
      case 'q':
        System.out.println("Thank you for using Chavvi Calc");
        break;
      default:
        System.out.println("ERROR: Unknown commmand");
        success = false;
    }

    return success;
  }
}
