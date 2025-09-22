package com.portfolio.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.model.loginmodel;

public interface loginrepo extends JpaRepository<loginmodel, Long> {
    Optional<loginmodel> findByUsername(String username);
}
