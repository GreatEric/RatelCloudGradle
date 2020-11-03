package com.ratel.codegenerator.repositories;

import com.ratel.codegenerator.entities.BasicConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicConfigRepository extends JpaRepository<BasicConfig, Long> {
    /*Optional<BasicConfig> findByEmailOrPhone(String email, String phone);

    Optional<BasicConfig> findByPhone(String phone);

    Optional<BasicConfig> findByEmail(String email);

    @Override
    long count();*/
}
