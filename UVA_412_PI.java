import java.util.*;
import java.io.*;
public class UVA_412_PI 
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
		int[] X = new int[100];
		int N;
		int i, j, number, total;
		double result;
		S = in.readLine();
		N = Integer.parseInt(S);
		while(N != 0)
		{
			number = 0;
			total = 0;
			for(i=0; i<N; i++)
			{
				S = in.readLine();
				X[i] = Integer.parseInt(S);
			}
			for(i=0; i<N; i++)
				for(j=i+1; j<N; j++)
				{
					total ++;
					if(gcd(X[i], X[j]) == 1)
						number ++;
				}
			if(number != 0)
			{
				result = Math.sqrt((double)(6*total)/number);
				out.printf("%f\n", result);
			}
			else
				out.println("No estimate for this data set.");
			S = in.readLine();
			N = Integer.parseInt(S);
		}
		in.close();
		out.close();
	}

}
