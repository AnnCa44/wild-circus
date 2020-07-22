package com.wildcodeschool.wildCircus.repository;

import com.wildcodeschool.wildCircus.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
}
