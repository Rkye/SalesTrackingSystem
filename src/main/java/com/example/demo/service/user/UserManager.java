package com.example.demo.service.user;

import com.example.demo.controller.user.response.UserResponse;
import com.example.demo.core.exception.NotFoundException;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.user.User;
import com.example.demo.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.core.exception.type.NotFoundExceptionType.USER_DATA_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService mapperService;

    @Override
    public UserResponse getById(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(USER_DATA_NOT_FOUND));
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

        userRepository.findById(id).orElseThrow(() -> new NotFoundException(USER_DATA_NOT_FOUND));
        userRepository.deleteById(id);

    }
}
