package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Map<String, Object>> getAllUsers() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data",userRepository.findAll()));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> getUserById(Long id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data",userRepository.findById(id).orElse(null)));
        }catch(Exception e){
                    
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> saveUser(User user) {
        try{
            System.out.println(user.getEmail()+", "+user.getPassword());
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));

            System.out.println(user.getPassword());

            return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("msg", "Usuário cadastrado com sucesso",
                "data",userRepository.save(user)
            ));
        }catch(Exception e){
                
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> updateUser(User user,Long id) {
        try{
            User userLocalize = userRepository.findById(id).orElse(null);        
            userLocalize.setName(user.getName());
            userLocalize.setUserName(user.getUserName());
            userLocalize.setBirthDate(user.getBirthDate());
            userLocalize.setEmail(user.getEmail());
            userLocalize.setGender(user.getGender());
            userLocalize.setHeight(user.getHeight());
            
            if(!user.getPassword().isEmpty()){
                userLocalize.setPassword(DigestUtils.md5Hex(user.getPassword()));
            }

            return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("msg", "Usuário atualizado com sucesso",
                "data",userRepository.save(userLocalize)
            ));
        }catch(Exception e){

            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Houve algum erro na atualização."));
        }
    }

    public ResponseEntity<Map<String, Object>> deleteUser(Long id) {
        try{
            userRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Usuário ataulizado com sucesso"));
        }catch(Exception e){
                
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Houve algum erro na ataulização."));
        }
    }

    public ResponseEntity<Map<String, Object>> loginApp(User user){
        
        try{

            System.out.println(user.getEmail()+", "+user.getPassword());
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));

            System.out.println(user.getPassword());

            User userLocalize = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

            if(userLocalize != null){
                return ResponseEntity.status(HttpStatus.OK).body(Map.of("status",true,"data",userLocalize));
            }

            return ResponseEntity.status(HttpStatus.OK).body(Map.of("status",false,"msg", "Senha ou login inválido"));
        }catch(Exception e){
                
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("msg", "Houve algum erro no login."));
        }
    }

}
