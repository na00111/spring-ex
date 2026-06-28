package dto;

import lombok.Getter;

@Getter
public class GetOneUserResponse {
    //response니까 final 붙여줘야함
    private final Long id;
    private final String name;
    private final String email;
    private final String address;
//생성자를 만들어주기
    public GetOneUserResponse(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
