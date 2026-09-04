class Solution {
    public boolean validTree(int n, int[][] edges) {
        // a tree with n nodes must have only n - 1 edges!
        if(edges.length > n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        // the default parent is set to -1 here for convenience
        if(!dfs(0, -1, map, visited)) {
            return false;
        }
        return visited.size() == n; //also check if there are any un-connected nodes
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        for(int curr : map.get(node)) {
            /* IMPORTANT!! no need to dfs to its parent */
            if(curr == parent) {
                continue;
            }
            if(!dfs(curr, node, map, visited)) {
                return false;
            }
        }
        return true;
    }

}
