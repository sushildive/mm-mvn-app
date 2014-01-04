package co.sg.rnd.tag;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.sg.rnd.api.SystemTimeService;

public class GreetTag extends SimpleTagSupport {
	private String name;

	/*public void setName(String name) {
		this.name = name;
	}

	@Override
	public void doTag() throws JspException, IOException {
		ServletContext sc = ((PageContext) getJspContext()).getServletContext();
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(sc);
		getJspContext().getOut().write(
				"Hello, " + name + "@<br />"
						+ context.getBean(SystemTimeService.class).now());
	}*/

}
