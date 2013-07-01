import java.util.*;
public class UVA_10176_OceanDeep
{
  public static int calcMod(String S, int M)
	{
		int X = S.charAt(0) - '0';
		int result = X;
		for(int i=1; i<S.length()-1; i++)
		{
			X = S.charAt(i) - '0';
			result = (result*2 + X) % M;
		}
		return result;
	}
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String S;
		int R;
		while(in.hasNextLine())
		{
			S = in.nextLine();
			while(S.charAt(S.length()-1) != '#')
				S = S.concat(in.nextLine());
//			System.out.println(S);
			R = calcMod(S, 131071);
			if(R == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		in.close();
	}
}
