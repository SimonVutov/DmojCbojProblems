#include <iostream>
using namespace std;
  
int main()
{
    int x; cin >> x;
    int total = 0;
    for(int i = 0; i < x + 1; i++)
    if (i % 4 == 0 && (x-i) % 5 == 0)
    total ++;
    cout << total;
}