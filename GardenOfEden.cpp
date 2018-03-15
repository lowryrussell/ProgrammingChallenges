//
//  main.cpp
//  GardenOfEden
//
//  Created by Russell Lowry on 12/5/17.
//  Copyright © 2017 Russell Lowry. All rights reserved.
//

#include <iostream>
#include <stdio.h>

using namespace std;

int func[8];
int target[50], origin[50];
int ID, n, found;
char s[50];

void depthFirstSearch(int var) {
    
    if(found) {
        
        return;
    }
    int x, y;
    if(var == n-1) {
        
        x = (origin[n-2]<<2) | (origin[n-1]<<1) | (origin[0]<<0);
        y = (origin[n-1]<<2) | (origin[0]<<1) | (origin[1]<<0);
        if(target[var] == func[x] && target[0] == func[y]) {
            
            found = 1;
        }
        return;
    }
    for(int x = 0; x < 8; x++) {
        
        if(func[x] == target[var] && ((x>>2)&1) == origin[var-1] && ((x>>1)&1) == origin[var]) {
            
            origin[var+1] = (x>>0)&1;
            depthFirstSearch(var+1);
            if(found) {
                
                return;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    
    while(scanf("%d%d%s", &ID, &n, s) == 3) {
        
        for(int x = 0; x < n; x++) {
            
            target[x] = s[x]-'0';
        }
        for(int x = 0; x < 8; x++) {
            
            func[x] = (ID>>x)&1;
        }
        found = 0;
        for(int x = 0; x < 8; x++) {
            
            if(func[x] == target[0]) {
                
                origin[0] = (x>>1)&1;
                origin[1] = (x>>0)&1;
                depthFirstSearch(1);
            }
        }
        if(found) {
            
            cout << "REACHABLE" << endl;
        }
        else {
            
            cout << "GARDEN OF EDEN" << endl;
        }
    }
    return 0;
}
