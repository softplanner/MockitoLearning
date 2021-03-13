package edu.practice.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.Iterator;

@ExtendWith(MockitoExtension.class)
public class MockitoWhenExampleTest {

    @Mock
    Iterator<String> mockIteratorString;

    //@Mock Comparable<String> c;

    // demonstrates the return of multiple values
    @Test
    public void testMoreThenOneReturnValue(){

        when(mockIteratorString.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = mockIteratorString.next() + " " + mockIteratorString.next();
        //assert
        assertEquals("Mockito rocks", result);
    }

    // this test demonstrates how to return values based on the input
    // and that @Mock can also be used for a method parameter
    @Test
    //public void testReturnValueDependentOnMethodParameter() {
    public void testReturnValueDependentOnMethodParameter(@Mock Comparable<String> c) {

        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));
        assertEquals(2, c.compareTo("Eclipse"));
    }

    // return a value based on the type of the provide parameter
    @Test
    public void testReturnValueInDependentOnMethodParameter2(@Mock Comparable<Integer> c )  {
        when(c.compareTo(isA(Integer.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(Integer.valueOf(4)));
    }
}
