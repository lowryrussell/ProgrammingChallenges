//
//  main.cpp
//  CuttingSticks
//
//  Created by Russell Lowry on 11/17/17.
//  Copyright © 2017 Russell Lowry. All rights reserved.
//

#include <iostream>
#include <cstring>
#include <climits>

using namespace std;

int cuts[1001][1001], cutWeight[1001], numOfCuts;
bool hasCut[1001][1001];

int minCuttingCost(int a, int b) {
    if (a + 1 == b) {
        
        return 0;
    }
    if (hasCut[a][b]) {
        
        return cuts[a][b];
    }
    
    int minCut = INT_MAX;
    for(int x = a + 1; x < b; x++) {
        
        minCut = min(minCut, minCuttingCost(a, x) + minCuttingCost(x, b) + cutWeight[b] - cutWeight[a]);
    }
    
    hasCut[a][b] = true;
    return cuts[a][b] = minCut;
}

int main(int argc, const char * argv[]) {
    
    int length;
    
    while(cin >> length, length) {
        
        cin >> numOfCuts;
        
        memset(cutWeight, 0, sizeof(cutWeight));
        memset(hasCut, 0, sizeof(hasCut));
        cutWeight[0] = 0;
        for(int x = 1; x <= numOfCuts; x++) {
            
            cin >> cutWeight[x];
        }
        cutWeight[numOfCuts + 1] = length;
        
        cout << "The minimum cutting is " << minCuttingCost(0, numOfCuts + 1) << "." << endl;
    }
    
    return 0;
}
