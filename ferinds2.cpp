#include <iostream>
#include <map>
#include <vector>
#include <queue>

using namespace std;

int main() {
    vector<pair<int, int>> friends;
    int people; cin >> people;

    for (int i = 0; i < people; i++) {
        int person, mustBeFriendWith;
        cin >> person >> mustBeFriendWith;
        friends.push_back({person, mustBeFriendWith});
    }

    int searchPerson, searchFriend;
    cin >> searchPerson >> searchFriend;
    while (searchPerson != 0 && searchFriend != 0) {
        int startPerson = searchPerson;
        int seperation = 0;

        while (searchPerson != searchFriend) {
            int x = find(friends.begin(), freinds.end(), searchPerson);
            cout << x << endl;
        }

        int searchPerson, searchFriend;
        cin >> searchPerson >> searchFriend;
    }
}
