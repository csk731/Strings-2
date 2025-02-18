// TC: O(m+n)
// SC: O(1)

public class LC28 {
    // private final int MOD = 1000000007;
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m) return -1;
        int hashValue = 0;
        int multiplier = 1;
        // HashValue of needle
        for(int i=n-1;i>=0;i--){
            hashValue += (needle.charAt(i)-96) * multiplier;
            multiplier *= 26;
        }
        int floatingHashValue = 0;
        multiplier = 1;
        for(int i=n-1;i>=0;i--){
            floatingHashValue += (haystack.charAt(i)-96) * multiplier;
            if(i>0) multiplier *= 26;
        }
        if(floatingHashValue == hashValue) return 0;
        for(int i=n;i<m;i++){
            int idxToRemove = i - n;
            floatingHashValue -= (haystack.charAt(idxToRemove)-96) * multiplier;
            floatingHashValue *= 26;
            floatingHashValue += (haystack.charAt(i)-96);
            if(floatingHashValue == hashValue) return idxToRemove+1;
        }
        return -1;
    }
}