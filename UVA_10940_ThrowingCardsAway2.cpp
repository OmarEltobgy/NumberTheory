#include <stdio.h>

int main()
{
	int N, first, last, step, left;
	scanf("%d",&N);
	while(N != 0)
	{ 
		first = 1;
		last = N;
		step = 1;
		while(first != last)
		{
			left = (last-first+step)/step;
			first = first + step;
			if(left % 2 == 1)// odd number, remove the last
			{
				first = first - step*2;
				last = last - step;
			}
			step = step * 2;
		}	
		printf("%d\n", first);
		scanf("%d",&N);
	}
}
