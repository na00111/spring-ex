package dto;

import lombok.Getter;

@Getter
public class UpdateUserResponse {
    //response니까 final 이다.
    private  final long id;
    private final String name;
    private final String email;
    private final String address;
//생성자 만들어 주기
    public UpdateUserResponse(long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
