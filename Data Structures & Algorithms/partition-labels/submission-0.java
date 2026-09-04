class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            lastIndex.put(curr, i);
        }

        List<Integer> result = new ArrayList<>();
        int size = 0;
        int end = lastIndex.get(s.charAt(0));
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(i == end) {
                result.add(size + 1);
                size = 0;
                if(i < s.length() - 1) {
                    end = lastIndex.get(s.charAt(i + 1));
                }
            } else {
                size++;
            }
            end = Math.max(end, lastIndex.get(curr));
        }
        return result;
    }
}
