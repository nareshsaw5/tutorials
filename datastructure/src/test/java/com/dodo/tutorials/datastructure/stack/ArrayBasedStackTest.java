package com.dodo.tutorials.datastructure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayBasedStackTest {

    private ArrayBasedStack<Integer> stack;

    @Test void testPush() {
        stack = new ArrayBasedStack(Integer.class);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        Assertions.assertEquals(50, stack.pop());
        Assertions.assertEquals(40, stack.pop());
        Assertions.assertEquals(30, stack.pop());
        Assertions.assertEquals(20, stack.pop());
        Assertions.assertEquals(0, stack.size());

    }
}
