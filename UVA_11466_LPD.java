import java.io.*;
import java.util.*;
public class UVA_11466_LPD
{
  public static void main(String[] args) throws IOException 
	{
		int i, j;
		int n = (int) Math.sqrt(Math.pow(10, 14));
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
		Scanner in2 = new Scanner(System.in);
		long X = in2.nextLong();
		while(X!=0)
		{
			long temp;
			int flag = 0;
			long LCD = 0;
			if(X<0)
				temp = -X;
			else
				temp = X;
			int counter=0;
			while(temp!=1)
			{
				if(temp % primes[counter] == 0)
				{
					if(primes[counter] > LCD)
					{
						LCD = primes[counter];
						flag++;;
					}
					temp /= primes[counter];
				}
				else if(counter+1 < counterp)
					counter++;
				else 
				{
					if(temp > LCD)
					{
						LCD = temp;
						flag++;;
					}
					break;
				}
			}
			if(flag>1)
				System.out.println(LCD);
			else
				System.out.println("-1");
			X = in2.nextLong();
		}
	}
}
