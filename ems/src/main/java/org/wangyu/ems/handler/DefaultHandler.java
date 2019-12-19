package org.wangyu.ems.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultHandler {
	
	@RequestMapping("/")
	public String Default() {
		return "login";
	}

}
