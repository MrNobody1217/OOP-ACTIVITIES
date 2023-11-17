import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ValidataCheckDigits 
{
   public static void main(String[] args)
   {  
      
      try 
      {
         BufferedReader reader = new BufferedReader(new FileReader("listOfNumbers.txt"));
         
         String line;
         while((line = reader.readLine()) != null)
         {
            int sum = 0, lastDigit = 0;
            double solution;
            
            for(int a = 0; a <= 5; a++)
            {
               System.out.println(line.charAt(a));
               if(a < 5)
                  sum += line.charAt(a);
            }
            lastDigit = (line.charAt(5)) - '0';
            solution = sum % 10;
            
            System.out.println("Solution: " + solution);
            if(solution == (double)lastDigit)
            {
               addToValidFile(line);
               System.out.println("Valid account Number");
            }
            else
            {
               System.out.println("Invalid account Number");
            }
         }
         reader.close();
      }
      catch(IOException e)
      {
         System.out.println(e);
      }
   }
   
   private static void addToValidFile(String info)
   {
      try
      {
         BufferedWriter writer = new BufferedWriter(new FileWriter("ValidAccountNumber.txt", true));
         
         writer.write(info);
         writer.newLine();
         writer.close();
      }
      catch(IOException e)
      {
         System.out.println(e);
      }
   }
}