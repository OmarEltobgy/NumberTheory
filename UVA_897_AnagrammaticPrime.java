import java.io.*;
import java.util.*;
public class UVA_897_AnagrammaticPrime
{
  static int n = 10000000;
	static int digitsN;
	static int[] isPrime = new int[n+1];
	static int[] isAnarg = new int[n+1];
	static char[] X = new char[10];
	static int[] isVisited = new int[10];
	static char[] result = new char[10];
	static int flag;
	public static void permute(int i)
	{
		int j;
		if(flag == 0)
			return;
		if(i==digitsN)
		{
			int R=0;
			for(j=0; j<digitsN; j++)
				R += ( (result[j]-'0') * Math.pow(10, digitsN-j-1) );
			
			if(isPrime[R] == 0)
			{
				flag = 0;
				return;
			}
		}
		else
		for(j=0; j<digitsN; j++)
			if(isVisited[j] == 0)
			{
				isVisited[j] = 1;
				result[i] = X[j];
				permute(i+1);
				isVisited[j] = 0;
			}
	}
	
	public static void test(int i)
	{
		char[] X1 = new char[10];
		int temp = i;
		int j=0;
		while(temp!=0)
		{
			X1[j] = (char) (temp%10 + '0');
			temp = temp/10;
			j++;
		}
		for(int k=0; k<j; k++)
			X[k] = X1[j-k-1];
		digitsN = j;
		flag = 1;
		permute(0);
		if(flag == 0)
			isAnarg[i]= 0;
	}
	
	public static void main(String[] args) throws IOException 
	{
		for(int i=0; i<=n; i++)
			isPrime[i] = 1;
			
		isPrime[0] = 0;
		isPrime[1] = 0;
		
		for(int i=2; i*i<=n; i++)
			if(isPrime[i] == 1)
			{
				isAnarg[i] = 1;
				for(int j=i*i; j<=n; j+=i)
					isPrime[j] = 0;
			}
		
		for(int i=2; i<=n; i++)
			if(isAnarg[i] == 1)
				test(i);
		
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		while(input!=0)
		{
			int temp = input;
			int count = 0;
			int flag = 0;
			while(temp!=0)
			{
				count++;
				temp /= 10;
			}
			if(input<1000)
				for(int i=input+1; i<Math.pow(10, count); i++)
				{
					if(isAnarg[i] == 1)
					{
						System.out.println(i);
						flag = 1;
						break;
					}
				}
			if(flag == 0)
				System.out.println(0);
			input = in.nextInt();
		}
	}
}
