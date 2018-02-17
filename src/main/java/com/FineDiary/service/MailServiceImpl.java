package com.FineDiary.service;

import com.FineDiary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail( User user) {

        MimeMessagePreparator preparator = getMessagePreparator(user);
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void sendRecoveryMail(User user){
        MimeMessagePreparator preparator = getMessagePreparatorRecovery(user);
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }

    }


    private MimeMessagePreparator getMessagePreparator(final User user) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom();
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(user.getEmail()));
                mimeMessage.setText("Дорогой " + user.getName()
                        + ", вы были успешно зарегестрированы на сервисе FineDiary! ");
                mimeMessage.setSubject("С Любовью, Ваш Hillel");
            }
        };
        return preparator;
    }

    private MimeMessagePreparator getMessagePreparatorRecovery(final User user) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom();
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(user.getEmail()));
                mimeMessage.setText("Дорогой " + user.getName()
                        + ", ваш новый пароль: " + user.getPasswordDecoded()+"\n");
                mimeMessage.setSubject("С Любовью, Ваш FineDiary");
            }
        };
        return preparator;
    }

}
