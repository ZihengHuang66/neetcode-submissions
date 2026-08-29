class Twitter {
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;
    private int count;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)) {
            List<int[]> curr = new ArrayList<>();
            curr.add(new int[]{count++, tweetId});
            tweetMap.put(userId, curr);
        } else {
            tweetMap.get(userId).add(new int[]{count++, tweetId});
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        follow(userId, userId);
        
        List<Integer> res = new ArrayList<>();
        Queue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> -a[0])
        );

        for(int followeeId : followMap.get(userId)) {
            if(tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                for(int[] tweet : tweets) {
                    minHeap.offer(tweet);
                }
            }
        }

        int index = 10;
        while(!minHeap.isEmpty() && index > 0) {
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            index--;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)) {
            Set<Integer> curr = new HashSet<>();
            curr.add(followeeId);
            followMap.put(followerId, curr);
        } else {
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(followeeId);
    }
}
