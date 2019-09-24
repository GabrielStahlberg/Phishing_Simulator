package br.com.phishing.phishing.repository;

import br.com.phishing.phishing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public User save(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User inválido");
        }

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement pStat = conn.prepareStatement(
                    "insert into phishing_user (user_email, user_password) values (?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pStat.setString(1, user.getEmail());
            pStat.setString(2, user.getPassword());
            return pStat;
        }, keyHolder);

        user.setId((Integer)keyHolder.getKeys().get("user_id"));

        return user;
    }
}
