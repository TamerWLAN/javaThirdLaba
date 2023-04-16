package com.art;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    @org.junit.jupiter.api.Test
    void testTestAllFoo() {
        Timer time = new Timer(100);
        assertNotEquals("", time.testAll());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        Timer time = new Timer(100);
        time.testOperation("add");
        assertEquals(100, time.getListsSize());
    }
    @org.junit.jupiter.api.Test
    void testRemove() {
        Timer time = new Timer(100);
        time.testOperation("remove");
        assertEquals(0, time.getListsSize());
    }

    @org.junit.jupiter.api.Test
    void testGet() {
        Timer time = new Timer(100);
        time.testOperation("get");
        assertEquals(100, time.getListsSize());
    }


    @org.junit.jupiter.api.Test
    void testSet() {
        Timer time = new Timer(100);
        time.testOperation("set");
        assertEquals(100, time.getListsSize());
    }

    @org.junit.jupiter.api.Test
    void testUnexpectedOperation() {
        Timer time = new Timer(100);

        Exception ex = assertThrows(RuntimeException.class, ()->{
            time.testOperation("sdsdsd");
        });

        assertEquals("Invalid operation", ex.getMessage());
    }
}