package com.FineDiary.service;

import com.FineDiary.entity.Token;
import com.FineDiary.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.FineDiary.global.Constants.ADMIN;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token findByToken(String token) {
        return null;
    }

    @Override
    public Token create(Token token) {
        return null;
    }

    @Override
    public void delete(String token) {

    }

    @Override
    public Token findByUserPasswordHash(String userPassHash) {
        return null;
    }

    @Override
    public boolean authCheck(String authTokenToCheck) {
    Token token = tokenRepository.findByToken(authTokenToCheck);
    if (token.getUser().getRole().equals(ADMIN)) return true;
    else {
        if ((System.currentTimeMillis() - token.getTokenCreateDate().getTime()) >= 8.64e7) {
            return false;
        } else return true;
    }
    }
}
