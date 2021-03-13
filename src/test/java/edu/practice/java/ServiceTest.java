package edu.practice.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    Database mockDatabase;

    @Test
    public void testQuery(){

        assertNotNull(mockDatabase);
        when(mockDatabase.isAvailable()).thenReturn(true);

        Service testService = new Service(mockDatabase);
        boolean check = testService.query("* from testService");
        assertTrue(check);
    }

    @Test
    public void ensureMockitoReturnsTheConfiguredValue(){

        // define return value for method getUniqueId()
        when(mockDatabase.getUniqueId()).thenReturn(42);

        Service testService = new Service(mockDatabase);
        assertEquals("Using database with id: 42", testService.toString());
    }
}
