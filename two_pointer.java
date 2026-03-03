//TWO POINTER PROBLEMS - 11 problems solved
//- What it is
// Use two variables (pointers) to scan an array or list at the same time.
//- How it works
// One pointer starts at the beginning, the other at the end (or both move forward together).
//- Why it’s useful
// Cuts down nested loops, making problems faster (usually O(n) instead of O(n²)).
//- Where it’s used
// Finding pairs with a target sum, reversing arrays, removing duplicates, sliding window problems.
//- Types of movement
// Opposite direction: start and end moving inward.
//Same direction: both move forward for window-based problems.

//container with most water - problem no : 11
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

//3 sum - problem no : 15
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

//Remove Nth node from end of list - problem no : 19
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;
        for(int i=0; i<n; i++){
            head = head.next;
        }
        while (head != null){
            head = head.next;
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return res.next;
    }  
}
//Find the index of first occurence in a string - problem no : 28
class Solution {
    public int strStr(String haystack, String needle) {
        int nlen = haystack.length();
        int mlen = needle.length(); 
        if(mlen > nlen) return -1;
        for(int i = 0; i <= nlen - mlen; i++){
            if(haystack.substring(i, i + mlen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
//Two sum II- Input Array is sorted - problem no : 167
class Solution {
    public int strStr(String haystack, String needle) {
        int nlen = haystack.length();
        int mlen = needle.length(); 
        if(mlen > nlen) return -1;
        for(int i = 0; i <= nlen - mlen; i++){
            if(haystack.substring(i, i + mlen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
//Reverse String - problem no : 344
class Solution {
    public void reverseString(char[] s) {
       int l=0,r=s.length-1;
       while(l<r){
        char temp = s[l];
        s[l] =s[r];
        s[r]=temp;
        l++;
        r--;
       }
    }
}
//Reverse vowels of a string - problem no : 345
class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int right = ch.length - 1;
        for(int i=0;i<ch.length && i<right;i++){
            if(!isVowel(ch[i])) continue;
            for(int j=right; j>=0 && i<j; j--){
                if(!isVowel(ch[j])) continue;
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                right = j - 1;
                break;
            }
        }
        String newString = new String(ch);
        return newString;
        
    }
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
//Assign cookies - problem no : 455
class Solution {
    public int findContentChildren(int[] g, int[] s) {
      Arrays.sort(g);
      Arrays.sort(s);
      int n=g.length;
      int m = s.length;
      int i =0;
      for(int j=0;j<m && i<n;j++){
        if(s[j]>=g[i]){
            i++;
        }
     } 
      return i;
    }
}
//Heaters - problem no : 475
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int res=0;
        for(int i=0;i<houses.length;i++){
            int min_dist=Integer.MAX_VALUE;
        for(int j=0;j<heaters.length;j++){
            int dist= Math.abs(houses[i]-heaters[j]);
            if(dist<min_dist){
                min_dist=dist;
            }
        }
        res = Math.max(res,min_dist); 
    }
     return res;
    }
}
//Middle of the LinkedList - 876
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head.next == null || head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
//Boats to save people - 881
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int ans = 0;
        while(left<=right){
            if(people[left] + people[right]<=limit){
                ans++;
                left++;
                right--;
            } else if(people[right]<=limit){
                ans++;
                right--;
            }
        } 
        return ans;
    }
}

