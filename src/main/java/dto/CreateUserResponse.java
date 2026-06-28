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

}


