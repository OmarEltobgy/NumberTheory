#include <iostream>
#include <vector>
using namespace std;

typedef vector<long long> vi;
typedef vector<vi> vvi;

long long d, m, n;
vvi coeff;
vvi init;
vvi matrix;

void matrixPrint(vvi toPrint)
{
    for(int i=0; i<(int)toPrint.size(); i++)
    {
        for(int j=0; j<(int)toPrint[i].size(); j++)
        {
            cout << toPrint[i][j] << " ";
        }
        cout << endl;
    }
}

vvi marixtMultiply(vvi first, vvi second, long long mod)
{
    vvi result;
    if(first[0].size() != second.size())
    {
        // ERROR
        return result;
    }
    int x = first.size();
    int middle = first[0].size();
    int y = second[0].size();

    result.resize(x);
    for(int i=0; i<x; i++)
    {
        result[i].resize(y);
        for(int j=0; j<y; j++)
        {
            result[i][j] = 0;
            for(int k=0; k<middle; k++)
            {
                //cout << "..." << first[i][k] << " " << second[k][j] << endl;
                result[i][j] = (result[i][j]%mod + (first[i][k]%mod * second[k][j]%mod) % mod) % mod;
            }
        }
    }

    //matrixPrint(first);
    //matrixPrint(second);
    //matrixPrint(result);

    return result;
}

vvi matrixPower(vvi base, long long power, long long mod)
{
    if(power == 0)
    {
        vvi result;
        result.resize(base.size());
        for(int i=0; i<(int)result.size(); i++)
        {
            result[i].resize(result.size());
            for(int j=0; j<(int)result.size(); j++)
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
        return result;
    }

    vvi result = matrixPower(base, power/2, mod);
    result = marixtMultiply(result, result, mod);
    if(power % 2 != 0)
    {
        result = marixtMultiply(result, base, mod);
    }

    return result;
}

int main()
{
    cin >> d >> n >> m;
    long long inn, toPrint;
    while(d != 0 || n != 0 || m != 0)
    {
        coeff.clear();
        coeff.resize(d);
        for(int i=0; i<d; i++)
        {
            coeff[i].resize(1);
            cin >> inn;
            coeff[i][0] = inn%m;
        }

        init.clear();
        init.resize(d);
        for(int i=0; i<d; i++)
        {
            init[d-i-1].resize(1);
            cin >> inn;
            init[d-i-1][0] = inn%m;
        }

        if(n <= d)
        {
            toPrint = init[d-n][0] % m;
        }
        else
        {
            matrix.clear();
            matrix.resize(d);
            for(int i=0; i<d; i++)
            {
                matrix[i].resize(d);
                if(i == 0)
                {
                    for(int j=0; j<d; j++)
                    {
                        matrix[i][j] = coeff[j][0];
                    }
                }
                else
                {
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
            }

            vvi ress = matrixPower(matrix, n-d, m);
            ress = marixtMultiply(ress, init, m);

            toPrint = ress[0][0] % m;
        }

        cout << toPrint << endl;

        cin >> d >> n >> m;
    }
    return 0;
}
