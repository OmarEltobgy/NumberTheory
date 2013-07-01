import java.io.*;
import java.util.*;
public class PrimeNumbers 
{
  public static void main(String[] args) throws IOException 
	{
		int i, j;
		int twinPrimesCounter = 0;
		boolean[] isPrime = new boolean[20000001];
		int[][] twinPrimes = new int[100000][2];
		for(i=0; i<=20000000; i++)
			isPrime[i] = true;
		isPrime[0] = false;
		isPrime[1] = false;
		
		isPrime[2] = true;
		for(i=2+2; i<=20000000; i+=2)
			isPrime[i] = false;
		
		for(i=3; i*i<=20000000; i+=2)
		{
			if(isPrime[i] == true)
			{
				for(j=i*i; j<=20000000; j+=i)
					isPrime[j] = false;
				if(isPrime[i-2] == true)
				{
					twinPrimes[twinPrimesCounter][0] = i-2;
					twinPrimes[twinPrimesCounter][1] = i;
					twinPrimesCounter++;
				}
			}
		}
		
		for(j=i; j<=20000000; j+=2)
		{
			if(isPrime[j] == true && isPrime[j-2] == true)
			{
				twinPrimes[twinPrimesCounter][0] = j-2;
				twinPrimes[twinPrimesCounter][1] = j;
				twinPrimesCounter++;
				if(twinPrimesCounter >= 100000)
					break;
			}
		}
		
		String S;
		int X;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			S = in.readLine();
			if(S==null)
				break;
			X = Integer.parseInt(S);
			System.out.println("(" + twinPrimes[X-1][0] + ", " + twinPrimes[X-1][1] + ")");			
		}
	}
}
