import java.io.*;
import java.util.*;
public class UVA_10299_Relatives 
{
  public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String S;
		long X;
		long result;
		S = in.readLine();
		X = Integer.parseInt(S);
		while(X!=0)
		{
			if(X==1)
			{
				out.println("0");
				S = in.readLine();
				X = Integer.parseInt(S);
				continue;
			}
			result = X;
			for(int i=2; i*i<=X; i++)
			{
				if(X%i == 0)
				{
					result *= (1-1/(double)i);
					while(X%i == 0)
						X = X/i;
				}
			}
			if(X>1)
				result *= (1-1/(double)X);
			out.println(result);
			S = in.readLine();
			X = Integer.parseInt(S);
		}
		in.close();
		out.close();
	}
}
