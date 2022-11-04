package com.example.demo.web;

import com.example.demo.dataTransferObject.UserDTO;
import com.example.demo.facade.UserFacade;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import com.example.demo.validations.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserFacade userFacade;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;

    @GetMapping("/")
    public ResponseEntity<UserDTO> getCurrentUser(Principal principal) {
        return new ResponseEntity<>(userFacade.userToUserDTO(userService.getCurrentUser(principal)),
                HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(userFacade.userToUserDTO(userService.getUserById(Long.parseLong(userId))),
                HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult, Principal principal) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;

        return new ResponseEntity<>(userFacade.userToUserDTO(userService.updateUser(userDTO, principal)),
                HttpStatus.OK);
    }
}
