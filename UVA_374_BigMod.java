import java.util.*;
public class UVA_374_BigMod
{
  public static int calc(int B, int P, int M)
	{
		int result;
		if(P==0)
			result = 1;
		else if(P%2 == 0)
			result = (int) (Math.pow(calc(B, P/2, M), 2) % M);
		else
			result = (int) (( B * Math.pow(calc(B, (P-1)/2, M), 2) ) % M);
		
		return result;
	}
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt())
		{
			int B = in.nextInt();
			int P = in.nextInt();
			int M = in.nextInt();
			System.out.println(calc(B%M, P, M));
		}
		in.close();
	}
}
