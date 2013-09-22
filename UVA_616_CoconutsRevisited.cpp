#include <stdio.h>
#include <math.h>
#include <iostream>
using namespace std;

int number;
bool test(int k)
{
	int temp = number;
	for(int i=0; i<k; i++)
	{
		if(temp < 0 || temp%k != 1)
		{
			return false;
		}
		temp = temp-1;
		temp = temp - temp/k;
		if(temp < 0)
		{
			return false;			
		}		
	}
	if(temp%k == 0)
	{
		return true;
	}
	return false;
}
int main()
{
	int k;
	scanf("%d",&number);
	while(number >= 0)
	{
		for(k=sqrt(number)+1; k>0; k--)
		{	
			if(test(k) == true)
			{
				break;
			}
		}
		if(k > 0)
		{
			printf("%d coconuts, %d people and 1 monkey\n", number, k);
		}
		else
		{
			printf("%d coconuts, no solution\n", number);
		}
		scanf("%d",&number);
	}
}
