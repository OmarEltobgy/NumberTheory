import java.util.*;
import java.io.*;
public class UVA_10892_LCMcardinality 
{
  public static int lcm(int a, int b)
	{
		return (a/gcd(a,b))*b;
	}
	public static int gcd(int a, int b)
	{
		if(b == 0)
			return a;
		else
			return gcd(b, a%b);
	}
	public static void main(String[] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String S;
		int N;
		int result;
		int[] factors = new int[100000];
		int size;
		S = in.readLine();
		N = Integer.parseInt(S);
		while(N!=0)
		{
			size = 0;
			result =0;
			for(int i=2; i*i<=N; i++)
				if(N%i == 0)
				{
					factors[size] = i;
					if(N/i != i)
					{
						size++;
						factors[size] = N/i;
					}
					size++;
				}
			for(int i=0; i<size; i++)
				for(int j=i+1; j<size; j++)
				{
					if(lcm(factors[i], factors[j]) == N)
						result ++;
				}
			if(N!=1)
				result += (size+2); //for the N and all its factors + 2 (for 1 & N)
			else
				result += (size+1);
			out.println(N + " " + result);
			S = in.readLine();
			N = Integer.parseInt(S);
		}
		in.close();
		out.close();
	}
}
