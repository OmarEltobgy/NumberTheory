#include <math.h>
#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

int GCD(int a, int b)
{
    if(b == 0) return a;
    return GCD(b, a%b);
}

int LCM(int a, int b)
{
    return a*(b/GCD(a,b));
}

int main()
{
    int N;
    long long counter;
    vector<int> allFactors;
    cin >> N;
    while(N != 0)
    {
        counter = 0;
        allFactors.clear();

        for(int i=1; i*i<=N; i++) // We begin from 1 till sqrt(N)
        {
            if(N % i == 0)
            {
                allFactors.push_back(i);
                if(N/i != i) // Very Important :D
                {
                    allFactors.push_back(N/i);
                }
            }
        }

        for(int i=0; i<allFactors.size(); i++)
        {
            for(int j=i+1; j<allFactors.size(); j++)
            {
                //cout << allFactors[i] << " " << allFactors[j] << " " << LCM(allFactors[i], allFactors[j]) << endl;
                if(LCM(allFactors[i], allFactors[j]) == N)
                {
                    counter ++;
                }
            }
        }

        counter ++;

        cout << N << " " << counter << endl;

        cin >> N;
    }

    return 0;
}
