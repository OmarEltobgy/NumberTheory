#include <stdio.h>

int main()
{
	long long rowN, columnN, isWhite, totalN1, totalN2;
	scanf("%lld %lld %lld",&rowN,&columnN,&isWhite);
	while(rowN != 0 || columnN != 0 || isWhite != 0)
	{
		if(rowN < 8 || columnN < 8)
		{
			printf("0\n");
		}
		else
		{
			long long boardsN1 = columnN/2 - 3;
			long long boardsN2 = (columnN-1)/2 - 3;
			if(isWhite == 1)
			{
				totalN1 = boardsN1 * (rowN/2 - 3);
				totalN2 = boardsN2 * ((rowN-1)/2 - 3);
			}
			else
			{
				totalN1 = boardsN1 * ((rowN-1)/2 - 3);
				totalN2 = boardsN2 * ((rowN)/2 - 3);
			}
			printf("%lld\n", totalN1+totalN2);
		}
		scanf("%lld %lld %lld",&rowN,&columnN,&isWhite);
	}
}
