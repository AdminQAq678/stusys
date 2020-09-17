package com.wocnz.stusys.controller;

import com.wocnz.stusys.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ws {
    @Autowired
    private WebSocketServer webSocketServer;

    @GetMapping("/ws")
    public String index() {
        System.out.println("ws");
        return "ws";
    }

    @GetMapping("/webSocket")
    public ModelAndView socket() {
        ModelAndView mav=new ModelAndView("/webSocket");
//        mav.addObject("userId", userId);
        return mav;
    }
}
