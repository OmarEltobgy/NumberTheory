#include <stdio.h>
#include <string.h>
int depth;
char X[2000];

int calc2(int N)
{
  int result=0;
	if(N < 10)
	{
		if(N == 9)
			return depth;
		else 
			return -1;
	}
	while(N != 0)
	{
		result += N%10;
		N = N / 10;
	}
	depth++;
	calc2(result);
}

int calc(int length)
{
	if(length == 1)
	{
		if(X[0] == '9')
		{
			depth++;
			return depth;
		}
		else if(X[0] >= '0' && X[0] < '9')
			return -1;
		else
			return -2;
	}
	int result=0, flag = 0;
	for(int i=0; i<length; i++)
	{
		if(X[i]>='0' && X[i]<='9')
		{
			result += (X[i]-'0');
			flag = 1;
		}
	}
	if(flag == 0)
		return -2;
	depth++;
	return calc2(result);
}
int main()
{
	int N, L, i, r;
	scanf("%s",X);
	while(X[0] != '0')
	{
		L = strlen(X);
		depth = 0;
		r = calc(L);
		if(r == -1)
		{
			for(i=0; i<L; i++)
				if(X[i]>='0' && X[i]<='9')
					printf("%c",X[i]);
			printf(" is not a multiple of 9.\n");
		}
		else if(r != -2)
		{
			for(i=0; i<L; i++)
				if(X[i]>='0' && X[i]<='9')
					printf("%c",X[i]);
			printf(" is a multiple of 9 and has 9-degree %d.\n", r);
		}
		scanf("%s",X);
	}
	return 0;
}
