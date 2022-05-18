#include <iostream>
using namespace std;
class cylinder
{
    double r, h;
public:
    cylinder(double rad, double hght)
    {
        r = rad;
        h = hght;
    }
    double vol()
    {
        // Calculate the volume of the cylinder
        return 3.1416*r*r*h;
    }
    void print()
    {
        /*Show the radius, the height and the volume of the cylinder - you should not calculate the volume here*/
        cout << "Radius " << r << endl;
        cout << "Height " << h << endl;
        cout << "Volume " << vol() << endl;
    }
};

int main()
{
    cylinder c_arr[7] = {{1,6},{5,2},{3,4},{2,5},{4,3},{5,1},{2,5}};

    double maxVolume = -99;
    for (int i = 0; i < 7; i++) {
        if (c_arr[i].vol() > maxVolume) {
            maxVolume = c_arr[i].vol();
        }
    }
    cout << "Max Volume " << maxVolume << endl;

    return 0;
}