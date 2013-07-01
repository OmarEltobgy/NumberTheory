import java.io.*;
import java.util.Scanner;

public class UVA_10484_DivisibilityOfFactors 
{
  public static void main(String[] args) 
	{
		int i, j;
		int[] primeFactor = new int[101];
		int[] primes = new int[101];
		int counterp=0;
		
		for(i=0; i<=100; i++)
			primeFactor[i] = 0;
		
		for(i=2; i*i<=100; i++)
		{
			if(primeFactor[i] == 0)
			{
				primes[counterp] = i;
				counterp++;
				primeFactor[i] = i;
				for(j=i*i; j<=100; j+=i)
					if(primeFactor[j] == 0)
						primeFactor[j] = i;
			}
		}
		
		for(j=i; j<=100; j++)
			if(primeFactor[j] == 0)
			{
				primeFactor[j] = j;
				primes[counterp] = j;
				counterp++;
			}
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long D = in.nextLong();
		while(N!=0 || D!=0)
		{
			int countN[] = new int[101];
			int countD[] = new int[101];
			int tempN = N;
			long tempD;
			long result = 1;
			int flag = 1;
			if(D>0)
				tempD = D;
			else
				tempD = -D;
			for(int k=N; k>1; k--)
			{
				tempN = k;
				while(tempN != 1)
				{
					countN[primeFactor[tempN]] ++;
					tempN = tempN / primeFactor[tempN];
				}
			}
			int counter=0;
			while(tempD!=1)
			{
				if(tempD % primes[counter] == 0)
				{
					countD[primes[counter]] ++;
					tempD = tempD / primes[counter];
				}
				else if(counter+1 < counterp)
					counter++;
				else 
				{
					flag = 0;
					break;
				}
			}
			for(i=0; i<100; i++)
			{
				if(countN[i] > countD[i])
					result *=  (countN[i] - countD[i] + 1);
				else if(countN[i] < countD[i])
				{
					flag = 0;
					break;
				}
			}
			if(flag==1)
				System.out.println(result);
			else if(flag==0)
				System.out.println(0);
			N = in.nextInt();
			D = in.nextInt();
		}
	}
}
