package com.example.demo.service;

import com.example.demo.model.Weight;
import com.example.demo.repository.WeightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class WeightService {

    @Autowired
    private WeightRepository weightRepository;

    public ResponseEntity<Map<String, Object>> getAllWeights() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data",weightRepository.findAll()));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> getAllWeightsOfUser(Long id){
        try {
            System.out.println("ID DO USER:"+id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data",weightRepository.findByIdUser(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro ao trazer os pesos desse usuário."));
        }
    }

    public ResponseEntity<Map<String, Object>> getWeightById(Long id) {
        try{
            
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data",weightRepository.findById(id).orElse(null)));
        }catch(Exception e){
                    
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> saveWeight(Weight user) {
        try{

            System.out.println(user.getValue());

            return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("msg", "Usuário cadastrado com sucesso",
                "data",weightRepository.save(user)
            ));
        }catch(Exception e){
                
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> updateWeight(Weight user,Long id) {
        try{

            Weight weightLocalize = weightRepository.findById(id).orElse(null);        
            weightLocalize.setValue(user.getValue());
            weightLocalize.setIdUser(user.getIdUser());
            weightLocalize.setIdUser(user.getIdUser());
    
            return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("msg", "Peso ataulizado com sucesso",
                "data",weightRepository.save(weightLocalize)
            ));
        }catch(Exception e){

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> deleteWeight(Long id) {
        try{
            weightRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Peso excluído com sucesso"));
        }catch(Exception e){
                
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve algum erro na exclusão."));
        }
    }

}
