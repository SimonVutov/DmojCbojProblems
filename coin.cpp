#include <iostream>
#include <map>
#include <vector>
#include <queue>

using namespace std;

int solve(int x) {
    if (x < 0) return INF;
    if (x == 0) return 0;
    if (ready[x]) return value[x]; int best = -1;
    for (auto c : coins) {
            best = min(best, solve(x-c)+1);
            }
    ready[x] = true; value[x] = best; return best;
}

int main() {
    int N = 100;
    bool ready[N]; int value[N];

    value[0] = 0;
    for (int x = 1; x <= N; x++) {
        value[x] = -1;
        for (auto c : coins) {
            if (x-c >= 0) {
                value[x] = min(value[x], value[x-c]+1);
            }
        }
    }

    cout << solve(100) << endl;
}
