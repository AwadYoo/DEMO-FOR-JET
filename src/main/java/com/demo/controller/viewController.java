package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class viewController {

    @GetMapping("/login")
    public ModelAndView login(HttpSession session) {
        ModelAndView mv = new ModelAndView("/login");
//        if (session != null) {
//            mv.addObject("failureReason", session.getAttribute("failureReason"));
//            session.removeAttribute("failureReason");
//        }
        return mv;
    }

    @GetMapping("/hello")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/hello");
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mv = new ModelAndView("/logout");
        return mv;
    }


}
