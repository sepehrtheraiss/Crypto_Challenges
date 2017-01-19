import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
public class Q3 {

	public static void main(String[] args) throws IOException {
		File infile = new File("/Users/sepehr/Desktop/file.txt");
		Scanner in = new Scanner(infile);
		byte[] b = new BigInteger(in.nextLine(),16).toByteArray();
		in.close();
		File out = new File("/Users/sepehr/Desktop/output.txt");
		out.createNewFile();
		FileWriter writer = new FileWriter(out);
		for(int i =0;i<225;i++)
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
		writer.close();
	}

}
