package co.sg.rnd.apiimpl;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import co.sg.rnd.api.SystemTimeService;

@Component
public class SystemTimeServiceProvider implements SystemTimeService {

	public String now() {
		return Calendar.getInstance().getTime().toString();
	}

}
