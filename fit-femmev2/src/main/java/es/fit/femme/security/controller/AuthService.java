package es.fit.femme.security.controller;

import es.fit.femme.security.jwt.JwtService;
import es.fit.femme.security.user.Role;
import es.fit.femme.security.user.User;
import es.fit.femme.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;




    public AuthResponse login (LoginRequest request) {
        return null;
    }

    public AuthResponse register (RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
