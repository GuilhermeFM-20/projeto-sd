package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Activity;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByIdUser(Long idUser);
    List<Activity> findByNameAndIdUser(String name, Long idUser);
    List<Activity> findByNameLikeAndIdUser(String name, Long idUser);

}
