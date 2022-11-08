package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test Suite: end");
    }

    @DisplayName(
            "When empty List is created empty list is expected"
    )
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> numbersList = new ArrayList<>();
        //When
        System.out.println("Testing empty list");
        List<Integer> result = exterminator.exterminate(numbersList);
        List<Integer> expectedResult = new ArrayList<>();
        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName(
            "When normal list is created, even numbers should be expected"
    )
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        //When
        System.out.println("Testing normal list");
        List<Integer> result = exterminator.exterminate(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        //Then
        Assertions.assertEquals(Arrays.asList(2, 4, 6, 8), result);
    }
}
