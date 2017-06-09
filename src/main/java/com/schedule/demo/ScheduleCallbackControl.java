package com.schedule.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app2")
public class ScheduleCallbackControl {

	private String data = "";
	private List<String> dataList = new ArrayList<>();

	@RequestMapping(value = "/schedulerCall", method = RequestMethod.GET)
	public @ResponseBody String scheduleCall() {
		if (dataList.size() > 9) {
			dataList.remove(0);
		}
		dataList.add("App1 been called at:" + new Date());
		data = "";
		for (String dataItem : dataList) {
			data = data + dataItem + "<br/>";
		}
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
