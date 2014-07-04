#include <iostream>
#include <vector>
#include <map>
#include <math.h>
using namespace std;

vector<int> primes;
bool isPrime[1000];
void sieve(int maxN)
{
    int i, j;
    for(int i=0; i<=maxN; i++)
    {
        isPrime[i] = true;
    }
    isPrime[0] = false;
    isPrime[1] = false;
    for(i=2; i*i<=maxN; i++)
    {
        if(isPrime[i] == true)
        {
            primes.push_back(i);
            //cout << i << endl;
            for(j=i*i; j<=maxN; j+=i)
            {
                isPrime[j] = false;
            }
        }
    }
    for(i=i; i<=maxN; i++)
    {
        if(isPrime[i] == true)
        {
            primes.push_back(i);
            //cout << i << endl;
        }
    }
}

int main()
{
    int N, D, tempD, tempN, counter;
    vector<int> primeFactors_D;
    map<int, int> primeFactorsPower_D;
    vector<int> primeFactors_N;
    map<int, int> primeFactorsPower_N;

    sieve(1000);

    cin >> N >> D;
    while(N != 0 || D != 0)
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

        // Factorizing N!
        primeFactors_N.clear();
        primeFactorsPower_N.clear();
        for(int pi=0; pi<primes.size(); pi++)
        {
            int nowPower = 1;
            int toAdd = tempN / pow(primes[pi], nowPower);
            if(toAdd == 0)
            {
                break;
            }
            if(toAdd != 0)
            {
                primeFactors_N.push_back(primes[pi]);
                primeFactorsPower_N[primes[pi]] = 0;
                while(toAdd != 0)
                {
                    //cout << toAdd << endl;
                    primeFactorsPower_N[primes[pi]] += toAdd;
                    nowPower ++;
                    toAdd = tempN / pow(primes[pi], nowPower);
                }
                //cout << primes[pi] << " " << primeFactorsPower_N[primes[pi]] << endl;
            }
        }

        long long result = 1;
        // Checking that all the D Prime Factors are found in N! Prime Factors
        for(int i=0; i<primeFactors_D.size(); i++)
        {
            int nowPrimeNumber = primeFactors_D[i];
            if(primeFactorsPower_N[nowPrimeNumber] < primeFactorsPower_D[nowPrimeNumber])
            {
                result = 0;
            }
        }

        // Calculating the Result
        for(int i=0; i<primeFactors_N.size(); i++)
        {
            if(primeFactorsPower_D.count(primeFactors_N[i]) != 0)
            {
                result *= (primeFactorsPower_N[primeFactors_N[i]] + 1) - primeFactorsPower_D[primeFactors_N[i]];
            }
            else
            {
                result *= (primeFactorsPower_N[primeFactors_N[i]] + 1) - 0;
            }
        }

        cout << result << endl;

        cin >> N >> D;
    }

    return 0;
}
