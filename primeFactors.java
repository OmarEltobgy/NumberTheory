import java.io.*;
import java.util.*;
public class PrimeFactors2
{
  public static void main(String[] args) throws IOException 
	{
		int i, j;
		int n = (int) Math.sqrt(Math.pow(2, 31));
		boolean[] isPrime = new boolean[n+1];
		int[] primes = new int[n/2];
		int counterp=0;
		
		for(i=0; i<=n; i++)
			isPrime[i] = true;
		isPrime[0] = false;
		isPrime[1] = false;
		
		isPrime[2] = true;
		primes[counterp] = 2;
		counterp++;
		for(i=2+2; i<=n; i+=2)
			isPrime[i] = false;
		
		for(i=3; i*i<=n; i+=2)
		{
			if(isPrime[i] == true)
			{
				primes[counterp] = i;
				counterp++;
				for(j=i*i; j<=n; j+=i)
					isPrime[j] = false;
			}
		}
		
		for(j=i; j<=n; j+=2)
		{
			if(isPrime[j] == true)
			{
				primes[counterp] = j;
				counterp++;
			}
		}
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String S = in.readLine();
		int X = Integer.parseInt(S);
		while(X!=0)
		{
			int temp;
			if(X<0)
			{
				temp = -X;
				out.print(X + " = " + "-1 x ");
			}
			else
			{
				temp = X;
				out.print(X + " = " );
			}
			int counter=0;
			while(temp!=1)
			{
				if(temp % primes[counter] == 0)
				{
					out.print(primes[counter]);
					temp /= primes[counter];
					if(temp!=1)
						out.print(" x ");
				}
				else if(counter+1 < counterp)
					counter++;
				else 
				{
					out.print(temp);
					break;
				}
			}
			
			out.println();
			S = in.readLine();
			X = Integer.parseInt(S);
		}
		out.close();
	}
}
