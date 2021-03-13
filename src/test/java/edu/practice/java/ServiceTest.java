package edu.practice.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    Database mockDatabase;

    @Test
    void testQuery(){

        assertNotNull(mockDatabase);
        when(mockDatabase.isAvailable()).thenReturn(true);

        Service testService = new Service(mockDatabase);
        boolean check = testService.query("* from testService");
        assertTrue(check);
    }
}
