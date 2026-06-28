package service;

import dto.CreateUserRequest;
import dto.CreateUserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import com.example.ex1.entity.User;
import dto.GetUserResponse;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponse save(CreateUserRequest request) {
        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getAddress()
        );
        User saveUser = userRepository.save(user);
        return new CreateUserResponse(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getEmail(),
                saveUser.getAddress()
                );
    }


}
