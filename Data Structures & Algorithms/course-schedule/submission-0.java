class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();

        // build the map
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] prereq : prerequisites) {
            map.get(prereq[0]).add(prereq[1]);   
        }

        // operate dfs, every course must be completed
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, visiting, map)) return false;
        }
        return true;
    }
        private boolean dfs(int course, Set<Integer> visiting, Map<Integer, List<Integer>> map) {
            if(visiting.contains(course)) return false;
            if(map.get(course).isEmpty()) return true;
            
            visiting.add(course);
            for(int prereq : map.get(course)) {
                if(!dfs(prereq, visiting, map)) return false;
            }

            // remove the current course for next use
            visiting.remove(course);
            // mark the course as completed
            map.put(course, new ArrayList<>());
            return true;
        }
}
