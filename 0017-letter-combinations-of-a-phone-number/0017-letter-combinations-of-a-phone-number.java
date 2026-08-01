class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return ans;

        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        helper(digits, "", 0, phone);

        return ans;
    }

    public void helper(String digits, String str, int index, String[] phone) {

        if (index == digits.length()) {
            ans.add(str);
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            helper(digits, str + letters.charAt(i), index + 1, phone);
        }
    }
}