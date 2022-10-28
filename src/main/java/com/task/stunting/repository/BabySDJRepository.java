package com.task.stunting.repository;

import com.task.stunting.model.Baby;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BabySDJRepository extends JpaRepository<Baby, Integer> {
    //custom query bisa di taro di sini
    Baby findBabyById(Integer id);
    //List<Baby> findAllByOrderByLastName();
    //Page<Baby> findAllByOrderByEmail(Pageable pageable);
}
