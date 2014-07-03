/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cas.server.dao;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import im.dadoo.cas.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author codekitten
 */
@Repository
public class UserDao extends BaseDao<User> {
  
  private static final String FIND_BY_ID_SQL = 
          "SELECT id,name,password FROM t_user WHERE id=:id LIMIT 1";
  
  private static final String FIND_BY_NAME_SQL = 
          "SELECT id,name,password FROM t_user WHERE name=:name LIMIT 1";
  
  private final RowMapper<User> baseRowMapper;
  
  public UserDao() {
    super(User.class);
    this.baseRowMapper = new BaseRowMapper();
  }
  
  public Optional<User> findById(int id) {
    Preconditions.checkArgument(id > 0, "id必须大于0");
    MapSqlParameterSource sps = new MapSqlParameterSource();
    sps.addValue("id", id);
    List<User> users = this.jdbcTemplate.query(FIND_BY_ID_SQL, sps, this.baseRowMapper);
    if (users != null && !users.isEmpty()) {
      return Optional.of(users.get(0));
    } else {
      return Optional.absent();
    }
  }
  
  public Optional<User> findByName(String name) {
    Preconditions.checkNotNull(name, "name不能为null");
    MapSqlParameterSource sps = new MapSqlParameterSource();
    sps.addValue("name", name);
    List<User> users = this.jdbcTemplate.query(FIND_BY_NAME_SQL, sps, this.baseRowMapper);
    if (users != null && !users.isEmpty()) {
      return Optional.of(users.get(0));
    } else {
      return Optional.absent();
    }
  }
  
  private class BaseRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setId(rs.getInt("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
      return user;
    }
  }
}
