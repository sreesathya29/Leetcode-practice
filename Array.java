//Array problems - 
//Two sum - problem no -1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            else{
                map.put(target - nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
//Container with most water problem no- 11
class Solution {
    public int maxArea(int[] height) {
        int maxarea =0;
        int left =0;
        int right = height.length-1;
        while(left<right){
            int widith = right-left;
            int h = Math.min(height[left],height[right]);
            maxarea = Math.max(maxarea,h*widith);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxarea;
    }
}
//Longest common prefix - problem no-14
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)return "";

        String pref = strs[0];
        int prefLen = pref.length();

        for(int i=1; i< strs.length; i++){
            String s = strs[i];
            while (prefLen > s.length() || !pref.equals(s.substring(0, prefLen))){
                prefLen--;
                if (prefLen == 0) {
                    return "";
                }
                pref =pref.substring(0, prefLen);
            }
        } 

        return pref;
    }
}
//3sum - problem no- 15
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
       List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i <nums.length; i++){
            int j = i+1;
            int k = nums.length -1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if (sum < target){
                    j++;
                }else {
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;
    }
}
//Search in rotated sorted array - problem no- 33
class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
//search insert position - problem no -35
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left =0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            }else if ( nums[mid] > target) {
                right = mid - 1;
            } else{
                left = mid +1;
            }
        }
        return left;
    }
}
//Plus one - problem no -66
class Solution {
    public int[] plusOne(int[] digits) {
       for(int i =digits.length-1; i >= 0;i--){
        if(digits[i]+1 != 10){
            digits[i] += 1;
            return digits;
        }
        digits[i] =0;
       } 
       int [] newDigits = new int[digits.length +1];
       newDigits [0] =1;
       return newDigits;
    }
}
//convert sorted array to binary search -problem no - 108
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       if(nums==null || nums.length==0){
        return null;
       } 
       return constructBST(nums,0,nums.length-1);
    }
    private TreeNode constructBST(int[] nums,int left,int right){
        if(left >right){
            return null;
        }
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBST(nums,left,mid-1);
        root.right = constructBST(nums,mid+1,right);
        return root;
    }
}
//Single number - problem no -136
class Solution {
    public int singleNumber(int[] nums) {
        int s = 0;
        for(int i=0; i<nums.length; i++) {
            s = s^nums[i];
        }
        return s;
    }
}
//Two sum II input array is sorted - problem no - 136
class Solution {
    public int[] twoSum(int[] num, int target) {
       int left=0;
       int right =num.length-1;
       while(left<right){
        int total = num[left]+num[right];
        if(total== target){
            return new int[]{left+1,right+1};
           } else if(total>target) {
                right--;
            }else{
                 left++;
            }
       }
       return new int[]{-1,-1};
    }
}
// Majority element - problem no- 169
class Solution {
    public int majorityElement(int[] nums) {
       int target = nums.length/2;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<nums.length;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       for(int key:map.keySet()){
        if(map.get(key)>target){
            return key;
        }
       }
       return -1;
    }
}
//count primes problem no -204
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isNotPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                count++;
                if ((long)i * i < n) { 
                    for (int j = i * i; j < n; j += i) {
                        isNotPrime[j] = true;
                    }
                }
            }
        }
        return count;
    }
}
//Minimum size subarray sum - problem no -209
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int min_window = Integer.MAX_VALUE;
        int window_sum =0;
        for(int right =0; right<nums.length;right++){
            window_sum +=nums[right];
            while(window_sum >= target){
               min_window = Math.min(min_window, right-left+1);
               window_sum -= nums[left];
               left++; 
            }
        }
        return(min_window == Integer.MAX_VALUE) ? 0 : min_window;
    }
}
//Product of array except self - problem no -238
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = 1;
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] *= left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;        
    }
}
//Search a 2D matrix II - problem no -240
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length-1;
        int r=0;
        while(r<row && col>=0){
            if(target>matrix[r][col]){
                r++;
            }else{
                if(target<matrix[r][col]){
                    col--;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
//Range sum query immutable - problem no -303
class NumArray {
    private int[] arr;
    public NumArray(int[] nums) {
        arr = new int[nums.length + 1];
        arr[0]=0;
        for(int i =0; i<nums.length; i++)
            arr[i+1]=nums[i]+arr[i];
    }
    
    public int sumRange(int left, int right) {
        return arr[right+1]-arr[left];
    }
}
//single element in a sorted array - problem no- 540
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
           int mid= (left+right)/2;
           if(mid%2==0 && nums[mid]==nums[mid+1] || (mid%2==1 && nums[mid]==nums[mid-1]))
             left = mid+1;
           else
             right =mid;  
        }
        return nums[left];
    }
}
// Maximum average subarray I - problem no -643
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        for(int i =0; i<k; i++){
            sum += nums[i];
        }
        double maxsum = sum;
        int startindex = 0;
        int endindex = k;
        while(endindex < n) {
            sum -= nums[startindex];
            startindex++;
            sum += nums[endindex];
            endindex++;
            maxsum = Math.max(maxsum, sum);
        }
        return (double) maxsum/k;
    }
}
//find pivot index - problem no -724
class Solution {
    public int pivotIndex(int[] nums) {
        int total =0;
        for(int num:nums){
            total += num;
        }
        int lefttotal =0;
        for(int i=0; i<nums.length; i++){
            int righttotal = total - lefttotal - nums[i];
            if(righttotal == lefttotal){
                return i;
            }
            lefttotal += nums[i];
        }
        return -1;
    }
}
//