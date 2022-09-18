package com.eomcs.mylist.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/home")
  public String home(Model model) {
    model.addAttribute("welcome", "안녕하세요!");
    return "home";
  }
}
