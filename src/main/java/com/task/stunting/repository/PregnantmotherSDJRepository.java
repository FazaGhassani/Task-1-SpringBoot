package com.task.stunting.repository;

import com.task.stunting.model.Pregnantmother;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PregnantmotherSDJRepository extends JpaRepository<Pregnantmother, Integer> {
    //custom query bisa di taro di sini
    Pregnantmother findPregnantmotherById(Integer id);
    //List<Pregnantmother> findAllByOrderByLastName();
    //Page<Pregnantmother> findAllByOrderByEmail(Pageable pageable);
}
