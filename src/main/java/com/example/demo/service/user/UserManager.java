package com.example.demo.service.user;

import com.example.demo.controller.user.request.CreateUserRequest;
import com.example.demo.controller.user.request.UpdateUserRequest;
import com.example.demo.controller.user.response.UserResponse;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.user.User;
import com.example.demo.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService mapperService;

    @Override
    public void create(CreateUserRequest userRequest) {

        User user =  mapperService.forRequest().map(userRequest, User.class);
        userRepository.save(user);

    }

    @Override
    public void update(UpdateUserRequest userRequest) {

        User existingUser = userRepository.findById(userRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı: " + userRequest.getId()));

        mapperService.forRequest().map(userRequest, existingUser);
        userRepository.save(existingUser);

    }

    @Override
    public UserResponse getById(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı: " + id));
        return mapperService.forResponse().map(user, UserResponse.class);

    }

    @Override
    public List<UserResponse> getAll() {

        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> mapperService.forResponse()
                .map(user, UserResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(int id) {

        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı: " + id));
        userRepository.deleteById(id);

    }
}
