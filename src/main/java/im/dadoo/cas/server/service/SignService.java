/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cas.server.service;

import com.google.common.base.Optional;
import im.dadoo.cas.domain.User;
import im.dadoo.cas.server.dao.UserDao;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author codekitten
 */
@Service
@Transactional
public class SignService {
  
  @Resource
  private UserDao userDao;
  
  public Optional<User> signin(String name, String password) {
    Optional<User> user = this.userDao.findByName(name);
    if (user.isPresent() && user.get().getPassword().equals(password)) {
      return user;
    } else {
      return Optional.absent();
    }
  }
}
