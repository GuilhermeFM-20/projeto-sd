package com.example.demo.service;

import com.example.demo.model.Meals;
import com.example.demo.model.Weight;
import com.example.demo.repository.MealsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class MealsService {

    @Autowired
    private MealsRepository mealsRepository;

    public ResponseEntity<Map<String, Object>> getAllMeals() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data",mealsRepository.findAll()));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> getAllMealsOfUser(Long id){
        try {
            System.out.println("ID DO USER:"+id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data",mealsRepository.findByIdUser(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro ao trazer os pesos desse usuário."));
        }
    }

    public ResponseEntity<Map<String, Object>> getMealsById(Long id) {
        try{
            
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data",mealsRepository.findById(id).orElse(null)));
        }catch(Exception e){
                    
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> saveMeals(Meals meals) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("msg", "Usuário cadastrado com sucesso",
                "data",mealsRepository.save(meals)
            ));
        }catch(Exception e){
                
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> updateMeals(Meals user,Long id) {
        try{

            Meals mealsLocalize = mealsRepository.findById(id).orElse(null);        
            mealsLocalize.setName(user.getName());
            mealsLocalize.setIdUser(user.getIdUser());
            mealsLocalize.setCalories(user.getCalories());
            mealsLocalize.setDate(user.getDate());
            mealsLocalize.setType(user.getType());
    
            return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("msg", "Usuário excluído com sucesso",
                "data",mealsRepository.save(mealsLocalize)
            ));
        }catch(Exception e){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> deleteMeals(Long id) {
        try{
            mealsRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Usuário excluído com sucesso"));
        }catch(Exception e){
                
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na exclusão."));
        }
    }

}
