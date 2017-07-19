package yang.yang.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.*;
import yang.yang.springbootdemo.resource.BookController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yanyan on 2017/07/05.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private BookController mockController;

    @Test
    public void name() throws Exception {
        when(mockController.getAllBooks()).thenReturn("abc");
        assertEquals("abc", mockController.getAllBooks());
        this.mvc.perform(get("/books").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andExpect(content().string("done"));
    }

}