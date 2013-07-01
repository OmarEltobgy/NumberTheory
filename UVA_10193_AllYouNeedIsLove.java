import java.util.*;
public class UVA_10193_AllYouNeedIsLove 
{
  public static long gcd(long a, long b)
	{
		if(b == 0)
			return a;
		else
			return gcd(b, a%b);
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String S1;
		String S2;
		long X1;
		long X2;
		long result;
		String c = in.nextLine();
		for(int i=0; i<N; i++)
		{
			X1 = 0;
			X2 = 0;
			S1 = in.nextLine();
			S2 = in.nextLine();
			for(int j=0; j<S1.length(); j++)
				X1 += ( (S1.charAt(j)-'0') * Math.pow(2, S1.length()-1-j) );
			for(int j=0; j<S2.length(); j++)
				X2 += ( (S2.charAt(j)-'0') * Math.pow(2, S2.length()-1-j) );
			result = gcd(X1, X2);
			if(result == 1)
				System.out.println("Pair #" + (i+1) + ": Love is not all you need!");
			else
				System.out.println("Pair #" + (i+1) + ": All you need is love!");
		}
		in.close();
	}
}
