#include <iostream>
#include <algorithm>

using namespace std;
  
int main()
{
    int a;
    int b;
    cin >> a >> b;
    if (a == 0 && b == 0) {
        cout << "0 0 0" << endl;
        return 0;
    }
    int counter = 0;
    if (a == 0 || b == 0) {
        counter = 1000;
    }
    for (int i = 0; i <= a + 1; i++)
    {
        for (int j = 0; j <= a/max(1, i) + 1 + counter; j++)
        {
            for (int k = 0; k <= (a/max(1, i))/max(1, j) + 1 + counter; k++)
            {
                if (i*j*k == a && i*i+j*j+k*k == b) {
                    cout << i << " " << j << " " << k << endl;
                    return 0;
                }
            }
        }
    }


    cout << "-1" << endl;
    return 0;
}