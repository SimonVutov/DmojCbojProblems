#include <iostream>
#include <vector>
using namespace std;

int lsb(int i) {
return i & -i;
}

int sum(vector<int>& fenwickTree, int i) {
int sum = 0;
while (i > 0) {
sum += fenwickTree[i - 1];
i = i - lsb(i);
}
return sum;
}

int main() {
int n, q;
cin >> n >> q;
vector<int> fenwickTree(n);
for (int i = 0; i < n; i++) {
cin >> fenwickTree[i];
}
vector<string> T(q);
vector<int> S(q);
vector<int> E(q);

for (int i = 0; i < q; i++) {
    cin >> T[i] >> S[i] >> E[i];
}

for (int i = 0; i < n; i++) {
    int j = i + lsb(i + 1);
    if (j < n) {
        fenwickTree[j] += fenwickTree[i];
    }
}

for (int i = 0; i < q; i++) {
    if (T[i] == "Q1") {
        cout << sum(fenwickTree, E[i]) - sum(fenwickTree, S[i] - 1) << endl;
    } else if (T[i] == "Q2") {
        cout << E[i] - S[i] << endl;
    } else if (T[i] == "U") {
        int j = S[i] - 1;
        int diff = E[i] - (sum(fenwickTree, j + 1) - sum(fenwickTree, j));
        while (j < fenwickTree.size()) {
            fenwickTree[j] += diff;
            j = j + lsb(j + 1);
        }
    }
}
return 0;
}