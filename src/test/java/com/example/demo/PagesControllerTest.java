package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PagesController.class)
public class PagesControllerTest {
    @Autowired
    MockMvc mvc;
    
    @Test
    public void testingPages() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }
    @Test
    public void testingPi() throws Exception {
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }
    @Test
    public void testingPostSum() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }
    @Test
    public void testCalculateNoOperation() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
    @Test
    public void testCalculateAdd() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6&operation=add"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
    @Test
    public void testCalculateSubtract() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6&operation=subtract"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }
    @Test
    public void testCalculateMultiply() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6&operation=multiply"))
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }
    @Test
    public void testCalculateDivide() throws Exception {
        this.mvc.perform(get("/math/calculate?x=30&y=5&operation=divide"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

}
