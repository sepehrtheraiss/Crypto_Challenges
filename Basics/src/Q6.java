import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
public class Q6 {

	public static void main(String[] args)throws IOException {
		String a ="this is a test";
		String b ="wokka wokka!!!";
		
		byte[] c = a.getBytes();
		byte[] d = b.getBytes();
		System.out.println(toString(diff(c,d)));
	}
	static int greater(byte[]a,byte[]b)
	{
		if(a.length>b.length)
			return a.length;
		else
			return b.length;
	}
	static byte[] diff(byte[]a,byte[] b)
	{
		int i=0;
		byte[] c = new byte[greater(a,b)];
		while(i<a.length && i< b.length)
		{
			c[i] = (byte) (b[i] & a[i]);
			i++;
		}
		return c;
	}
static String toString(byte [] b)
{
	StringBuffer buff = new StringBuffer();
	for(int i =0;i<b.length;i++)
	{
		buff.append(b[i]);
	}
	return buff.toString();
}
}
