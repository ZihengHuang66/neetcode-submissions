class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result, 0, 0);
        return result;
    }

    private void helper(String s, List<String> soFar, List<List<String>> result, int j, int i) {
        if(i >= s.length()) {
            if(i == j) {
                result.add(new ArrayList<>(soFar));
            }
            return;
        }
        
        if(isPali(s, j, i)) {   //暂时确认左侧部分
            soFar.add(s.substring(j, i + 1));   
            helper(s, soFar, result, i + 1, i + 1); //寻找右侧的部分
            soFar.remove(soFar.size() - 1);     //回溯
        }
        helper(s, soFar, result, j, i + 1); //继续寻找新的左侧的部分
    }

    private boolean isPali(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
