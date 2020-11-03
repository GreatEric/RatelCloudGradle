package com.ratel.codegenerator.repositories;

import com.ratel.codegenerator.entities.DBConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBConnectionRepository extends JpaRepository<DBConnection, Long> {
    /*Optional<BasicConfig> findByEmailOrPhone(String email, String phone);

    Optional<BasicConfig> findByPhone(String phone);

    Optional<BasicConfig> findByEmail(String email);

    @Override
    long count();*/

    DBConnection findBySchemaName(String schemaName);//findAllBySchemaNameDbConnections
}
