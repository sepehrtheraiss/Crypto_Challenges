import java.io.*;
import java.util.Scanner;
public class Q5 {
	public static void printHash(String s,String key)throws IOException 
	{
		byte b;
		int i=0,j=0;
		while(i<s.length())
		{
			b = (byte)s.charAt(i);
			if(j<key.length())
			{
				System.out.print(String.format("%02x",b^(key.charAt(j))));
				j++;
			}
			else
			{
				j=0;
				System.out.print(String.format("%02x",b^(key.charAt(j))));
				j++;
			}
			i++;
		}
		System.out.println();
	}
	public static void main(String[] args)throws IOException {
		final String key = "ICE";
		File infile = new File("/Users/sepehr/Desktop/ICE.txt");
		Scanner in = new Scanner(infile);
		StringBuffer buff = new StringBuffer();
		while(in.hasNextLine())
		{
			buff.append(in.nextLine()+'\n');
		}
		in.close();
		buff.deleteCharAt(buff.length()-1);
		printHash(buff.toString(),key);
	}

}
