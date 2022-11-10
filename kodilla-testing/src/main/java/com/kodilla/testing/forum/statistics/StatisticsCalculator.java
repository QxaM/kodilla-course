package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    private int userNo;
    private int postNo;
    private int commentsNo;
    private double averagePostPerUser;
    private double averageCommentPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        //Dummy data
        userNo = statistics.userNames().size();
        postNo = statistics.postCount();
        commentsNo = statistics.commentsCount();

        if(userNo == 0){
            averagePostPerUser = 0;
            averageCommentPerUser = 0;
        } else {
            averagePostPerUser = (double) postNo / userNo;
            averageCommentPerUser = (double) commentsNo / userNo;
        }

        if(postNo == 0){
            averageCommentsPerPost = 0;
        } else {
            averageCommentsPerPost = (double) commentsNo / postNo;
        }
    }

    public String showStatistics(){
        return "Users: " + userNo + ", Posts: " + postNo + ", Comments: " + commentsNo + ". " +
                "Average post per user: " + averagePostPerUser +
                ", average comments per user: " + averageCommentPerUser +
                ", average comments per post: " + averageCommentsPerPost;
    }
}
