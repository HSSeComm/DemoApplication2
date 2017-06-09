package com.schedule.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app2")
public class ScheduleCallbackControl {

	private String data = "";

	@RequestMapping(value = "/schedulerCall", method = RequestMethod.GET)
	public @ResponseBody String scheduleCall() {
		data = "App2 been called at:" + new Date();
		if (System.currentTimeMillis() % 5 == 0) {
			return "failed";
		}
		return "successful";
	}

	@RequestMapping(value = "/getLatestData", method = RequestMethod.GET)
	public String deleteScheduleJobs() {
		return data;
	}
}
