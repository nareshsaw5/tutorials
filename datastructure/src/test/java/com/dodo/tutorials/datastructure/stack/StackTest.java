package com.dodo.tutorials.datastructure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

    private Stack stack;

    @Test void testPush() {
        stack = new Stack();
        stack.push(20);
        stack.push(30);
        Assertions.assertEquals(2, stack.size());

    }

    @Test void testPop() {
        stack = new Stack();
        stack.push(20);
        stack.push(30);
        Assertions.assertEquals(30, stack.pop());
        Assertions.assertEquals(20, stack.pop());
        Assertions.assertEquals(0, stack.size());
    }

    @Test void testPeek() {
        stack = new Stack();
        stack.push(20);
        stack.push(30);
        Assertions.assertEquals(30, stack.peek());
        Assertions.assertEquals(30, stack.peek());
        Assertions.assertEquals(2, stack.size());
    }
}
