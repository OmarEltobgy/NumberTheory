#include <stdio.h>
#include <iostream>
using namespace std;

int main()
{
	int N, sum, f, first, last, n;
	scanf("%d",&N);
	while(N != -1)
	{
		n = 1;
		f = (double)N/n - n/2.0 + 1.0/2;
		while(f >= 1)
		{
			if(n*(2*f+n-1) == 2*N)
			{
				first = f;
				last = f+n-1;
			}
			n++;
			f = (double)N/n - n/2.0 + 1.0/2;
		}
		printf("%d = %d + ... + %d\n", N, first, last);
		scanf("%d",&N);
	}
	return 0;
}
