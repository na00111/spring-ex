package Controller;

import dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.save(request);
    }
    @GetMapping("/users/{userId}") //단 건 조회는 패스베리어블로 유저아이디를 받아와야 함.
    public GetOneUserResponse getOneUser(@PathVariable Long userId){
        return userService.getOne(userId); // 타입이 똑같아서 리턴 바로 해주기
    }
    @GetMapping("/uesrs")
    public List<GetOneUserResponse> getAllUsers(){
        //파라미터가 필요없다 -> 전체 조회라서
        return userService.getAll();
    }
    @PutMapping("/users/{userId}") //업데이트는 어떤 유저인지 알아야함.->pathvariable을 받아줘야 함
    public UpdateUserResponse update(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request) {//뭘 업데이트 할껀지 body로 받아줘야 함
       return userService.update(userId, request); //파라미터 ->userId, request
    }
}
