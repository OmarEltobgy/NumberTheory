import java.util.*;
public class UVA_10127_Ones 
{
  public static int mod(String S, int N)
	{
		int X = S.charAt(0) - '0';
		int result = X;
		for(int i=1; i<S.length(); i++)
		{
			X = S.charAt(i) - '0';
			result = ( result * 10 + X ) % N;
		}
		return result;
	}
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int N;
		String S = "";
		while(in.hasNextInt())
		{
			S = "1";
			N = in.nextInt();
			while(mod(S, N) != 0)
				S += '1';
			System.out.println(S.length());
		}
		in.close();
	}
}
