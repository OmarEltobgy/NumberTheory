import java.io.*;
import java.util.*;
public class UVA_11408_DePrimes
{
  public static void main(String[] args) throws IOException 
	{
		int i, j;
		int n = 5000000;
		int[] factorsSum = new int[n+1];
		int[] dePrimeCount = new int[n+1];
		int dePrimeCounter=0;
		
		factorsSum[0]=0;
		factorsSum[1]=0;
		for(i=2; i<=n; i++)
		{
			if(factorsSum[i] == 0)
			{
				factorsSum[i] = i;
				dePrimeCounter++;
				factorsSum[i] = i;
				for(j=i+i; j<=n; j+=i)
					factorsSum[j] += i;
			}
			else if(factorsSum[factorsSum[i]] == factorsSum[i])
				dePrimeCounter++;
			
			dePrimeCount[i] = dePrimeCounter;
		}
				
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String S = in.readLine();
		String[] S2;
		S2 = S.split(" ");
		int a = Integer.parseInt(S2[0]);
		int b;
		while(a!=0)
		{
			b = Integer.parseInt(S2[1]);
			int result = 0;
			if(dePrimeCount[a-1] == dePrimeCount[a])
				result = dePrimeCount[b] - dePrimeCount[a];
			else
				result = dePrimeCount[b] - dePrimeCount[a] + 1;
			System.out.println(result);
			S = in.readLine();
			S2 = S.split(" ");
			a = Integer.parseInt(S2[0]);
		}
		out.close();
	}
}
