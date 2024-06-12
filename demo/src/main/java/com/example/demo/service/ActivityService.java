package com.example.demo.service;

import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public ResponseEntity<Map<String, Object>> getAllActivities() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", activityRepository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve um erro ao recuperar as atividades."));
        }
    }

    public ResponseEntity<Map<String, Object>> getActivityById(Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", activityRepository.findById(id).orElse(null)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve um erro ao recuperar a atividade."));
        }
    }

    public ResponseEntity<Map<String, Object>> saveActivity(Activity activity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    Map.of("msg", "Atividade salva com sucesso",
                            "data", activityRepository.save(activity)
                    ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve um erro ao salvar a atividade."));
        }
    }

    public ResponseEntity<Map<String, Object>> updateActivity(Activity activity, Long id) {
        try {
            Activity activityToUpdate = activityRepository.findById(id).orElse(null);
            if (activityToUpdate != null) {
                
                activityToUpdate.setName(activity.getName());
                activityToUpdate.setActivityType(activity.getActivityType());
                activityToUpdate.setDurationMinutes(activity.getDurationMinutes());
                activityToUpdate.setIntensityLevel(activity.getIntensityLevel());

                Activity updatedActivity = activityRepository.save(activityToUpdate);
                return ResponseEntity.status(HttpStatus.OK).body(
                        Map.of("msg", "Atividade atualizada com sucesso",
                                "data", updatedActivity
                        ));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("msg", "Atividade não encontrada"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve um erro ao atualizar a atividade."));
        }
    }

    public ResponseEntity<Map<String, Object>> deleteActivity(Long id) {
        try {
            if (activityRepository.existsById(id)) {
                activityRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Atividade deletada com sucesso"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("msg", "Atividade não encontrada"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Map.of("msg", "Houve um erro ao deletar a atividade."));
        }
    }
}
