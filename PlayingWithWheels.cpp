//
//  main.cpp
//  PlayingWithWheels
//
//  Created by Russell Lowry on 10/26/17.
//  Copyright © 2017 Russell Lowry. All rights reserved.
//

#include <cstdio>
#include <queue>
#include <cmath>
#include <cstring>

using namespace std;

int N, n, s, t, f[10000], F;
queue<int> queueVar;
int dist[10000];

int bfs() {
    
    memset(dist, -1, sizeof dist);
    queueVar = queue<int>();
    dist[s] = 0;
    queueVar.push(s);
    
    while (!(queueVar.size() == 0)) {
        
        int u = queueVar.front();
        queueVar.pop();
        int p = u;
        int v;
        for (int i = 0; i < 4; i++) {
            
            int d = (int)pow(10.0, (double)i);
            if (p % 10 == 0) v = u + (d * 9);
            else v = u - d;
            if (!f[v] && dist[v] == -1) {
                
                dist[v] = dist[u] + 1;
                if (v == t) return dist[v];
                queueVar.push(v);
            }
            if (p % 10 == 9) {
                
                v = u - (d * 9);
            }
            else {
                
                v = u + d;
            }
            if (!f[v] && dist[v] == -1) {
                
                dist[v] = dist[u] + 1;
                if (v == t) {
                    return dist[v];
                }
                queueVar.push(v);
            }
            p /= 10;
        }
    }
    return -1;
}

int main() {
    scanf("%d\n", &N);
    while (N--) {
        
        memset(f, 0, sizeof f);
        
        int res = 0, val;
        for (double i=0 ; i<=3 ; i++) {
            
            scanf("%d", &val);
            res += val*(int)pow(10.0, i);
        }
        s = res;
        
        res = 0;
        val = 0;
        for (double i=0 ; i<=3 ; i++) {
            
            scanf("%d", &val);
            res += val*(int)pow(10.0, i);
        }
        t = res;
        
        scanf("%d", &n);
        while (n--) {
            
            res = 0;
            val = 0;
            for (double i=0 ; i<=3 ; i++) {
                
                scanf("%d", &val);
                res += val*(int)pow(10.0, i);
            }
            F = res;
            f[F] = 1;
        }
        if (s == t) {
            printf("0\n");
            continue;
        }
        printf("%d\n", bfs());
    }
}
