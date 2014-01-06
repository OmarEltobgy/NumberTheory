#include <stdio.h>

int main()
{
	long long TN, T, N;
	long long max;
	scanf("%lld",&TN);
	for(T = 1; T<=TN; T++)
	{
		scanf("%lld",&N);
		max = (N*(N-1)) / 2;
		if(max % 2 == 0)
		{
			printf("Case %lld: %lld\n", T, max/2);	
		}
		else
		{
			printf("Case %lld: %lld/2\n", T, max);
		}
	}
}
