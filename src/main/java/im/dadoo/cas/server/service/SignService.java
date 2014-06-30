/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cas.server.service;

import im.dadoo.cas.domain.User;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author codekitten
 */
@Service
@Transactional
public class SignService {
  
  public User signin(String name, String password) {
    return new User(name, password);
  }
}
