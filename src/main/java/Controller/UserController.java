package Controller;

import dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    //ResponseEntity.status(HttpStatus.상태).body(응답데이터);   ->리턴해주고 싶은 상태 코드에 .body하고
    //원래 리턴해주고 싶은 응답 데이터를 넣어준다
    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
       CreateUserResponse result = userService.save(request);
       return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/users/{userId}") //단 건 조회는 패스베리어블로 유저아이디를 받아와야 함.
    public ResponseEntity<GetOneUserResponse> getOneUser(@PathVariable Long userId){
      GetOneUserResponse  result = userService.getOne(userId); // 타입이 똑같아서 리턴 바로 해주기
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/uesrs")
    public ResponseEntity<List<GetOneUserResponse>>getAllUsers(){
        //파라미터가 필요없다 -> 전체 조회라서
       List<GetOneUserResponse> result =  userService.getAll();
       return ResponseEntity.status(HttpStatus.OK).body(result);

    }
    @PutMapping("/users/{userId}") //업데이트는 어떤 유저인지 알아야함.->pathvariable을 받아줘야 함
    public ResponseEntity<UpdateUserResponse> update(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request) {//뭘 업데이트 할껀지 body로 받아줘야 함
     UpdateUserResponse result = userService.update(userId, request); //파라미터 ->userId, request
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/users/{userId}")
    public  ResponseEntity<Void>delete(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //body가 없기 때문에 빌드릃 함.
    }
}
