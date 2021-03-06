#include <stdio.h>
#include <math.h>
#include <stdlib.h>

long long MOD = 1000000007;

long long** multiplyMatrix(long long** first, long long** second, int rowN1, int colN1, int colN2)
{
	long long** result;
	result = (long long**) malloc(rowN1*sizeof(long long*));
	for(int i=0; i<rowN1; i++)
	{
		result[i] = (long long*) malloc(colN2*sizeof(long long));
		for(int j=0; j<colN2; j++)
		{
			result[i][j] = 0;
		}
	}
	
	for(int i=0; i<rowN1; i++)
	{
		for(int j=0; j<colN2; j++)
		{
			for(int k=0; k<colN1; k++)
			{
				result[i][j] += (first[i][k]%MOD * second[k][j]%MOD)%MOD;
			}
		}	
	}
	
	return result;
}

long long** power(long long** base, long long pow, int rowN, int colN)
{
	long long** result;
	result = (long long**) malloc(rowN*sizeof(long long*));
	for(int i=0; i<rowN; i++)
	{
		result[i] = (long long*) malloc(colN*sizeof(long long));
		for(int j=0; j<colN; j++)
		{
			if(i == j)
			{
				result[i][j] = 1;
			}
			else
			{
				result[i][j] = 0;
			}
		}
	}
	
	while(pow != 0)
	{
		if(pow % 2 == 1)
		{
			result = multiplyMatrix(result, base, rowN, colN, colN);
		}
		base = multiplyMatrix(base, base, rowN, colN, colN);
		pow = pow / 2;
	}
	
	return result;
}

int main()
{
	long long N, **baseCase, **result, **matrix;
	matrix = (long long**) malloc(2*sizeof(long long*));
	matrix[0] = (long long*) malloc(2*sizeof(long long));
	matrix[1] = (long long*) malloc(2*sizeof(long long));
	
	matrix[0][0] = 0;   matrix[0][1] = 3;
	matrix[1][0] = 1;   matrix[1][1] = 2;
	
	baseCase = (long long**) malloc(2*sizeof(long long*));
	baseCase[0] = (long long*) malloc(1*sizeof(long long));
	baseCase[1] = (long long*) malloc(1*sizeof(long long));
	
	baseCase[0][0] = 1;
	baseCase[1][0] = 0;
	
	result = (long long**) malloc(2*sizeof(long long*));
	result[0] = (long long*) malloc(1*sizeof(long long));
	result[1] = (long long*) malloc(1*sizeof(long long));
	
	scanf("%lld",&N);
	
	matrix = power(matrix, N, 2, 2);
	
	result = multiplyMatrix(matrix, baseCase, 2, 2, 1);
	
	printf("%lld\n", result[0][0]);
}
