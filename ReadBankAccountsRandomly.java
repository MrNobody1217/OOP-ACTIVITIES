import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class ReadBankAccountsRandomly
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String userInput;

		Path filename = Paths.get("AccountRecords.txt");
		Path file = filename.toAbsolutePath();

		final String QUIT = "QUIT";

		final String ACCOUNT_NUMBER_FORMAT = "0000";
		final String NAME_FORMAT = "        ";
		final int NAME_LENGTH = NAME_FORMAT.length();
		final String BALANCE_FORMAT = "00000.00";
		final String delimiter = ",";

		String defaultRecord = ACCOUNT_NUMBER_FORMAT + delimiter + NAME_FORMAT + delimiter + BALANCE_FORMAT + System.getProperty("line.separator");
		final int RECORD_SIZE = defaultRecord.length();

		String acctString;
		int acct;
		byte[] data = defaultRecord.getBytes();
		String s;
      
      System.out.println("**** ReadBankAccoutnsRandomly***");
		System.out.print("Enter the number of the account to view >> ");
		userInput = input.nextLine();

		try
		{
			FileChannel fc = (FileChannel)Files.newByteChannel(file, READ);

			while(!(userInput.equals(QUIT)))
			{
				ByteBuffer buffer = ByteBuffer.wrap(data);
				acct = Integer.parseInt(userInput);

				fc.position(acct * RECORD_SIZE);
				fc.read(buffer);
				s = new String(data);

				prettyPrint(s.split(delimiter));

				System.out.print("Enter the number of the account to view or " + QUIT + " >> ");
				userInput = input.nextLine();
			}

			fc.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}

		input.close();
	}

	public static void prettyPrint(String[] c)
	{
		StringBuilder sb = new StringBuilder();

		for(String s : c)
			sb.append(s + " ");

		System.out.println(sb.toString());
	}
}
