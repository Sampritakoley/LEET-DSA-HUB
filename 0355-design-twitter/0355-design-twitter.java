class Twitter {

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Tweet> tweets;
    private Map<Integer, Set<Integer>> following;
    private int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }
    public void postTweet(int userId, int tweetId) {

        Tweet tweet = new Tweet(tweetId, timestamp++);

        tweet.next = tweets.get(userId);

        tweets.put(userId, tweet);
    }
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );
        if (tweets.containsKey(userId)) {
            pq.offer(tweets.get(userId));
        }
        Set<Integer> users = following.getOrDefault(
            userId, new HashSet<>()
        );

        for (int followeeId : users) {
            if (tweets.containsKey(followeeId)) {
                pq.offer(tweets.get(followeeId));
            }
        }
        while (!pq.isEmpty() && result.size() < 10) {
            Tweet current = pq.poll();
            result.add(current.tweetId);
            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        return result;
    }
    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna