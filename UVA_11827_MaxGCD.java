import java.util.*;
import java.io.*;
public class UVA_11827_MaxGCD 
{
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
		String[] str;
		int[] X = new int[100];
		int N;
		int j, k;
		int i;
		int max;
		int r;
		S = in.readLine();
		N = Integer.parseInt(S);
		for(i=0; i<N; i++)
		{
			max = 0;
			S = in.readLine();
			str = S.split(" ");
			for(j=0; j<str.length; j++)
				X[j] = Integer.parseInt(str[j]);
			for(j=0; j<str.length; j++)
				for(k=j+1; k<str.length; k++)
				{
					r = gcd(X[j], X[k]);
					if(r > max)
						max = r;
				}
			out.println(max);
		}
		in.close();
		out.close();
	}

}
