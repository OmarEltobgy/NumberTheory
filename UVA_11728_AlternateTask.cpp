#include <stdio.h>

int main()
{
  int i, j, sumOfFactors[1000], N, found, test;
	sumOfFactors[0] = -1;
	for(i=1; i<1000; i++)
		sumOfFactors[i] = 0;
	for(i=1; i<1000; i++)
	{
		for(j=i; j<1000; j+=i)
		{
			sumOfFactors[j] += i;
		}
	}
	for(i=0; i<50; i++)
		printf("%d %d\n", i, sumOfFactors[i]);
	test = 0;
	scanf("%d",&N);
	while(N != 0)
	{
		test++;
		found = 0;
		for(i=999; i>0 && found==0; i--)
		{
			if(sumOfFactors[i] == N)
			{
				printf("Case %d: %d\n", test, i);
				found = 1;
			}	
		}
		if(found == 0)
			printf("Case %d: -1\n", test);
		
		scanf("%d",&N);	
	}
	return 0;
}
