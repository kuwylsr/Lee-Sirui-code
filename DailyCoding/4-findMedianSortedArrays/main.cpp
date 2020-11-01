#include <iostream>
#include <vector>
#include <cstdlib>
using namespace std;

class Solution {
	public:
		//个人解法，对两个有序向量进行归并
		double findMedianSortedArrays1(vector<int>& nums1, vector<int>& nums2){
			vector<int> result;
			int i = 0 , j = 0;
			while(i < nums1.size() || j < nums2.size()){
				//如果有某个向量被遍历完成
				if(i >= nums1.size()){
					result.insert(result.end(),nums2.begin()+j,nums2.end());
					break;
				}else if(j >= nums2.size()){
					result.insert(result.end(),nums1.begin()+i,nums1.end());
					break;
				}
				
				//没有向量被遍历完成
				if(nums1[i] < nums2[j]){
					result.push_back(nums1[i]);
					i++;
				}else{
					result.push_back(nums2[j]);
					j++;
				}
			}
			for(int r : result){
				cout << r << " ";
			}
			cout << endl;
			int len = result.size();
			double mid = 0.0;
			if(result.size()%2 == 0){
				mid = (result[len/2-1] + result[len/2])/2.0;
			}else{ 
				mid = result[len/2];
			}
			cout << "mid: " << mid << endl;
			return mid;
		}
		//官方题解，递归法
		double findMedianSortedArrays2(vector<int>& nums1, vector<int>& nums2){
			int m = nums1.size();
			int n = nums2.size();
			if(m > n){ // to ensure m <= n
				nums1.swap(nums2); //nums1与nums2做整体性交换
				int temp = m;
				m = n;
				n = temp;
			}
			// int i = rand()%(m); //随机初始化i为0~m-1
			// int j = (m+n+1)/2 - i;
			//循环搜索（采用二分查找的思想），直到满足最终条件
			int iMin = 0, iMax = m;
			int halfLen = (m+n+1)/2;
			while(iMin <= iMax){
				int i = (iMin + iMax) / 2;
				int j = halfLen - i;
				if(j>0 && i<m && nums2[j-1]>nums1[i]){ // i is too small
					iMin = i + 1;
				}else if(i>0 && j<n && nums1[i-1]>nums2[j]){// i is too big
					iMax = i - 1;
				}else{ // i is perfect
					int max_left_part; //左半部分的最大值
					if(i == 0){ // 此时j一定不为0
						max_left_part = nums2[j-1];
					}else if(j == 0){ // 此时i一定不为0
						max_left_part = nums1[i-1];
					}else{
						max_left_part = max(nums1[i-1], nums2[j-1]);
					}
					if((m+n)%2 == 1){ //如果一共有奇数个数,中位数直接为 max_left_part
						return max_left_part; //因为我们让左半部分多了一个 ,j = (m+n+1)/2,分子上的+1就是此目的。
					}

					int min_right_part; // 右半部分的最小值
					if(i == m){ // 此时j一定不为n
						min_right_part = nums2[j];
					}else if(j == n){ // 此时i一定不为m
						min_right_part = nums1[i];
					}else{
						min_right_part = min(nums1[i], nums2[j]);
					}

					return (max_left_part + min_right_part)/2.0;
				}
			}
			return 0.0; //无解
		}
};

int main(){

	vector<int> nums1 = {1,3};
	vector<int> nums2 = {2};
	Solution *s = new Solution();
	double result = s->findMedianSortedArrays2(nums1,nums2);
	printf("%f\n",result);
	return 0;
}