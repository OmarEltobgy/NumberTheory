import java.io.*;
import java.util.*;
public class UVA_914_JumpingChampion
{
  public static void main(String[] args) throws IOException 
	{
		int i, j;
		int n = 1000000;
		boolean[] isPrime = new boolean[n+1];
		for(i=0; i<=n; i++)
			isPrime[i] = true;
		isPrime[0] = false;
		isPrime[1] = false;
		
		isPrime[2] = true;
		for(i=2+2; i<=n; i+=2)
			isPrime[i] = false;
		
		for(i=3; i*i<=n; i+=2)
			if(isPrime[i] == true)
				for(j=i*i; j<=n; j+=i)
					isPrime[j] = false;
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();	
		for(i=0; i<T; i++)
		{
			int X1 = in.nextInt();
			int X2 = in.nextInt();
			
			int[] jumpC = new int[1000];
//			int flag=0;
			int previous=0;
			int jumpChampValue=0;
			int  jumpChampRepetition=0;
			int jump;
			int k;
			int count = 0;
			int maxJump = 0;
			j=X1;
			while(isPrime[j] == false)
			{
				j++;
				count++;
			}
			previous = j;
			j++;
			while(j<=X2)
			{
				if(isPrime[j] == true)
				{
					jump = j - previous;
					previous = j;
					jumpC[jump] ++;
					if(jump > maxJump)
						maxJump = jump;
					count++;
				}
				j++;
			}
			
			int repititionFlag=0, CmpFlag=0;
			
			for(k=1; k<=maxJump+1; k++)
				if(jumpC[k] > jumpC[jumpChampValue])
					jumpChampValue = k;
			
			for(k=0; k<=maxJump+1; k++)
				if(jumpC[k] == jumpC[jumpChampValue] && k != jumpChampValue)
					repititionFlag = 1;
			
			if(repititionFlag == 1 && count < 2)
				System.out.println("No jumping champion");
			else
				System.out.println("The jumping champion is " + jumpChampValue);
		}
	}
}
