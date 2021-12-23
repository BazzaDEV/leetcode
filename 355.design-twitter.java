/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {

    class Tweet {
        int userId;
        int tweetId;
        Tweet next;

        Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.next = null;
        }

    }

    private HashMap<Integer, HashSet<Integer>> userMap;
    private Tweet tweets;

    public Twitter() {
        userMap = new HashMap<>();
        tweets = new Tweet(-1, -1);
        
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(userId, tweetId);
        
        Tweet next = tweets.next;
        tweets.next = newTweet;
        newTweet.next = next;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        HashSet<Integer> following = userMap.get(userId);
        Tweet head = tweets.next;

        while (head != null && newsFeed.size() < 10) {

            if (head.userId == userId || (following != null && following.contains(head.userId))) {
                newsFeed.add(head.tweetId);
            }

            head = head.next;

        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new HashSet<Integer>());
        
        HashSet<Integer> following = userMap.get(followerId);
        following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> following = userMap.get(followerId);
        
        if (following == null) return;
        following.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

