#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int answer =0;
    int number =0;
    vector<int> arr;
    
    cin >> number;
    
    for(int i=0; i<number; i++){
        int t =0;
        cin>> t;
        arr.push_back(t);
    }
    sort(arr.begin(), arr.end());
    
    for(int i=0; i<number; i++){
        answer += arr[i]*(number-i);
    }
    cout << answer;
}