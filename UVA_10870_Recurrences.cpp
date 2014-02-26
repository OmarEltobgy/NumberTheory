#include <stdio.h>
#include <stdlib.h>
#include <math.h>

long long MOD;

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
				result[i][j] = (result[i][j]%MOD + (first[i][k]%MOD * second[k][j]%MOD)%MOD) % MOD;
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
	long long n, d;
	scanf("%lld %lld %lld",&d,&n,&MOD);
	
	while(d!=0 || n!=0 || MOD!=0)
	{
		long long **baseCase, **result, **matrix, **matrixPower, temp;
		matrix = (long long**) malloc(d*sizeof(long long*));
		baseCase = (long long**) malloc(d*sizeof(long long*));
		
		matrix[0] = (long long*) malloc(d*sizeof(long long));
		for(int i=0; i<d; i++)
		{
			scanf("%lld",&temp);
			matrix[0][i] = temp;
		}
		
		for(int i=1; i<d; i++)
		{	
			matrix[i] = (long long*) malloc(d*sizeof(long long));
			for(int j=0; j<d; j++)
			{
				if(j == i-1)
				{
					matrix[i][j] = 1;
				}
				else
				{
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<d; i++)
		{				
			scanf("%lld",&temp);
			baseCase[d-i-1] = (long long*) malloc(1*sizeof(long long));
			baseCase[d-i-1][0] = temp;
		}							
		
		matrixPower = power(matrix, n-1, d, d);	
		result = multiplyMatrix(matrixPower, baseCase, d, d, 1);
		
		printf("%lld\n", result[d-1][0]); 
		
		scanf("%lld %lld %lld",&d,&n,&MOD);
	}
}
