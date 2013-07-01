import java.util.*;
import java.io.*;
public class UVA_10139_Factovisors_AC 
{
  public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		int i, j;
		int N, M;
		boolean[] X = new boolean[999999999];
		int n = (int) Math.sqrt(Math.pow(2, 31));
		int[] PrimeFactor = new int[n+1];
		int[] primes = new int[n];
		int counterp=0;
		for(i=0; i<n; i++)
			PrimeFactor[i] = -1;
		PrimeFactor[0] = 0;
		PrimeFactor[1] = 0;
		for(i=2; i*i<=n; i++)
			if(PrimeFactor[i] == -1)
			{
				PrimeFactor[i] = i;
				primes[counterp] = i;
				counterp++;
				for(j=i*i; j<=n; j+=i)
					if(PrimeFactor[j] == -1)
						PrimeFactor[j] = i;
			}
		for(j=i; j<=n; j++)
			if(PrimeFactor[j] == -1)
			{
				PrimeFactor[j] = j;
				primes[counterp] = j;
				counterp++;
			}
		while(in.hasNext())
		{
			N = in.nextInt();
			M = in.nextInt();
			int tempM = M;
			int tempN = N;
			int counter;
			if(M==0)
				System.out.println(M + " does not divide " + N + "!");
			else if(M<=N)
				System.out.println(M + " divides " + N + "!");
			else if(M<n && PrimeFactor[M] == M)
				System.out.println(M + " does not divide " + N + "!");
			else if(N==0 && M!=1)
				System.out.println(M + " does not divide " + N + "!");
			else
			{
				int flag=1;
				counter = 0;
				while(tempM!=1 && flag==1 && counter<counterp)
				{
					int p = primes[counter];
					if(tempM % p == 0)
					{
						int XM = 0;
						int XN = 0;
						while(tempM % p == 0)
						{
							XM++;
							tempM = tempM / p;
						}
						tempN = N;
						while(tempN > 0)
						{
							tempN = tempN / p;
							XN += tempN;
						}
						if(XN < XM)
							flag = 0;
					}
					counter++;
				}
				if(tempM > 1 && flag == 1)
				{
					int p = tempM;
					int XM = 1;
					int XN = 0;
					tempN = N;
					while(tempN > 0)
					{
						tempN = tempN / p;
						XN += tempN;
					}
					if(XN < XM)
						flag = 0;
				}
				if(flag == 0)
					System.out.println(M + " does not divide " + N + "!");
				else
					System.out.println(M + " divides " + N + "!");
			}
		}
		in.close();
	}
}
