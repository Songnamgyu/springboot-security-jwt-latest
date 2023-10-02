package com.song.studycafe.songka.controller;

import com.song.studycafe.songka.dto.MemberRequestDto;
import com.song.studycafe.songka.dto.MemberResponseDto;
import com.song.studycafe.songka.dto.TokenDto;
import com.song.studycafe.songka.entity.Member;
import com.song.studycafe.songka.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/test")
    public String test() {
        return "test success";
    }
    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.signUp(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }
}
