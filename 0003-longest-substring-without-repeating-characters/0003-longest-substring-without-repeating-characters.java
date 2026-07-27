class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = "";
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (str.indexOf(ch) != -1) {
                    break;
                }
                str = str + ch;
                if (str.length() > max) {
                    max = str.length();
                }
            }
        }

        return max;
    }
}