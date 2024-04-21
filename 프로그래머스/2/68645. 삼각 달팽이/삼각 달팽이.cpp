#include <string>
#include <vector>
#include <iostream>
using namespace std;


vector<int> solution(int n) {
    vector<int> answer;
    int line=n;
    int arr[1001][1001] ={0,};
    int i=1, j=1, start=1, max=0;
    for(int i=1; i<=n; i++){ max +=i; }
    
    while(start<=max){

        for(int t=1; t<=n; t++){
            arr[i][j] = start; start++; i++;
        } n-=1; i-=1; j+=1;

        for(int t=1; t<=n; t++){
            arr[i][j] = start; start++; j++; 
        } n-=1; i-=1; j-=2;

        for(int t=1; t<=n; t++){
            arr[i][j] = start; start++; i--; j--; 
        } n-=1; j+=1; i+=2;

    }
    // for(int i=1; i<=6; i++){
    //     for(int j=1; j<=6; j++){
    //         cout << arr[i][j];
    //     }cout << endl;
    // }
    
    for(int i=1; i<=line; i++){
        for(int j=1; j<=i; j++){
            answer.push_back(arr[i][j]);
        }
    }
    
    return answer;
}