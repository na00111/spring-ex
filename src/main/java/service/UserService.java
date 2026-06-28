package service;

import dto.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import com.example.ex1.entity.User;

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
    //단 건 조회
@Transactional(readOnly = true)
    public GetOneUserResponse getOne(Long userId) {
    User user = userRepository.findById(userId).orElseThrow(// 가져오기 ,null 이면 던질게
    () -> new IllegalStateException("없는 유저입니다.")
);
   return  new GetOneUserResponse(
           user.getId(),
           user.getName(),
           user.getEmail(),
           user.getAddress()
    );
    }
    //다 건 조회
    @Transactional(readOnly = true)
    public  List<GetOneUserResponse> getAll() {
        List<User> users = userRepository.findAll();

        List<GetOneUserResponse> dtos = new ArrayList<>();
        for (User user : users) {
            GetOneUserResponse dto = new GetOneUserResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAddress()
            );
            dtos.add(dto);
        }
        return dtos;
        //컨트롤러가 엔티티를 알면 안됨
    }
    //업데이트 만들기, readOnly 아님
    @Transactional
    public UpdateUserResponse update() {
        //dto로 받아야함 -> 어떤걸 업데이트 할지 모르니
        public UpdateUserResponse update(Long userId ,UpdateUserRequest request) {
            //업데이트 할땐 더티 체킹을 쓴다.->트랜잭셔널 안에서 데이터 베이스를 갖다 온 영속성 , 영속 객체를 자동으로 업데이트 해주는 로직
            User user = userRepository.findById(userId).orElseThrow(// 가져오기 ,null 이면 던질게
                    () -> new IllegalStateException("없는 유저입니다.")
            );
            user.update(
                    request.getName(),
                    request.getEmail(),
                    request.getAddress(),
            );
            return new UpdateUserResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAddress()
            );
        }
        //delete
        @Transactional
        //delete 이기 때문에 딱히 리턴 안해도됨.
                public
    }

}
