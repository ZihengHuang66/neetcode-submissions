class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap<>();
        buildMap(map);
        List<String> result = new ArrayList<>();
        helper(digits, result, "", 0, map);
        return result;
    }

    private void helper(String digits, List<String> result, String curr, int index, Map<Integer, String> map) {
        if(index == digits.length()) {
            result.add(curr);
            return;
        }
        int key = digits.charAt(index) - '0';
        String str = map.get(key);
        for(int i = 0; i < str.length(); i++) {
            helper(digits, result, curr + str.charAt(i), index + 1, map);
        }
    }

    private void buildMap(Map<Integer, String> map) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
}