package edu.practice.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Properties;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoThrowTest {

    // A way to mock
//    @Mock
//    Properties properties = new Properties();
    // another way to mock object
    Properties properties = Mockito.mock(Properties.class);

    // demonstrates the configuration of a throws with Mockito
    // not a read test, just "testing" Mockito behavior
    @Test
    //public void testMockitoThrows(@Mock Properties properties) {
    public void testMockitoThrows() {
        when(properties.get(Mockito.anyString())).thenThrow(new IllegalArgumentException("Stuff"));
        //assert
        assertThrows(IllegalArgumentException.class, () -> properties.get("A"));
    }
}
