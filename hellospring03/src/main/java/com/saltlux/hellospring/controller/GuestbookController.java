package com.saltlux.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author BIT_R39
 *
 * @RequestMapping Type(Class) ๋จ๋ ๋งคํ
 * 
 */

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
   
   @ResponseBody
   @RequestMapping()
   public String list() {
      return "GuestbookController:list()";
   }

   @ResponseBody
   @RequestMapping()
   public String delete() {
      return "GuestbookController:delete()";
   }
   
}