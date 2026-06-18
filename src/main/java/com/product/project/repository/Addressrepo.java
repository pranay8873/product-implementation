package com.product.project.repository;

import com.product.project.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Addressrepo extends JpaRepository<Address, Long> {
}
