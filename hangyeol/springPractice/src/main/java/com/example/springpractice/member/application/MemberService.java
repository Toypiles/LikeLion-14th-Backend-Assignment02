package com.example.springpractice.member.application;

import com.example.springpractice.member.api.dto.MemberDto;
import com.example.springpractice.member.domain.Member;
import com.example.springpractice.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private static Long sequence = 0L;

    //멤버 저장
    public void saveMember(MemberDto memberDto) {
        //빌더 패턴 사용
        Member member = Member.builder()
                .id(++sequence)
                .name(memberDto.name())
                .age(memberDto.age())
                .build();

        memberRepository.save(member);
    }
        //멥버 id로 조회
        public MemberDto findMemberById(Long id){
            Member member = memberRepository.findById(id);
            if(member == null){
                throw new IllegalArgumentException("해당하는 멤버가 없습니다. id = "+id);
            }
            return toMemberDto(member);
        }

        //멤버 List 조회
        public List<MemberDto> findAllMember(){
            return memberRepository.findAll().stream().map(this::toMemberDto).toList();
        }

        //멤버 업데이트
        public MemberDto updateMemberById(Long id, MemberDto memberDto){
            Member member = memberRepository.findById(id);
            member.update(memberDto.name(), memberDto.age());
            return toMemberDto(member);
        }

        //멤버 삭제
        public void deleteMemberById(Long id){
            memberRepository.deleteById(id);
        }

        //dto 변환 메서드
        private MemberDto toMemberDto(Member member){
            return MemberDto.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .age(member.getAge())
                    .build();
        }

}
