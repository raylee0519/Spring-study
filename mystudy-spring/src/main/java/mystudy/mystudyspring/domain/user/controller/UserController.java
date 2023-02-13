package mystudy.mystudyspring.domain.user.controller;

import mystudy.mystudyspring.domain.user.domain.UserData;
import mystudy.mystudyspring.domain.user.dto.mapper.UserDataMapper;
import mystudy.mystudyspring.domain.user.dto.request.UserDataCreateRequestDto;
import mystudy.mystudyspring.domain.user.dto.request.UserDataUpdateRequestDto;
import mystudy.mystudyspring.domain.user.dto.response.UserDataResponseDto;
import mystudy.mystudyspring.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserDataMapper mapper;

    @PostMapping
    public ResponseEntity<UserDataResponseDto> create(
            @Valid @RequestBody UserDataCreateRequestDto dto
    ){
        UserData entity = service.create(dto);
        UserDataResponseDto response = mapper.toResponseDto(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDataResponseDto> getOne(@PathVariable UUID id) {
        return ResponseEntity
                .ok(mapper.toResponseDto(service.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDataResponseDto> update(
            @Valid @RequestBody UserDataUpdateRequestDto dto
    ) {
        return ResponseEntity
                .ok(mapper.toResponseDto(service.update(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
