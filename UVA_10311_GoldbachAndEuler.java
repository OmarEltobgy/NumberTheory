import java.io.*;
import java.util.*;
public class UVA_10311_GoldbachAndEuler 
{
  public static void main(String[] args) throws IOException 
	{
		int i, j;
		int n = 100000000;
		boolean[] isPrime = new boolean[n+1];
		
		for(i=0; i<=n; i++)
			isPrime[i] = true;
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(i=2; i*i<=n; i++)
		{
			if(isPrime[i] == true)
			{
				for(j=i*i; j<=n; j+=i)
					isPrime[j] = false;
			}
		}
		
		Scanner in = new Scanner(System.in);
		for(i=0; i<100000; i++)
		{
			if(in.hasNextInt() == false)
				break;
			int X = in.nextInt();
			int first, second;
			int flag = 0;
			
			if(X%2 == 0)
			{
				first = X/2;
				second = X/2;
			}
			else
			{
				first = X/2;
				second = X/2 + 1;
				if(first > 2)
					if((first%2==0 && second%2!=0) || (first%2!=0 && second%2==0))
	                {
	                    if(isPrime[X-2] == false)
	                        System.out.printf("%d is not the sum of two primes!\n", X);
	                    else
	                    	System.out.printf("%d is the sum of %d and %d.\n", X, 2, X-2);
	                    continue;
	                }
			}
			while(first > 0 && second < X && flag == 0)
			{
				if(isPrime[first] == true && isPrime[second] == true && first!=second)
					flag = 1;
				else
				{
					first--;
					second++;
				}
			}
			if(flag == 1)
				System.out.println(X + " is the sum of " + first + " and " + second + ".");
			else
				System.out.println(X + " is not the sum of two primes!");
		}
	}
}
