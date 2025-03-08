package com.example.dao;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail());
        System.out.println("User added: "+ user);
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
        System.out.println("User updated: " + user);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("User deleted with id: " + id);
    }
    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
        }
    }
}

