package com.wildcodeschool.wildCircus.repository;

import com.wildcodeschool.wildCircus.entity.Timerange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimerangeRepository extends JpaRepository <Timerange, Long> {
}
