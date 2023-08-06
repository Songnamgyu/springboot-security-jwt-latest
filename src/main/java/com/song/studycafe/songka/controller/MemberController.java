package com.song.studycafe.songka.controller;

import com.song.studycafe.songka.dto.ChangePasswordRequestDto;
import com.song.studycafe.songka.dto.MemberRequestDto;
import com.song.studycafe.songka.dto.MemberResponseDto;
import com.song.studycafe.songka.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        MemberResponseDto myInfoBySecurity = memberService.getMyInfoBySecurity();
        System.out.println("myInfoBySecurity.getNickName() = " + myInfoBySecurity.getNickName());
        return ResponseEntity.ok(myInfoBySecurity);
    }

    @PostMapping("/nickname")
    public ResponseEntity<MemberResponseDto> changeMemberNickname(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(memberService.changeMemberNickname(requestDto.getEmail(), requestDto.getNickname()));
    }

    @PostMapping("/password")
    public ResponseEntity<MemberResponseDto> changePassword(@RequestBody ChangePasswordRequestDto requestDto) {
        return ResponseEntity.ok(memberService.changeMemberPassword(requestDto.getEmail(),requestDto.getExPassword(), requestDto.getNewPassword()));
    }
}
