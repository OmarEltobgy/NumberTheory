import java.io.*;
import java.util.*;
public class UVA_10852_LessPrime 
{
  public static void main(String[] args) throws IOException 
	{
		int i, j , NumberOfTestCases, counter;
		boolean[] isPrime = new boolean[10001];
		for(i=0; i<=10000; i++)
			isPrime[i] = true;
		isPrime[0] = false;
		isPrime[1] = false;
		
		isPrime[2] = true;
		for(i=2+2; i<=10000; i+=2)
			isPrime[i] = false;
		
		for(i=3; i*i<=10000; i+=2)
		{
			if(isPrime[i] == true)
			{
				for(j=i*i; j<=10000; j+=i)
					isPrime[j] = false;
			}
		}
		
		Scanner in = new Scanner(System.in);
		NumberOfTestCases = in.nextInt();
		int n;
		int xmax;
		int max;
		int x;
		float p;
		int result;
		for(counter = 0; counter < NumberOfTestCases; counter++)
		{
			n = in.nextInt();
			x=2;
			xmax = 2;
			max = 0;
			for(x=2; x<=n; x++)
			{
				if(isPrime[x] == true)
				{
					for(result=x-1; result>=0; result--)
					{
						p = (n-result)/(float)(x);
						if(p == (int)p)
							if(result > max)
							{
								xmax = x;
								max = result;
								break;
							}
					}
//					p=n/x;
//					while(n < (p+1)*x)
//					{
//						if(p*x <= n)
//							if(n-p*x > max)
//							{
//								max = n-p*x;
//								xmax = x;
//							}
//						p++;
//					}
				}
			}
			System.out.println(xmax);
		}
	}
}
