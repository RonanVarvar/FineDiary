package com.FineDiary.service;

import com.FineDiary.entity.Token;

public interface TokenService {
    Token findByToken(String token);
    Token create(Token token);
    void delete(String token);
    Token findByUserPasswordHash(String userPassHash);
    boolean authCheck(String authTokenToCheck);

}
