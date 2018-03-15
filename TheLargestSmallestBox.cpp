//
//  main.cpp
//  TheLargestSmallestBox
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

    double length, width;
    double max, min1 = 0, min2 = 0;
    
    while (scanf("%lf%lf", &length, &width) == 2) {
        
        max = ((width+length) - sqrt((width*width) - (width*length) + (length*length)))/6;
        min2 = fmin(width, length)/2+1e-8;
        
        cout << setprecision(3) << fixed << max << " " << min1 << " " << min2 << endl;
    }
    return 0;
}
