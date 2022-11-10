package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsCalculatorTestSuite {

    @Mock
    private Statistics statisticsMock;

    private List<String> userNames = new ArrayList<>();
    private int postsCount;
    private int commentsCount;

    @Nested
    class PostsTests{

        @BeforeEach
        public void getUserNames(){
            for (int i = 1; i <= 5; i++){
                userNames.add("user" + i);
            }
        }
        @BeforeEach
        public void getCommentsCount(){
            commentsCount = 100;
        }

        @DisplayName("No posts in a forum")
        @Test
        void testNoPosts(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.userNames()).thenReturn(userNames);
            when(statisticsMock.postCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(commentsCount);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            //Then
            assertEquals("Users: 5, Posts: 0, Comments: 100. Average post per user: 0.0, " +
                    "average comments per user: 20.0, average comments per post: 0.0", statisticsCalculator.showStatistics());
        }

        @DisplayName("1000 posts in a forum")
        @Test
        void test1000Posts(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.userNames()).thenReturn(userNames);
            when(statisticsMock.postCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(commentsCount);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            //Then
            assertEquals("Users: 5, Posts: 1000, Comments: 100. Average post per user: 200.0, " +
                    "average comments per user: 20.0, average comments per post: 0.1", statisticsCalculator.showStatistics());
        }
    }

    @Nested
    class CommentsTests{

        @BeforeEach
        public void getUserNames(){
            for (int i = 1; i <= 5; i++){
                userNames.add("user" + i);
            }
        }
        @BeforeEach
        public void getPostCount(){
            postsCount = 100;
        }

        @DisplayName("No comments in a forum")
        @Test
        void testNoComments(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.userNames()).thenReturn(userNames);
            when(statisticsMock.postCount()).thenReturn(postsCount);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            //Then
            assertEquals("Users: 5, Posts: 100, Comments: 0. Average post per user: 20.0, " +
                    "average comments per user: 0.0, average comments per post: 0.0", statisticsCalculator.showStatistics());
        }

        @DisplayName("More comments than post in a forum")
        @Test
        void testMoreCommentsThanPost(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.userNames()).thenReturn(userNames);
            when(statisticsMock.postCount()).thenReturn(postsCount);
            when(statisticsMock.commentsCount()).thenReturn(50);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            //Then
            assertEquals("Users: 5, Posts: 100, Comments: 50. Average post per user: 20.0, " +
                    "average comments per user: 10.0, average comments per post: 0.5", statisticsCalculator.showStatistics());
        }

        @DisplayName("More posts than comments in a forum")
        @Test
        void testMorePostsThanComments(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.userNames()).thenReturn(userNames);
            when(statisticsMock.postCount()).thenReturn(postsCount);
            when(statisticsMock.commentsCount()).thenReturn(150);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            //Then
            assertEquals("Users: 5, Posts: 100, Comments: 150. Average post per user: 20.0, " +
                    "average comments per user: 30.0, average comments per post: 1.5", statisticsCalculator.showStatistics());
        }
    }

    @Nested
    class UserTests{

        @BeforeEach
        public void getPostCount(){
            postsCount = 100;
        }
        @BeforeEach
        public void getCommentsCount(){
            commentsCount = 200;
        }

        @DisplayName("No users in a forum")
        @Test
        void testNoUsers(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            List<String> noUsers = new ArrayList<>();
            when(statisticsMock.userNames()).thenReturn(noUsers);
            when(statisticsMock.postCount()).thenReturn(postsCount);
            when(statisticsMock.commentsCount()).thenReturn(commentsCount);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            //Then
            assertEquals("Users: 0, Posts: 100, Comments: 200. Average post per user: 0.0, " +
                    "average comments per user: 0.0, average comments per post: 2.0", statisticsCalculator.showStatistics());
        }

        @DisplayName("100 users in a forum")
        @Test
        void test100Users(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            List<String> noUsers = new ArrayList<>();
            for (int i = 1; i <= 100; i++){
                noUsers.add("user" + i);
            }
            when(statisticsMock.userNames()).thenReturn(noUsers);
            when(statisticsMock.postCount()).thenReturn(postsCount);
            when(statisticsMock.commentsCount()).thenReturn(commentsCount);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            //Then
            assertEquals("Users: 100, Posts: 100, Comments: 200. Average post per user: 1.0, " +
                    "average comments per user: 2.0, average comments per post: 2.0", statisticsCalculator.showStatistics());
        }
    }
}
