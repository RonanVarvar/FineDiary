package com.FineDiary.service;

import com.FineDiary.entity.User;

public interface MailService {

    public void sendEmail(final  User user);
    public void sendRecoveryMail(User user);
}
