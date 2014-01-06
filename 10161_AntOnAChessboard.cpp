#include <stdio.h>
#include <math.h>

int main()
{
	long long time, x, y;
	scanf("%lld",&time);
	while(time != 0)
	{
		long long level = ceil(sqrt(time));
		long long numberInLevel = 1 + (level-1) * 2;
		long long firstInLevel = (level-1)*(level-1) + 1;
		long long currentIndex = time - firstInLevel;
		if(level % 2 != 0)
		{
			currentIndex = numberInLevel - currentIndex - 1;
		}
		if(currentIndex <=  numberInLevel / 2)
		{
			x = level;
			y = 1 + currentIndex;
		}
		else //(currentIndex >  numberInLevel / 2)
		{
			x = level - (currentIndex -  numberInLevel / 2);
			y = level;
		}
		printf("%lld %lld\n", y, x);
		scanf("%lld",&time);	
	}
}
