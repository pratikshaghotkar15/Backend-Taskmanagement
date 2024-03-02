package com.pratiit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratiit.entity.Mytask;

@Repository
public interface MyTaskRepo extends JpaRepository<Mytask, Integer>{

}
