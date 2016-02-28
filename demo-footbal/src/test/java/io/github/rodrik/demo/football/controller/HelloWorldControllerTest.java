package io.github.rodrik.demo.football.controller;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HelloWorldControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private HelloWorldController sut;
	
	@Before
	public void testThatSutIsRunning() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(sut).build();
		Assertions.assertThat(sut).isNotNull();
	}

	@Test
	public void test() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.get("/api/hello")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello World!"))
				;
	}

}
