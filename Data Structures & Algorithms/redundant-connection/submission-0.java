class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int root1 = find(edge[0], parent);
            int root2 = find(edge[1], parent);

            if(root1 == root2) {
                return edge;
            }
            parent[root2] = root1;
        }

        return new int[0];
    }

    private int find(int x, int[] parent) {
        if(parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}
