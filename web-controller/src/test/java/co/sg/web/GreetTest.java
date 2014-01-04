package co.sg.web;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.sg.rnd.api.SystemTimeService;
import co.sg.web.ui.common.AbstractUnitTest;

public class GreetTest extends AbstractUnitTest {

	@Autowired
	private Greet greet;
	@Autowired
	private SystemTimeService systemTimeService;

	@Test
	public void testGreet() {
		String servicemsg = "Test message";
		when(systemTimeService.now()).thenReturn(servicemsg);
		try {
			getMockMvc()
					.perform(get("/home/wc"))
					.andExpect(status().isOk())
					.andExpect(view().name("hw"))
					.andExpect(forwardedUrl("/WEB-INF/ui/hw.jsp"))
					.andExpect(
							model().attribute("welcomeMessage", notNullValue()))
					.andExpect(
							model().attribute(
									"welcomeMessage",
									equalTo("Hello baby, @" + servicemsg
											+ "...!")));
			verify(systemTimeService, times(1)).now();
			verifyNoMoreInteractions(systemTimeService);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Should not thow exception");
		}

	}

	@Override
	protected Object[] controller() {
		return new Object[] { greet };
	}

}
