package com.FineDiary.service;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;
import com.FineDiary.entity.User;

public interface MailService {

    public void sendEmail(final  User user);
    public void sendRecoveryMail(User user);
    public void sendRecoveryMail(Students student);
    public void sendEmail(final Students students);
    public void sendRecoveryMail(Teacher teacher);
    public void sendEmail(final Teacher teacher);
}
