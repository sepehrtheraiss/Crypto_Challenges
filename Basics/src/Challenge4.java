import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
public class Challenge4 {
	public static void printXOR(byte[]b) throws IOException
	{
		
		File out = new File("/Users/sepehr/Desktop/output.txt");
		out.createNewFile();
		FileWriter writer = new FileWriter(out);
		byte[] b1 = new byte[b.length];
		StringBuffer[] buff = new StringBuffer[255];
		for(int i =0;i<255;i++)
		{
			buff[i] = new StringBuffer();
			for(int j=0;j<b1.length;j++)
			{
				b1[j] = (byte) (b[j] ^ i);
				buff[i].append((char)b1[j]);
			}
		}
		for(int i =0;i<buff.length;i++)
		{
				for(int j=0;j<buff[i].length();j++)
				{
					if(Character.isAlphabetic(buff[i].toString().charAt(j)) || Character.isSpaceChar(buff[i].toString().charAt(j)) )
					{
						//System.out.print(buff[i].toString().charAt(j));
						writer.write(buff[i].toString().charAt(j));
					}
				}
				writer.write("\n");
				writer.flush();
				System.out.println(" "+i);
		}
		writer.close();
	}
	public static void main(String[] args)
	{	
		// challenge 4
				Scanner in = null;
				int s_size=0;
				try
				{
					in =new Scanner(new File("/Users/sepehr/Desktop/4.txt"));
					while(in.hasNextLine())
					{
						in.nextLine();
						s_size++;
					}
					String[] str = new String[s_size];
					in = new Scanner(new File("/Users/sepehr/Desktop/4.txt"));
					int index=0;
					while(in.hasNextLine())
					{
						str[index]=in.nextLine();
						index++;
					}

					byte[][]b = new byte[s_size][];
					for(int i=0;i<s_size-1;i++)
					{
						b[i] = new byte[str[i].length()];
					}
					for(int i=0;i<s_size-1;i++)
					{
						for(int j=0;j<str[i].length()-1;j++)
						{
							System.out.println(str[i].length());
							b[i][j]=new BigInteger(str[j],16).byteValue();
						}
					}
					for(int i=0;i<s_size-1;i++)
					{
						printXOR(b[i]);
					}
					
				}
				catch(IOException e)
				{
					System.out.println(e);
				}
	}
}
