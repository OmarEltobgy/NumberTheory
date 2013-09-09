#include <stdio.h>
#include <math.h>

int main()
{
	int testN;
	double d, vv, vh, first, second, res;
	scanf("%d",&testN);
	for(int t=0; t<testN; t++)
	{
		scanf("%lf %lf %lf",&d,&vv,&vh);
		if((vh)-(vv) <= 1e-8 || vh <= 1e-8 || vv <= 1e-8)
		{
			printf("Case %d: can't determine\n", (t+1));
		}
		else
		{
			first = d / vh;
			second = d / sqrt((vh*vh)-(vv*vv));
			res = second - first;
			printf("Case %d: %.3lf\n", (t+1), res);
		}
	}
	return 0;
}
