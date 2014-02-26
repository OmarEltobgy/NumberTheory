#include <stdio.h>
#include <math.h>

long long MOD = 1000000007, A, B;
long long factorial[1000005] ,inverseFact[1000005];

bool checkGood(long long X)
{
	while(X != 0)
	{
		if(X%10!=A && X%10!=B)
		{
			return false;
		}
		X = X / 10;
	}
	return true;
}

long long inverse(long long X)
{
	long long power = MOD - 2;
	long long result = 1;
	while(power != 0)
	{
		if(power % 2 == 1)
		{
			result = (result%MOD * X%MOD) % MOD;
		}
		X = (X%MOD * X%MOD) % MOD;
		power = power / 2;
	}
	return result;
}

int main()
{
	factorial[0] = 1;
	for(long long i=1; i<=1000000; i++)
	{
		factorial[i] = (factorial[i-1]%MOD * i%MOD) % MOD;
	}
	
	long long N, totalNumber, number;
	scanf("%lld %lld %lld",&A,&B,&N);
	
	totalNumber = 0;
	for(long long i=0; i<=N; i++)
	{
		if(checkGood(i*A + (N-i)*B))
		{
			number = (factorial[N]%MOD * inverse(factorial[i])%MOD * inverse(factorial[N-i])%MOD) % MOD;
			totalNumber = (totalNumber%MOD + number%MOD) % MOD;
		}
	}
	printf("%lld\n", totalNumber);
}
