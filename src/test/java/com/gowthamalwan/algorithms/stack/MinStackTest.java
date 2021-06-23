package com.gowthamalwan.algorithms.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinStackTest {
  private MinStack minStack;

  @BeforeEach
  void init() {
    minStack = new MinStack();
    minStack.push(1);
    minStack.push(2);
    minStack.push(-1);
  }

  @Test
  void getMinTest() {
    Assertions.assertEquals(-1, minStack.getMin());
  }

  @Test
  void popTest() {
    minStack.pop();

    Assertions.assertEquals(1, minStack.getMin());
  }

  @Test
  void topTest() {
    Assertions.assertEquals(-1, minStack.top());
  }

}
