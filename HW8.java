/*
 * Author: P.Miller
 * Filename: HW8.java
 * Specification: The program will print students average and final grade 
 * based on the scores from a file.  
 * The input file has different number of records which includes
 * names and 4 exam scores.
 * The lowest exam is dropped before computing the average.
 */
 import java.util.Scanner;
 import java.io.*;
public class HW8
{
  static Scanner in = new Scanner(System.in);
  public static void main (String[] args) throws IOException
  {
    String command = " ";
    System.out.print("Please enter the filename: ");
    String fileName = in.nextLine();
    GradeBook grades = new GradeBook(fileName);
    
    while (command.charAt(0) != 'q') {   
      System.out.println();
      System.out.print("Please enter a command or type \"?\" to see the menu: ");
      command = in.nextLine();
      
      switch (command.charAt(0)) {
        case 'a': // display all
            System.out.println(grades.toString());
            break;
            
        case 'b' : // search
            System.out.print("Type student name: ");
            String name = in.nextLine();
            int index = grades.getIndex(name);
            char grade = grades.getLetterGrade(index);
            if (index != -1)
                System.out.println(name + " " + grade);
            else
                System.out.println("Student doesn't exist!");
            break;
            
        case '?' : // help menu
            System.out.println("a: Display ");
            System.out.println("b: Search ");
            System.out.println("?: Help menu ");
            System.out.println("q: Stop the program ");
            break;
        case 'q': // stop the program
            break;
            
        default:
            System.out.println("Illegal cammand!!!");
        } // end of switch
    } // end of while
  }// end main
} // end Assignment8