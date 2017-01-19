import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
public class Q4 {
	public static void printXOR(byte[] b,FileWriter writer)throws IOException 
	{
		for(int i =0;i<127;i++)
		{
			for(int j=0;j<b.length;j++)
			{				
				char a = (char)((byte)(b[j]^i));
				if(Character.isAlphabetic(a) || Character.isSpaceChar(a))
				{
					writer.write(a);
				}
			}
			writer.write("\n");
		}
		writer.flush();

	}
	public static void main(String[] args)throws IOException {
		File infile = new File("/Users/sepehr/Desktop/4.txt");
		Scanner in = new Scanner(infile);
		File out = new File("/Users/sepehr/Desktop/output.txt");
		out.createNewFile();
		FileWriter writer = new FileWriter(out);
		while(in.hasNextLine())
		{
			byte[] b = new BigInteger(in.nextLine(),16).toByteArray();
			printXOR(b,writer);
		}
		in.close();
		writer.close();
	}
	public static String toString(byte[] b)
	{
		StringBuffer buff = new StringBuffer();
		for(int i =0;i<b.length-1;i++)
		{
			buff.append(b[i]);
		}
		return buff.toString();
	}
}
