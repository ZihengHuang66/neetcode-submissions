class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, map, visited, cycle, res)) return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
    private boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> visited,
                      Set<Integer> cycle, List<Integer> res) {
        if(cycle.contains(course)) return false;
        if(visited.contains(course)) return true;

        cycle.add(course);
        for(int pre : map.get(course)) {
            if(!dfs(pre, map, visited, cycle, res)) return false;
        }
        cycle.remove(course);
        visited.add(course);
        res.add(course);
        return true;
    }
}
