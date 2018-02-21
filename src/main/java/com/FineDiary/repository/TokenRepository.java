package com.FineDiary.repository;

import com.FineDiary.entity.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TokenRepository  extends CrudRepository<Token , Integer>{
    Token findByToken(String token);
    @Transactional
    void deleteByToken(String token);
    Token findByUserPlusPassHash(String usrPassHash);
}
