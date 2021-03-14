package edu.practice.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@ExtendWith(MockitoExtension.class)
public class MockitoSpyTest {

//    @Mock
//    OutputStream outputStream;

    @Test
    public void testMockitoSpy(){

        //Properties properties = new Properties();
//        Properties spyProperties = spy(properties);
        Properties spyProperties = spy(Properties.class);

        doReturn("42").when(spyProperties).get("shoeSize");
        assertEquals("42", (String)spyProperties.get("shoeSize"));
    }

    @Test
    public void testThrowIOException() throws IOException {

        /* These two ways to test doThrow use "outputStream" object
         declare at class level */
        //doThrow(new IOException()).when(outputStream).close();
        //doThrow(IOException.class).when(outputStream).close();
        //assertThrows(IOException.class, () -> outputStream.close());

        // create an configure mock
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockStream).close();
        // use mock
        //OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);
        //assertThrows(IOException.class, () -> streamWriter.close());
        assertThrows(IOException.class, () -> mockStream.close());
    }

    @Test
    public void testLinkedListSpyCorrect() {
        // Lets mock a LinkedList
        List<String> list = new LinkedList<>();
        List<String> spy = spy(list);

        // this would not work as delegate it called so spy.get(0)
        // throws IndexOutOfBoundsException (list is still empty)
        // when(spy.get(0)).thenReturn("foo");

        // you have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);

        assertEquals("foo", spy.get(0));
    }
}
