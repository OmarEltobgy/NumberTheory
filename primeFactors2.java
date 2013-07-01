import java.io.*;
import java.util.*;
public class PrimeFactors 
{
  public static void main(String[] args) 
	{
		int i, j;
		int n = 20000000;
		int[] primeFactor = new int[n+1];
		for(i=0; i<=n-1; i++)
			primeFactor[i] = 0;
		primeFactor[0] = -1;
		primeFactor[1] = -1;
		
		primeFactor[2] = 2;
		for(i=2+2; i<=n-1; i+=2)
			primeFactor[i] = 2;
		
		for(i=3; i*i<=n-1; i+=2)
		{
			if(primeFactor[i] == 0)
			{
				primeFactor[i] = i;
				for(j=i*i; j<=n-1; j+=i)
					if(primeFactor[j] == 0)
						primeFactor[j] = i;
			}
		}
		
		for(j=i; j<=n-1; j+=2)
			if(primeFactor[j] == 0)
				primeFactor[j] = j;
	
		Scanner in = new Scanner(System.in);
		int X;
		X = in.nextInt();
		while(X!=0)
		{
			int temp;
			if(X<0)
			{
				temp = -X;
				System.out.print(X + " = " + "-1 x ");
			}
			else
			{
				temp = X;
				System.out.print(X + " = " );
			}
			
			while(primeFactor[temp] != -1)
			{
				System.out.print(primeFactor[temp]);
				temp /= primeFactor[temp];
				if(primeFactor[temp] != -1)
					System.out.print(" x ");
			}
			
			System.out.println();
			X = in.nextInt();
		}
		in.close();
	}
}
