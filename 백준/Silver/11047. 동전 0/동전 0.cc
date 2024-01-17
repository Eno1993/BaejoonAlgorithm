#include <iostream>
using namespace std;

int main() {
	int n = 0, k = 0;
	int arr[10] = { 0, };
	cin >> n;
	cin >> k;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int index = n - 1, sum = 0;
	while (k > 0) {
		while (arr[index] > k) {
			index--;
		}
		while (arr[index] <= k) {
			k = k - arr[index];
			sum++;
		}
	}
	cout << sum;
}