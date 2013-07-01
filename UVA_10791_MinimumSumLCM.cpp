#include <stdio.h>
#include <string.h>
#include <math.h>

int main()
{
  int n = sqrt(pow(2, 31)), i, j, t, primes[n], isPrime[n], counterp=0;
	long long N;
	//printf("YES\n");
	for(i=0; i<n; i++)
		isPrime[i] = 1;
	isPrime[0] = 0;
	isPrime[1] = 0;
	for(i=2; i*i<n; i++)
	{
		if(isPrime[i] == 1)//prime
		{
			primes[counterp] = i;
			counterp ++;
			for(j=i*i; j<n; j+=i)
				isPrime[j] = 0;
		}
	}
	for(j=i; j<n; j++)
	{
		if(isPrime[j] == 1)
		{
			primes[counterp] = j;
			counterp ++;
		}
	}
	//for(i=0; i<counterp; i++)
	//	printf("%d %d\n", i, primes[i]);
	t=0;
	scanf("%lld",&N);
	while(N != 0)
	{
		t++;
		long long temp = N, number = 0;
		long long sum = 0;
		i = 0;
		while(temp != 1)
		{
			int result = 1;
			while(temp % primes[i] == 0)
			{
				temp = temp / primes[i];
				result *= primes[i];
			}
			if(result != 1)
			{
				sum += result;
				number++;
			}
			i++;
			if(i >= counterp)
				break;
		}
		if(number == 0)
		{
			sum += temp;
			number ++;
		}
		if(number == 1)
		{
			sum += 1;
		}
		printf("Case %d: %lld\n", t, sum);
		scanf("%lld",&N);	
	}
	return 0;
}
