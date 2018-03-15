//
//  main.cpp
//  DistinctSubsequences
//
//  Created by Russell Lowry on 11/17/17.
//  Copyright © 2017 Russell Lowry. All rights reserved.
//

#include<cstdio>
#include<string.h>
#include <algorithm>

using namespace std;

void add(char str1[], char str2[], char res[]){
    
    int len1 = strlen(str1);
    int len2 = strlen(str2);
    
    int reslen = max(len1, len2) + 1;
    
    for(int i = 0; i < reslen; i++) {
        
        res[i]='0';
    }
    res[reslen]='\0';
    
    int i = len1 - 1;
    int j = len2 - 1;
    int k = reslen - 1;
    int carry = 0;
    int tmp = 0;
    
    for(i, j, k, tmp, carry; i >= 0 || j >= 0; k--){
        
        tmp = 0;
        
        if(i >= 0) {
            
            tmp+=str1[i--] - '0';
        }
        if(j >= 0) {
            
            tmp+=str2[j--] - '0';
        }
        
        tmp += carry;
        
        if(tmp>=10) {
            
            carry=1;
            tmp-=10;
        }
        else {
            carry = 0;
        }
        
        res[k] = tmp + '0';
    }
    
    res[0]='0'+carry;
    
    if(res[0]=='0') {
        
        for(int i=0;i<reslen;i++) {
            
            res[i]=res[i+1];
        }
    }
}

int main(int argc, const char * argv[]) {
    
    int n;
    scanf("%d",&n);
    
    while(n--){
        
        char S[10001],T[101];
        char DP[101][10000];
        scanf("%s%s", S, T);
        int len = strlen(T);
        for(int x = 1; x <= 100; x++) {
            
            DP[x][0]='0';
            DP[x][1]='\0';
        }
        
        DP[0][0]='1';
        DP[0][1]='\0';
        
        for(int x = 0; S[x] != '\0'; x++) {
            
            for(int y = len - 1; y >= 0; y--) {
                
                if(S[x] == T[y]) {
                    
                    char res[10000];
                    add(DP[y + 1], DP[y], res);
                    strcpy(DP[y + 1], res);
                }
            }
        }
        printf("%s\n",DP[len]);
    }
}
