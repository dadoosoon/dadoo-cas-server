/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cas.server.controller;

import im.dadoo.cas.domain.User;
import im.dadoo.cas.server.service.SignService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author codekitten
 */
@Controller
public class SignController {
  
  @Resource
  private SignService signService;
  
  @RequestMapping(value = "/signin", method = RequestMethod.POST)
  @ResponseBody
  public User signin(@RequestParam String name, @RequestParam String password) {
    return this.signService.signin(name, password);
  }
}
