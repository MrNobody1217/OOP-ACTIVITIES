import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileStatistics
{
   public static void main(String[] args)
   {
      Path path = Paths.get("Teststat.txt");
      
      try 
      {
         BasicFileAttributes attri = Files.readAttributes(path, BasicFileAttributes.class);
         System.out.println("The file name is : " + path.getFileName());
         System.out.println("The file is " + attri.size() + " bytes long.");
         System.out.println("The last time of modification was: \n" + attri.lastModifiedTime());
      }
      catch(NoSuchFileException e)
      {
         System.out.println("Sorry, but the file does not exist.");
      }
      catch(IOException e)
      {
         System.out.println("Error because of " + e);
      }
   } 
}