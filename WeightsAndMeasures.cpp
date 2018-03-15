//
//  main.cpp
//  WeightsAndMeasures
//
//  Created by Russell Lowry on 11/17/17.
//  Copyright © 2017 Russell Lowry. All rights reserved.
//

#include <iostream>
#include <vector>
#include <cstring>
#include <limits>
#include <algorithm>

using namespace std;

struct Turtle {
    int w, s;
};

bool comp(const Turtle &t1, const Turtle &t2) {
    
    return t1.s < t2.s;
}

vector<Turtle> TurtleVect;
int dp[5607];

int main(int argc, const char * argv[]) {
    
    Turtle t;
    
    while (cin >> t.w >> t.s) {
        
        TurtleVect.push_back(t);
    }
    
    sort(TurtleVect.begin(), TurtleVect.end(), comp);
    fill(dp, dp + 5607, numeric_limits<int>::max());
    dp[0] = 0;
    
    int maxNTurtles = 0;
    
    for (int x = 0; x < TurtleVect.size(); x++) {
        
        int w = TurtleVect[x].w;
        int s = TurtleVect[x].s;
        
        for (int y = maxNTurtles; y >= 0; y--) {
            
            if (s >= dp[y] + w && w + dp[y] < dp[y + 1]) {
                
                dp[y + 1] = dp[y] + w;
                maxNTurtles = max(maxNTurtles, y + 1);
            }
        }
    }
    
    cout << maxNTurtles << endl;
}
