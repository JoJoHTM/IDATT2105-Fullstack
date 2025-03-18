package com.oving5.oving5.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.oving5.oving5.model.RegisterModel;
import com.auth0.jwt.algorithms.Algorithm;
import com.oving5.oving5.repository.DatabaseRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping(value = "/token")
@EnableAutoConfiguration
@CrossOrigin
public class TokenController {

    public static final String keyStr = "testsecrettestsecrettestsecrettestsecret";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(1);

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String generateToken(final @RequestBody RegisterModel loginRequest) throws Exception {
        // if username and password are valid, issue an access token
        // note that subsequent requests need this token
        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());
        if (DatabaseRepository.loginUser(loginRequest.getUsername(), loginRequest.getPassword()) != 0) {
            return generateToken(loginRequest.getUsername());
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access denied, wrong credentials....");
    }

    public String generateToken(final String userId) {
        final Instant now = Instant.now();
        final Algorithm hmac512 = Algorithm.HMAC512(keyStr);;
        final JWTVerifier verifier = JWT.require(hmac512).build();
        return JWT.create()
                .withSubject(userId)
                .withIssuer("idatt2105_token_issuer_app")
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
                .sign(hmac512);
    }

}
