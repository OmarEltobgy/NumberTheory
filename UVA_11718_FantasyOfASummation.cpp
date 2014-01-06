#include <stdio.h>

long long expMod(long long N, long long K, long long MOD)
{
	if(K == 0)
	{
		return 1;
	}
	long long temp = expMod(N, K/2, MOD);
	long long toRet = (temp%MOD * temp%MOD)%MOD;
	if(K%2 != 0)
	{
		toRet = (toRet%MOD * N%MOD)%MOD;
	}
	return toRet;
}
int main()
{
	int TN, T;
	long long N, K, MOD;
	long long arr[1010], ans;
	scanf("%d",&TN);
	for(T=1; T<=TN; T++)
	{
		scanf("%lld %lld %lld",&N,&K,&MOD);
		ans = 0;
		for(int i=0; i<N; i++)
		{
			scanf("%lld",&arr[i]);
			ans = (ans%MOD + arr[i]%MOD)%MOD;
		}
		ans = (ans%MOD * K%MOD * expMod(N, K-1, MOD)%MOD)%MOD;
		printf("Case %d: %lld\n", T, ans);
	}
}
