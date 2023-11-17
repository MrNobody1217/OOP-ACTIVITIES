import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class ReadBankAccountsSequentially
{
	public static void main(String[] args)
	{
		Path filename = Paths.get("AccountRecords.txt");
		Path file = filename.toAbsolutePath();

		final String delimiter = ",";

		try
		{
			InputStream inputFile = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile));

			String s = reader.readLine();

			while(s != null)
			{
            if(!s.trim().isEmpty()) 
            {
				   String[] array = s.split(delimiter);
               
				   if(!((array[1].trim()).isEmpty()))
					   System.out.println("Acct #" + array[0] + "\tAcct Holder: " + array[1]+ "\tBalance: $" + array[2]);
            }
            s = reader.readLine();
			}

			reader.close();
		}
      catch(ArrayIndexOutOfBoundsException e)
      {
         System.out.println(e);
      }
		catch(IOException e)
		{
		}
	}
}
