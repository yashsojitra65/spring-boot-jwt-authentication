package com.irojas.demojwt.Repository;

import java.util.Optional;

import com.irojas.demojwt.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);
}
