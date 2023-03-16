package com.study.study_springboot_security_2.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
  @GetMapping({ "/" })
  public ModelAndView main(ModelAndView modelAndView) {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
      String username = ((UserDetails) principal).getUsername();
    } else {
      String username = principal.toString();
    }

    String viewName = "/WEB-INF/views/main.jsp";
    modelAndView.setViewName(viewName);
    return modelAndView;
  }

  @GetMapping("/admin") // 관리자 접속
  public ModelAndView admin(ModelAndView modelAndView) {
    String viewName = "WEB-INF/views/admin.jsp";
    modelAndView.setViewName(viewName);
    return modelAndView;
  }
}
