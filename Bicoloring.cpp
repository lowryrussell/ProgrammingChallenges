//
//  main.cpp
//  Bicoloring
//
//  Created by Russell Lowry on 10/31/17.
//  Copyright © 2017 Russell Lowry. All rights reserved.
//

#include <cstdio>
#include <vector>
#include <queue>
using namespace std;

typedef vector<int> intVector;

int main(int argc, const char * argv[]) {
    
    int vertex, edge, x = 0, y;
    vector<intVector> adjacencyList;
    
    while (static_cast<void>(scanf("%d", &vertex)), vertex) {
        
        adjacencyList.assign(vertex, intVector());
        scanf("%d", &edge);
        
        for (int i = 0; i < edge; i++) {
            
            scanf("%d %d", &x, &y);
            adjacencyList[x].push_back(y);
            adjacencyList[y].push_back(x);
        }
        
        queue<int> q;
        q.push(0);
        intVector color(vertex, 1e9);
        color[0] = 0;
        bool isBipartite = true;
        while (!q.empty()) {
            
            if (isBipartite) {
                
                int x = q.front();
                q.pop();
                
                int adjacencyListSize = (int) adjacencyList[x].size();
                
                for (int j = 0; j < adjacencyListSize; j++) {
                    
                    int v = adjacencyList[x][j];
                    if (color[v] == 1e9) {
                        
                        color[v] = 1 - color[x];
                        q.push(v);
                    } else if (color[v] == color[x]) {
                        
                        isBipartite = false;
                        break;
                    }
                }
            }
            else {
                
                break;
            }
        }
        
        if (isBipartite) {
            
            printf("BICOLORABLE.\n");
        }
        else {
            
            printf("NOT BICOLORABLE.\n");
        }
    }
    
    return 0;
}
