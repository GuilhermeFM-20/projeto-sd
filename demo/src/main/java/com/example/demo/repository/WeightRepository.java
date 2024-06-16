package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Weight;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
    List<Weight> findByIdUser(Long idUser);
}
