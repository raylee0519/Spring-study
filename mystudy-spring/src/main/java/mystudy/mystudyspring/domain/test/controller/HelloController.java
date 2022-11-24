package mystudy.mystudyspring.domain.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import mystudy.mystudyspring.domain.test.dto.request.HelloRequestDto;
import mystudy.mystudyspring.domain.test.dto.response.HelloResponseDto;

@RestController
@RequestMapping("/api/v1/hello")
@RequiredArgsConstructor
public class HelloController {
    @GetMapping
    public ResponseEntity<HelloResponseDto> get() {

        HelloResponseDto response = HelloResponseDto.builder()
                .value("hello")
                .success(true)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping
    public ResponseEntity<HelloResponseDto> create(@Validated @RequestBody HelloRequestDto dto) {

        HelloResponseDto response = HelloResponseDto.builder()
                .value("hello " + dto.getStringValue() + dto.getIntValue())
                .success(true)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }
}
