package dto;

import jakarta.transaction.Transactional;
import lombok.Getter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CreateUserResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final String address;

    public CreateUserResponse(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    }
@Getter
public class GetUserResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final String address;

    public GetUserResponse(Long id ,String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
@Transactional(readOnly = true)
public List<GetUserResponse> getAll() {
    List<com.example.ex1.entity.User> users = userRepository.findAll();
    List<GetUserResponse> dtos = new ArrayList<>();

    for (com.example.ex1.entity.User user : users) {
        GetUserResponse dto = new GetUserResponse(
                user.getId(), user.getName(), user.getEmail(), user.getAddress()
        );
        dtos.add(dto);
    }
    return dtos;
}


