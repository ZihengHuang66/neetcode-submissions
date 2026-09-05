class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int[] count = new int[1];
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            dfs(i, i, map, visited, count);
        }
        return count[0];
    }

    private void dfs(int node, int original, Map<Integer, List<Integer>> map, Set<Integer> visited, int[] count) {
        if(visited.contains(node)) {
            return;
        }
        if(node == original) {
            count[0]++;
        }
        visited.add(node);
        
        for(int curr : map.get(node)) {
            dfs(curr, original, map, visited, count);
        }
    }
}
