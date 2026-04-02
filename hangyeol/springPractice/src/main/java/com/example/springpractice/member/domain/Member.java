package com.example.springpractice.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
    private Long id; //맵버 식별 고유 id
    private String name; //맴버 이름
    private int age; //멤버 나이

    @Builder
    public Member(Long id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public void update(String name, int age){
        this.name=name;
        this.age=age;
    }
}
