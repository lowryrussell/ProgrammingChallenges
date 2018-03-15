//
//  main.cpp
//  TheKnightsOfTheRoundTable
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

    double x, y, z;
    while (scanf("%lf%lf%lf", &x, &y, &z) == 3) {
        
        double val = (x+y+z)/2;
        double sunlitArea = sqrt(val*(val-x)*(val-y)*(val-z));
        
        if (x == 0 || y == 0 || z == 0) {
            
            sunlitArea = 0;
            val = 1;
        }
        cout << "The radius of the round table is: " << setprecision(3) << fixed << (sunlitArea/val) << endl;
    }
    return 0;
}
