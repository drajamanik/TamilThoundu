package org.wotsoc.tamilthoundu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class MainController {
  
    @RequestMapping("/TamilThoundu")
    public String welcome() {
        return "index";
    }
}