package com.example.springpractice.member.api.dto;

import lombok.Builder;

@Builder
public record MemberDto(Long id, String name, int age) {
}
