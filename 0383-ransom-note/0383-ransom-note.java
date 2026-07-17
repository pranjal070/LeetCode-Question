class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] arr = magazine.toCharArray();
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == ch) {
                    arr[j] = '#';   
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}