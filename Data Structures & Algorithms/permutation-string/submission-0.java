class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1freq = getFreqMap(s1);
        
        int left = 0;
        int right = s1.length() - 1;
        while(right < s2.length()) {
            int[] currfreq = getFreqMap(s2.substring(left, right + 1));
            if(Arrays.equals(currfreq, s1freq)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    private static int[] getFreqMap(String s) {
        int[] result = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i);
            result[index - 97]++;
        }
        return result;
    }
}
