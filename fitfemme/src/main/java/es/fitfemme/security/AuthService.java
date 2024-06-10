package es.fitfemme.security;

import es.fitfemme.security.jwt.AuthResponse;
import es.fitfemme.security.jwt.JwtService;
import es.fitfemme.security.jwt.LoginRequest;
import es.fitfemme.security.jwt.RegisterRequest;
import es.fitfemme.security.user.Role;
import es.fitfemme.security.user.User;
import es.fitfemme.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse login (LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token= jwtService.getToken(user);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        return authResponse;
    }

    public AuthResponse register (RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setCountry(request.getCountry());
        user.setRole(Role.USER);
        userRepository.save(user);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.getToken(user));
        return authResponse;
    }
}
