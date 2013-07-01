import java.util.*;
public class UVA_10699_CountTheFactors 
{
  public static void main(String[] args) 
	{
		int n=1000000;
		int i, j;
		int[] primeFactor = new int[n+1];
		int counterp=0;
		
		for(i=2; i<=n; i++)
		{
			if(primeFactor[i] == 0)
			{
				primeFactor[i] ++;
				for(j=i+i; j<=n; j+=i)
					primeFactor[j]++;
			}
		}
		Scanner in = new Scanner(System.in);
		int X = in.nextInt();
		while(X!=0)
		{
			System.out.printf("%d : %d\n", X, primeFactor[X]);
			X = in.nextInt();
		}
	}
}
