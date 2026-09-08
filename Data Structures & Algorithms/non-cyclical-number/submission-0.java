class Solution {
    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private boolean isHappy(int n, Set<Integer> visited) {
        if(n == 1) {
            return true;
        }
        if(visited.contains(n)) {
            return false;
        }
        visited.add(n);
        return isHappy(convert(n), visited);
    }

    private int convert(int n) {
        if(n != 0) {
            return (int)Math.pow(n % 10, 2) + convert(n / 10);
        } else {
            return 0;
        }
    }
}
