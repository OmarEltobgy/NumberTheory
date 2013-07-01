import java.util.*;
public class UVA_11388_GCDLCM
{
  public static void main(String[] args) 
	{	
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for(int j=0; j<N; j++)
		{
			int GCD = in.nextInt();
			int LCM = in.nextInt();
			if(LCM % GCD == 0)
				System.out.println(GCD + " " + LCM);
			else
				System.out.println("-1");
		}
	}
}
