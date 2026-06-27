package com.example.ex1.entity;
//자바 객체를 데이터베이스의 테이블과 연결하는 역할
//자바ㅏ 객체(User) 와 MySQL 테이블(users)을 똑같은 모양으로 연결(mapping)하는 것
//-> ORM(object-relational mapping)
//머리부분( 클레스 레벨 어노테이션) : 이 클래스의 정체성을 정의하는 곳(jpa용이다. 롬복용이다 선언)
//몸통부분(필드 변수) : DB테이블의 세로줄(컬럼)이 될 변수들을 정의하는 곳
//끝부분(생성자와 메서드) : 데이터를 처음 넣을 때 (생성자) , 수정할 때(update 메서드) 쓰는 행동을 정의하는 곳

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private  String address;
    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
    public void update(String name,String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
