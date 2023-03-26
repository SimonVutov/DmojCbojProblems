#include <iostream>
#include <map>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

int main() {

    int k;
    cin >> k;
    
    for (int i = 0; i < k; i++){
        int m;
        cin >> m;

        const stack<int> st;
        const stack<int> bn;

        for (int j = 0; j < m; j++){
            int n;
            cin >> n;
            st.push(n);
        }

        while(st.top() != 1){
            //bn.push(st.pop());
        }
        cout << "Done! \n";
    }
}
