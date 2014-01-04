package co.sg.web.ui.common;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/config/utContext.xml" })
public abstract class AbstractUnitTest {
	private MockMvc mockMvc;

	protected MockMvc getMockMvc() {
		return mockMvc;
	}

	@Before
	public void setup() {
		resetMocks();
		mockMvc = MockMvcBuilders.standaloneSetup(controller())
				.setHandlerExceptionResolvers(exceptionResolver())
				//.setValidator(validator())
				.setViewResolvers(viewResolver())
				.build();
	}

	protected void resetMocks() {
	}

	protected ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/ui/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/*protected Validator validator() {
		return new LocalValidatorFactoryBean();
	}*/

	protected List<HandlerExceptionResolver> exceptionResolver() {
		HandlerExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		return Arrays.asList(exceptionResolver);
	}

	protected abstract Object[] controller();
}
