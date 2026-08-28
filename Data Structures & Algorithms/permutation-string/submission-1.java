class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1freq = getFreqMap(s1);
        
        int left = 0;
        int right = s1.length() - 1;
        int[] currfreq = getFreqMap(s2.substring(left, right + 1));
        if(Arrays.equals(currfreq, s1freq)) {
            return true;
        }
        
        while(right < s2.length()) {
            int removeindex = (int) s2.charAt(left) - 97;
            left++;
            right++;
            if(right == s2.length()) {
                break;
            }
            int addindex = (int) s2.charAt(right) - 97;
            currfreq[removeindex]--;
            currfreq[addindex]++;
            if(Arrays.equals(currfreq, s1freq)) {
                return true;
            }
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
