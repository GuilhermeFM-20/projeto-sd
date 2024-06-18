package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Meals;

@Repository
public interface MealsRepository extends JpaRepository<Meals, Long> {
    List<Meals> findByIdUser(Long idUser);
    List<Meals> findByNameAndIdUser(String name, Long idUser);
    List<Meals> findByNameLikeAndIdUser(String name, Long idUser);
}
