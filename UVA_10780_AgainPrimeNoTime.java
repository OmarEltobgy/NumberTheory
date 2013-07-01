import java.io.*;
import java.util.Scanner;
public class UVA_10780_AgainPrimeNoTime 
{
  public static void main(String[] args) 
	{
		int i, j;
		int[] primeFactor = new int[10001];
		
		for(i=0; i<=10000; i++)
			primeFactor[i] = 0;
		
		for(i=2; i*i<=10000; i++)
		{
			if(primeFactor[i] == 0)
			{
				primeFactor[i] = i;
				for(j=i*i; j<=10000; j+=i)
					if(primeFactor[j] == 0)
						primeFactor[j] = i;
			}
		}
		
		for(j=i; j<=10000; j++)
			if(primeFactor[j] == 0)
			{
				primeFactor[j] = j;
			}
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=0; t<T; t++)
		{
			int M = in.nextInt();
			int N = in.nextInt();
			int countN[] = new int[10001];
			int countM[] = new int[10001];
			int tempN = N;
			int tempM = M;
			int min = 99999999;
			if(M==1)
			{
				System.out.println("Case " + (t+1) + ":");
				System.out.println("Impossible to divide");
				continue;
			}
			for(int k=N; k>1; k--)
			{
				tempN = k;
				while(tempN != 1)
				{
					countN[primeFactor[tempN]] ++;
					tempN = tempN / primeFactor[tempN];
				}
			}

			while(tempM != 1)
			{
				countM[primeFactor[tempM]] ++;
				tempM = tempM / primeFactor[tempM];
			}
			
			for(i=2; i<=10000; i++)
			{
				if(countM[i] != 0)
					if(countN[i]/countM[i] < min)
						min = countN[i]/countM[i];
			}
			if(min>0)
			{
				System.out.println("Case " + (t+1) + ":");
				System.out.println(min);
			}
			else
			{
				System.out.println("Case " + (t+1) + ":");
				System.out.println("Impossible to divide");
			}
		}
	}
}
