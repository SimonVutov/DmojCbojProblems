#include <utility>
#include <iostream>
#include <map>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    int people; cin >> people;
    vector<pair<int, int> > friends (people, std::make_pair(-1, -1));

    for(int i = 0; i < people; i++) {
        cout << friends[i].first << " " << friends[i].second << endl;
    }

    for (int i = 0; i < people; i++) {
        int person, mustBeFriendWith;
        cin >> person >> mustBeFriendWith;
        friends.push_back(make_pair(person, mustBeFriendWith));
    }

    int searchPerson, searchFriend;
    cin >> searchPerson >> searchFriend;
    while (searchPerson != 0 && searchFriend != 0) {
        int startPerson = searchPerson;
        int seperation = 0;

        while (searchPerson != searchFriend) {
            int x = find( friends.begin(), friends.end(), searchPerson );
            cout << x << endl;
        }

        int searchPerson, searchFriend;
        cin >> searchPerson >> searchFriend;
    }
}
