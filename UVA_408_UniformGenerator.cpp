#include <stdio.h>

long long gcd(long long a, long long b)
{
  if(b == 0)
		return a;
	else
		gcd(b, a%b);
}
int main()
{
	long long step, mod, temp, step1, mod1;
	while(scanf("%lld %lld",&step,&mod) != EOF)
	{
		/** FIRST SOLUTION BRUTE FORCE  **/
		/*long long start = 0, previous, now, next, count = 0;
		now = (start + step) % mod;
		count ++;
		while(now != start)
		{
			now = (now + step) % mod;
			count ++;
		}
		if(count == mod)
			printf("%10lld%10lld    Good Choice\n\n", step, mod);
		else
			printf("%10lld%10lld    Bad Choice\n\n", step, mod);*/
			
		/** SECOND SOLUTION GCD BY HAND  **/
		/*step1 = step;
		mod1 = mod;
		if(mod == 1)
			printf("%10lld%10lld    Good Choice\n\n", step1, mod1);
		else
		{
			if(step > mod)
				step = step % mod;		
			while(step != 0 && step != 1)
			{
				temp = step;
				step = mod % step;
				mod = temp;
			}
			if(step == 1)
				printf("%10lld%10lld    Good Choice\n\n", step1, mod1);
			else
				printf("%10lld%10lld    Bad Choice\n\n", step1, mod1);
		}*/
		/** THIRD SOLUTION GCD **/
		if(gcd(step, mod) == 1)
			printf("%10lld%10lld    Good Choice\n\n", step, mod);
		else
			printf("%10lld%10lld    Bad Choice\n\n", step, mod);
	}
	return 0;
}
