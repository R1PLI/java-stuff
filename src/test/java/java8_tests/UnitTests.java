package java8_tests;

import java8.CodingPractice;
import java8.NumericHelper;
import java8.classes.Camera;
import java8.classes.Mailer;
import java8.classes.Resource;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class UnitTests {

  private CodingPractice codingPractice;
  private List<Integer> numbers;

  @Before
  public void setUp() {
    codingPractice = new CodingPractice();
  }

  @Test
  public void sumOfElementsShouldReturnInteger() {
    numbers = asList(1, 3);

    assertThat(codingPractice.summingOfElements(numbers, 2)).isInstanceOf(Integer.class);
  }

  @Test
  public void getSumOfEvenElementsInListMultiplyingByTwo() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.summingOfElements(numbers, 2)).isEqualTo(60);
  }

  @Test
  public void getSumOfEvenElementsInListMultiplyingByVariousNumber() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.summingOfElements(numbers, 8)).isEqualTo(240);
  }

  @Test
  public void checkIfNotDuplicates() {
    numbers = asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    assertThat(codingPractice.removeDuplicatesValuesInListMultiplyByTwo(numbers)).containsOnly(2, 4, 6, 8, 10);
  }

  // strategy pattern tests

  @Test
  public void highOrderFunctionTest() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.totalValues(numbers, e -> true)).isEqualTo(55);
  }

  @Test
  public void highOrderFunctionWithEvenNumbersTest() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.totalValues(numbers, NumericHelper::isEven)).isEqualTo(30);
  }

  @Test
  public void highOrderFunctionWithOddNumbersTest() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.totalValues(numbers, NumericHelper::isOdd)).isEqualTo(25);
  }

  //decorator pattern tests

  @Test
  public void defaultColorTest() {
    System.out.println("=============================");
    codingPractice.printSnap(new Camera());
    System.out.println("=============================\n");
  }

  @Test
  public void decoratorColorBrighterTest() {
    System.out.println("=============================");
    codingPractice.printSnap(new Camera(Color::brighter));
    System.out.println("=============================\n");
  }

  @Test
  public void decoratorColorDarkerTest() {
    System.out.println("=============================");
    codingPractice.printSnap(new Camera(Color::darker));
    System.out.println("=============================\n");
  }

  //builder pattern tests

  @Test
  public void mailerTest() {
    System.out.println("=============================");
    Mailer.send(mailer ->
        mailer.from("builder")
            .to("to me")
            .subject("hi")
            .body("...that's it"));
    System.out.println("=============================\n");
  }

  //execute around method pattern tests

  @Test
  public void cleanUpTest() {
    System.out.println("=============================");
    Resource.use(resource ->
        resource
            .op1()
            .op2()
    );
    System.out.println("=============================\n");
  }

  @Test
  public void compareToMethods() {
    Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
    assertThat(codingPractice.imperativeStyleOfFindFirstDoubleValue(doubles)).isEqualTo(codingPractice.functionStyleOfFindFirstDouble(doubles));
  }
}