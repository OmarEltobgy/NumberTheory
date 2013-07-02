#include <stdio.h>

int gcd(int a, int b)
{
  if(b == 0)
		return a;
	else
		gcd(b, a%b);
}

int main()
{
	int N, M, lastTickets[20000], temp, i, j, sum, G;
	scanf("%d %d",&N,&M);
	while(N!=0 && M!=0)
	{
		sum = 0;
		for(i=0; i<N; i++)
		{
			for(j=0; j<M; j++)
			{
				scanf("%d",&temp);
				if(j == M-1)
				{
					lastTickets[i] = temp;
					sum += temp;
				}
			}
		}
		for(i=0; i<N; i++)
		{
			G = gcd(sum, lastTickets[i]);
			printf("%d / %d\n", lastTickets[i]/G, sum/G);
		}
		scanf("%d %d",&N,&M);	
	}
}
