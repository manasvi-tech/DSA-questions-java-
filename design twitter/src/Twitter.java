import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Tweet implements Comparable<Tweet>{
    int time;
    int tweetId;
    Tweet(int time, int tweetId){
        this.tweetId = tweetId;
        this.time = time;
    }

    public int compareTo(Tweet that){
        return that.time - this.time; // decending order
    }
}

class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int userId){
        this.userId = userId;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
    }

    void addTweet(Tweet t){
        // System.out.println(this.userId+ " posted tweet with id "+t.tweetId);
        tweets.add(0, t);
    }

    void addFollower(int followerId){
        // System.out.println(this.userId+" started following "+followerId);
        followers.add(followerId);
        // System.out.println("Size of follower list "+followers.size());
    }

    void removeFollower(int followerId){
        followers.remove(followerId);
        // System.out.println("Follower removed");
    }
}

class Twitter {

    HashMap<Integer, User> users;
    int timeCounter;

    public Twitter() {
        users = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }

        User user = users.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

public List<Integer> getNewsFeed(int userId) {
    if (!users.containsKey(userId)) {
        return new ArrayList<>();
    }

    PriorityQueue<Tweet> pq = new PriorityQueue<>();
    User user = users.get(userId);

    // Add self tweets
    for (Tweet tweet : user.tweets) {
        // System.out.println("user self posted tweet -"+tweet.tweetId);
        pq.offer(tweet);
        if (pq.size() > 10) {
            pq.poll(); // Remove the oldest tweet to maintain top 10 most recent tweets
        }
    }

    for (int followeeId : user.followers) {
        // System.out.println("Checking "+followeeId+" tweets");
        if (users.containsKey(followeeId)) {
            for (Tweet tweet : users.get(followeeId).tweets) {
                // System.out.println(FfolloweeId +"posted tweet with id "+tweet.tweetId);
                pq.offer(tweet);
                if (pq.size() > 10) {
                    pq.poll(); // Remove the oldest tweet to maintain top 10 most recent tweets
                }
            }
        }
    }

    List<Integer> ans = new ArrayList<>();
    while (!pq.isEmpty()) {
        ans.add(pq.poll().tweetId);
    }

    // Reverse the list to get the most recent tweets first
    return ans;
}


    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }

        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }

        User user = users.get(followerId);
        user.addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || !users.containsKey(followeeId)) {
            return;
        }

        User user = users.get(followerId);
        user.removeFollower(followeeId);
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
