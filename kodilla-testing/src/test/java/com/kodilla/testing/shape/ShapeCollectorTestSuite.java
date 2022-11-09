package com.kodilla.testing.shape;


import org.junit.jupiter.api.*;


@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Rectangle tests")
    class TestRectangle {

        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(new Rectangle(2, 4));
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeList().size());
        }

        @Test
        void testDisplayEmptyFigure(){
            //given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("", result);
        }

        @Test
        void testDisplaySingleFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Rectangle(2, 4));
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Rectangle", result);
        }

        @Test
        void testDisplayMultipleFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Rectangle(2, 4));
            shapeCollector.addFigure(new Rectangle(5, 10));
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Rectangle, Rectangle", result);
        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Rectangle rectangle = new Rectangle(2, 4);
            shapeCollector.addFigure(rectangle);
            //When
            Shape theFigure = shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals(rectangle, theFigure);
        }

        @Test
        void testGetFigureOutOfScope() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Rectangle rectangle = new Rectangle(2, 4);
            shapeCollector.addFigure(rectangle);
            //When
            Shape theFigure = shapeCollector.getFigure(shapeCollector.getShapeList().size());
            //Then
            Assertions.assertNull(theFigure);
        }

        @Test
        void testRemoveFigureNotExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Rectangle rectangle = new Rectangle(2, 4);
            shapeCollector.addFigure(rectangle);
            Rectangle deleteRectangle = new Rectangle(5, 10);
            //When
            boolean result = shapeCollector.removeFigure(deleteRectangle);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveFigureExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Rectangle rectangle = new Rectangle(2, 4);
            shapeCollector.addFigure(rectangle);
            //When
            boolean result = shapeCollector.removeFigure(rectangle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeList().size());
        }
    }
    @Nested
    @DisplayName("Triangle tests")
    class TestTriangle {

        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(new Triangle(2, 4));
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeList().size());
        }

        @Test
        void testDisplayEmptyFigure(){
            //given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("", result);
        }

        @Test
        void testDisplaySingleFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Triangle(2, 4));
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Triangle", result);
        }

        @Test
        void testDisplayMultipleFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Triangle(2, 4));
            shapeCollector.addFigure(new Triangle(5, 10));
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Triangle, Triangle", result);
        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(2, 4);
            shapeCollector.addFigure(triangle);
            //When
            Shape theFigure = shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals(triangle, theFigure);
        }

        @Test
        void testGetFigureOutOfScope() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(2, 4);
            shapeCollector.addFigure(triangle);
            //When
            Shape theFigure = shapeCollector.getFigure(shapeCollector.getShapeList().size());
            //Then
            Assertions.assertNull(theFigure);
        }

        @Test
        void testRemoveFigureNotExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(2, 4);
            shapeCollector.addFigure(triangle);
            Triangle deleteTriangle = new Triangle(5, 10);
            //When
            boolean result = shapeCollector.removeFigure(deleteTriangle);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveFigureExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(2, 4);
            shapeCollector.addFigure(triangle);
            //When
            boolean result = shapeCollector.removeFigure(triangle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeList().size());
        }
    }

    @Nested
    @DisplayName("Circle tests")
    class TestCircle {

        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(new Circle(2));
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeList().size());
        }

        @Test
        void testDisplayEmptyFigure(){
            //given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("", result);
        }

        @Test
        void testDisplaySingleFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Circle(2));
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Circle", result);
        }

        @Test
        void testDisplayMultipleFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Circle(2));
            shapeCollector.addFigure(new Circle(5));
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Circle, Circle", result);
        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(2);
            shapeCollector.addFigure(circle);
            //When
            Shape theFigure = shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals(circle, theFigure);
        }

        @Test
        void testGetFigureOutOfScope() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(2);
            shapeCollector.addFigure(circle);
            //When
            Shape theFigure = shapeCollector.getFigure(shapeCollector.getShapeList().size());
            //Then
            Assertions.assertNull(theFigure);
        }

        @Test
        void testRemoveFigureNotExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(2);
            shapeCollector.addFigure(circle);
            Circle deleteCircle = new Circle(5);
            //When
            boolean result = shapeCollector.removeFigure(deleteCircle);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveFigureExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(2);
            shapeCollector.addFigure(circle);
            //When
            boolean result = shapeCollector.removeFigure(circle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeList().size());
        }
    }

    @Nested
    @DisplayName("All Shape Tests")
    class allShapeTest{

        @Test
        void testDisplayMultipleTypesShape(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Rectangle(2,4));
            shapeCollector.addFigure(new Triangle(3, 7));
            shapeCollector.addFigure(new Circle(5));

            //When
            String result = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals("Rectangle, Triangle, Circle", result);
        }
    }
}


