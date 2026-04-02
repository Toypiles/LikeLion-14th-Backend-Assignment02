package com.example.springpractice.member.api;

import com.example.springpractice.member.api.dto.MemberDto;
import com.example.springpractice.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void saveMember(@RequestBody MemberDto memberDto){
        memberService.saveMember(memberDto);
    }

    @GetMapping("/list")
    public List<MemberDto> findAllMember() {
        return memberService.findAllMember();
    }

    @GetMapping("/{id}")
    public MemberDto findMemberById(@PathVariable("id") Long id){
        return memberService.findMemberById(id);
    }

    @PatchMapping("/{id}")
    public MemberDto updateMemberById(@PathVariable("id") Long id, @RequestBody MemberDto memberDto){
        return memberService.updateMemberById(id, memberDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable("id") Long id){
        memberService.deleteMemberById(id);
    }
}
