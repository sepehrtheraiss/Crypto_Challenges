import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Scanner;
import java.util.Stack;
public class hex_base64 {
	public static void main(String[] args)
	{		
		//Challenge 1
		String hex_str = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		byte[] b = new BigInteger(hex_str,16).toByteArray();
		String b_64 = Base64.getEncoder().encodeToString(b);
		System.out.println(b_64);
		
		// Challenge 2
		String s = "1c0111001f010100061a024b53535009181c";
		String s1 = "686974207468652062756c6c277320657965";
		b = new BigInteger(s,16).toByteArray();
		byte[] b1 = new BigInteger(s1,16).toByteArray();
		byte[] b2 = new byte[b1.length];
		for(int i =0;i<b.length;i++)
		{
			b2[i] = (byte) (b[i] ^ b1[i]);
			System.out.print(String.format("%02x", b2[i]));			
		}
		System.out.println();
		
		// Challenge 3
		String s3 = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
		byte[] b3 = new BigInteger(s3,16).toByteArray();
		byte[] b4 = new byte[b3.length];
		StringBuffer[] buff = new StringBuffer[127];
		for(int i =0;i<127;i++)
		{
			buff[i] = new StringBuffer();
			for(int j=0;j<b3.length;j++)
			{
				b4[j] = (byte) (b3[j] ^ i);
				buff[i].append((char)b4[j]);
			}
		}
		for(int i =0;i<buff.length;i++)
		{
				for(int j=0;j<buff[i].length();j++)
				{
					if(Character.isAlphabetic(buff[i].toString().charAt(j)) || Character.isSpaceChar(buff[i].toString().charAt(j)) )
					{
						System.out.print(buff[i].toString().charAt(j));
					}
				}
				System.out.println(" "+i);
		}
		
	}

}
