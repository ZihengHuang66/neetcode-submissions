class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if(strs.length <= 1) {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < strs.length; i++) {
                list.add(strs[i]);
            }
            result.add(list);
            return result;
        } else {
            List<Integer> usedIndex = new ArrayList<>();
            for(int i = 0; i < strs.length; i++) {
                if(!usedIndex.contains(i)) {
                    List<String> currList = new ArrayList<>();
                    currList.add(strs[i]);
                    for(int j = i + 1; j < strs.length; j++) {
                        if(isAnagram(strs[i], strs[j])) {
                            currList.add(strs[j]);
                            usedIndex.add(j);
                        }
                    }
                    result.add(currList);
                }
            }
        }

        return result;
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length() == t.length()) {
            Map<Character, Integer> s1 = new HashMap<>();
            Map<Character, Integer> t1 = new HashMap<>();

            for(int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if(s1.containsKey(curr)) {
                    s1.put(curr, s1.get(curr) + 1);
                } else {
                    s1.put(curr, 1);
                }
            }

            for(int i = 0; i < t.length(); i++) {
                char curr = t.charAt(i);
                if(t1.containsKey(curr)) {
                    t1.put(curr, t1.get(curr) + 1);
                } else {
                    t1.put(curr, 1);
                }
            }

            return s1.equals(t1);
        } else {
            return false;
        }
    }
}
