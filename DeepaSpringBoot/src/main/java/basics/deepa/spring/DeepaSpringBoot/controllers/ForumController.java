package basics.deepa.spring.DeepaSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import basics.deepa.spring.DeepaSpringBoot.services.JpaService;

@Controller
@RequestMapping("/forum")
public class ForumController 
{
	@Autowired
	JpaService service;
	
	
}
