import java.io.*;
import java.util.*;
public class UVA_10235_Emirp 
{
  public static void main(String[] args) throws IOException 
	{
		int i, j;
		boolean[] isPrime = new boolean[1000001];
		for(i=0; i<=1000000; i++)
			isPrime[i] = true;
		isPrime[0] = false;
		isPrime[1] = false;
		
		isPrime[2] = true;
		for(i=2+2; i<=1000000; i+=2)
			isPrime[i] = false;
		
		for(i=3; i*i<=1000000; i+=2)
		{
			if(isPrime[i] == true)
			{
				for(j=i*i; j<=1000000; j+=i)
					isPrime[j] = false;
			}
		}
		
		for(i=0; i<1000; i++)
			if(isPrime[i]==true)
				System.out.println(i);
	}
}
