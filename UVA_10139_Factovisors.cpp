#include <iostream>
#include <vector>
#include <map>
#include <stdio.h>
#include <math.h>
using namespace std;

int main()
{
    int N, D, tempD, tempN, counter;
    vector<int> primeFactors_D;
    map<int, int> primeFactorsPower_D;

    while(scanf("%d %d",&N,&D) != EOF)
    {
        tempD = D;
        tempN = N;

        // Factorizing D
        primeFactors_D.clear();
        primeFactorsPower_D.clear();
        for(int i=2; i*i<=D; i++)
        {
            if(tempD%i == 0)
            {
                primeFactors_D.push_back(i);
                primeFactorsPower_D[i] = 0;
                while(tempD % i == 0)
                {
                    tempD = tempD / i;
                    primeFactorsPower_D[i] ++;
                }
                //cout << i << " " << primeFactorsPower_D[i] << endl;
            }
        }
        if(tempD != 1)
        {
            primeFactors_D.push_back(tempD);
            primeFactorsPower_D[tempD] = 1;
            //cout << tempD << " " << primeFactorsPower_D[tempD] << endl;
        }

        // Checking that all the D Prime Factors are found in N!
        bool flag = true;
        for(int i=0; i<primeFactors_D.size() && flag; i++)
        {
            int nowPower = 1;
            int toAdd = tempN / pow(primeFactors_D[i], nowPower);
            int counter = 0;
            while(toAdd != 0)
            {
                //cout << toAdd << endl;
                counter += toAdd;
                nowPower ++;
                toAdd = tempN / pow(primeFactors_D[i], nowPower);
            }
            if(counter < primeFactorsPower_D[primeFactors_D[i]])
            {
                flag = false;
            }
            //cout << primes[pi] << " " << primeFactorsPower_N[primes[pi]] << endl;
        }

        if(flag == true)
        {
            printf("%d divides %d!\n", D, N);
        }
        else
        {
            printf("%d does not divide %d!\n", D, N);
        }
    }

    return 0;
}
