package by.pvt.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MinMaxServeceImplTest {

    MinMaxServeceImpl objUnderTest;
    List<Integer> list = List.of(2,1,3);

    @org.junit.Before
    public void setUp() throws Exception {
        objUnderTest = new MinMaxServeceImpl();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        objUnderTest = null;
    }

    @org.junit.Test
    public void findMin() {
        Integer result = objUnderTest.findMin(list);
        assertEquals(Integer.valueOf(1),result);
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void findMinWithException() {
        List<Integer> list3 = new ArrayList<>();
        list3.add(null);
        list3.add(null);
        objUnderTest.findMin(list3);
    }

    @org.junit.Test
    public void findMax() {
        Integer result2 = objUnderTest.findMax(list);
        assertEquals(Integer.valueOf(3),result2);
    }
}