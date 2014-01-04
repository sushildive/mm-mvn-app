package co.sg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.sg.rnd.api.SystemTimeService;

@Controller
@RequestMapping("/home")
public class Greet {
	@Autowired
	private SystemTimeService timeService;

	@RequestMapping(value = "wc", method = RequestMethod.GET)
	public ModelAndView greet() {
		return new ModelAndView("hw", "welcomeMessage", msg());
	}

	private String msg() {
		return "Hello baby, @" + timeService.now() + "...!";
	}
}
