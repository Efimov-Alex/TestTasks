package ru.mos.qa.testtasks.tests;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProblemTests {

  private String CONST = "const";
  private final static String bd = "pui";

  @Test
  public void equalsStringOneToOne(){
    assertEquals("1", "1");
  }


  @Test
  public void assignValueToConstVar(){
    CONST = "newValue"; // убрать final
    assertEquals("newValue", CONST);
  }

  @Test
  public void equalsIntegerOneToOne(){
    assertEquals(1, 1); // поменять названия
  }



  @Test
  public void stringsMustBeEqual(){
    String res = "a";
    String newPuiString = new String("pui");

    if (bd.equals(newPuiString)) {
      res = "asd";
    }

    assertEquals("asd", res);
  }

  @Test
  public void successfullyRemovingFirstElementFromList(){
    List<String> sourceData = new ArrayList<>(List.of("1", "viskas", "chupocabra"));
    if (sourceData.size() > 0){
      sourceData.remove(0);
    }
    assertFalse(sourceData.contains("1"));
  }


}