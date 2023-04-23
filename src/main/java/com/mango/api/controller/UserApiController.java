package com.mango.api.controller;

import com.mango.api.dto.UserDTO;
import com.mango.api.entities.GroupRole;
import com.mango.api.entities.User;
import com.mango.api.model.ShellType;
import com.mango.api.services.TokenManagerService;
import com.mango.api.services.UserService;
import com.mango.api.web.request.LoginRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Tag(name = "Account", description = "The Account API")
@RestController
@RequestMapping("/api/account")
public class UserApiController {

    private final UserService userService;
    private final TokenManagerService tokenManagerService;
    private final DefaultPasswordService passwordservice;


    public UserApiController(UserService userService, TokenManagerService tokenManagerService, DefaultPasswordService passwordservice) {
        this.userService = userService;
        this.tokenManagerService = tokenManagerService;
        this.passwordservice = passwordservice;
    }

    @Operation(summary = "Authenticate account by username and password", description = "Returns a single object containing token.", tags = { "Account" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = LoginRequest.class)))
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest userRequest){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userRequest.getUsername(), userRequest.getPassword());
        subject.login(usernamePasswordToken);
       Map<String,Object> authInfo = new HashMap<>() {{
           put("token", tokenManagerService.createTokenForUser(userRequest.getUsername()));
       }};
       return ResponseEntity.ok(authInfo);
    }

    @Operation(summary = "Register account by UserDto", description = "Returns a single user object containing the created user.", tags = { "Account" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = UserDTO.class)))
    })
    @PostMapping("/register")
    public User register(@RequestBody UserDTO dto){

        User user= User.builder()
                .username(dto.getUsername()).email(dto.getEmail())
                // .firstName(dto.getFirstName()).lastName(dto.getLastName())
                // .nickname(dto.getNickname()).mobile(dto.getMobile())
                .password(passwordservice.encryptPassword(dto.getPassword()))
                .enabled(true).roles(dto.getGroupRoles().stream().map(r -> copyToGroupRoleEntity(r.getCode())).filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .build();

        return userService.save(user);
    }

   // @RequiresPermissions("document:read")
//    @GetMapping("/user")
//    public ResponseEntity<List<UserDTO>> getAll() {
//        List<UserDTO> list = userService.getUsers().stream().map(this::copyUserEntityToDto).collect(Collectors.toList());
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }



    private UserDTO copyUserEntityToDto(User userEntity) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userEntity, userDTO);
        return userDTO;
    }

    private GroupRole copyToGroupRoleEntity(String roleCode) {
        GroupRole groupRole = new GroupRole();

        Optional<GroupRole> roleOptional = userService.getGroupRoleByCode(roleCode);
        if(roleOptional.isPresent()){
            BeanUtils.copyProperties(roleOptional.get(), groupRole);
            return groupRole;
        }
        return null;
    }
}
