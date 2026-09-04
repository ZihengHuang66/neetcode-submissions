class Solution {
    public boolean validTree(int n, int[][] edges) {
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
    
        // for(int i = 0; i < n; i++) {
        //     if(map.get(i).isEmpty())  {
        //         return false;
        //     }
        // }
        if(!dfs(0, -1, map, visited)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        for(int curr : map.get(node)) {
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
