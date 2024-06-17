package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Meals;
import com.example.demo.model.Weight;

@Repository
public interface MealsRepository extends JpaRepository<Meals, Long> {
    List<Meals> findByIdUser(Long idUser);
}
