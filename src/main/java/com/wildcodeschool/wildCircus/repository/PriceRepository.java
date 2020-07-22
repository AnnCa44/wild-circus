package com.wildcodeschool.wildCircus.repository;

import com.wildcodeschool.wildCircus.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository <Price, Long> {
}
