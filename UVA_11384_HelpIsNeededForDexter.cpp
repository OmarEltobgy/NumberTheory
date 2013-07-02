#include <stdio.h>
#include <math.h>

int main()
{
  long long N;
	while(scanf("%lld",&N) != EOF)
	{
		printf("%lld\n",(long long)log2(N) + 1);
	}
	return 0;
}
