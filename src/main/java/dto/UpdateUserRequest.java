package dto;

import lombok.Getter;

@Getter
public class UpdateUserRequest {
//    private Long id -> DB에서 생성해주는거니까 request에 넣은면 안됨
    private String name;
    private String email;
    private String address;
}
