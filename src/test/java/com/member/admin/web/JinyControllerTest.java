package com.member.admin.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = JinyController.class)
public class JinyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_return() throws Exception{
        String hello = "Server Start";

        mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(hello));
    }


    @Test
    public void hello_dto_return() throws Exception{
        String id = "test";
        String pw = "1234!@#$";

        mvc.perform(
                    get("/hello/dto")
                            .param("id", id)
                            .param("pw", pw))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.pw", is(pw)));

    }
}
