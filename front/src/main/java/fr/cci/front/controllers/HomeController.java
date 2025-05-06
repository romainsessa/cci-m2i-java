package fr.cci.front.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import fr.cci.front.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	private UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public ModelAndView home(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/login2");
		}
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("users", userService.get());
		return mav;
	}
	
	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView("admin");
		return mav;
	}

}
