//
//  main.cpp
//  EditStepLadders
//
//  Created by Russell Lowry on 11/7/17.
//  Copyright © 2017 Russell Lowry. All rights reserved.
//

#include <iostream>
#include <map>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    
    map<string, int> Ladder;

    int maxLen = 0;
    string w;
    while (cin >> w) {
        int length = 1;
        /*
         first we want to iterate through w.size
         and insert char y before w[x]
         */
        for (int x = 0; x <= w.size(); x++) {
            for (char y = 'a'; y <= 'z'; y++) {
                string w1(w);
                w1.insert(x, 1, y);
                if (w1 > w) {
                    break;
                }
                if (Ladder.count(w1)) {
                    length = max(length, Ladder[w1] + 1);
                }
            }
        }
        /*
         next we want to iterate through w.size again
         and delete the value at w[x]
         */
        for (int x = 0; x < w.size(); x++) {
            string w1(w);
            w1.erase(x, 1);
            if (Ladder.count(w1)) {
                length = max(length, Ladder[w1] + 1);
            }
        }
        /*
         lastly we want to iterate through w.size again
         and change the value at w[x]
         */
        for (int x = 0; x < w.size(); x++) {
            for (char y = 'a'; y <= 'z' && y != w[x]; y++) {
                string w1(w);
                w1[x] = y;
                if (w1 > w) {
                    break;
                }
                if (Ladder.count(w1)) {
                    length = max(length, Ladder[w1] + 1);
                }
            }
        }
        Ladder[w] = length;
        maxLen = max(maxLen, length);
    }
    /*
     print the number of words in the
     longest edit step ladder
     */
    cout << maxLen << endl;
}
