package cl.cpim.prueba.service;

import cl.cpim.prueba.entity.User;
import cl.cpim.prueba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) throws Exception {
        // Verificar si el correo ya está registrado
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("El correo ya registrado");
        }

        // Configurar datos del usuario
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setToken(UUID.randomUUID().toString());
        user.setActive(true);

        return userRepository.save(user);
    }

}
