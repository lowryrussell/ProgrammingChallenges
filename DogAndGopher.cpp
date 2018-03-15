//
//  main.cpp
//  DogAndGopher
//
//  Created by Russell Lowry on 11/27/17.
//  Copyright © 2017 Russell Lowry. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <math.h>
#include <sstream>
#include <iomanip>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int number;
    double gopherX, gopherY, dogX, dogY;
    
    while(scanf("%d%lf%lf%lf%lf", &number, &gopherX, &gopherY, &dogX, &dogY) == 5) {
        
        bool hasEscaped = false;
        double x1, y1, x2, y2;
        int x;
        
        for (x = 1; x <= number; x++) {
            
            scanf("%lf%lf", &x1, &y1);
            
            double sqrtValGopher = sqrt((gopherX-x1) * (gopherX-x1) + (gopherY-y1) * (gopherY-y1)) * 2;
            double sqrtValDog = sqrt((dogX-x1) * (dogX-x1) + (dogY-y1) * (dogY-y1));
            if (!hasEscaped && sqrtValGopher <= sqrtValDog) {
                
                hasEscaped = true;
                x2 = x1;
                y2 = y1;
            }
        }
        if (hasEscaped) {
            
            cout << "The gopher can escape through the hole at (" << setprecision(3) << fixed << x2 << "," << setprecision(3) << fixed << y2 << ").\n";
        }
        else {
            
            cout << "The gopher cannot escape.\n";
        }
    }
    return 0;
}
