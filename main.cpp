#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

using namespace std;

int main() {
    int n;
    double x;
    cin >> n >> x;

    vector<double> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    double largestNum = 0;
    for (int i = 0; i < n; i++) {
        double currentSum = 0;
        int j = i;
        while (currentSum < x && j < n) {
            if (currentSum + arr[j] < x)
                currentSum += arr[j];
            j++;
        }
        largestNum = max(largestNum, currentSum);
    }

    if (largestNum == 0)
        cout << "-1" << endl;
    else
        cout << fixed << setprecision(0) << largestNum << endl;

    return 0;
}
