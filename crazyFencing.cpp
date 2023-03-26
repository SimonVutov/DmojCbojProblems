#include <iostream>
using namespace std;
  
int main()
{
    int x;
    cin >> x;
    int ints[x + 1];
    double total = 0;

    for(int i = 0; i < x + 1; i++)
    {
        cin >> ints[i];
    }

    for(int i = 0; i < x; i++)
    {
        int y;
        cin >> y;

        total += y*((double)(ints[i] + ints[i + 1]) * 0.5);
    }

    cout << total;
}