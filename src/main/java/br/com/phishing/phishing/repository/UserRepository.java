package br.com.phishing.phishing.repository;

import br.com.phishing.phishing.model.User;

public interface UserRepository {
    User save(User user);
}
