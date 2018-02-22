package com.FineDiary.service;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;
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
    public void sendEmail(User user) {

        MimeMessagePreparator preparator = getMessagePreparator(user);
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void sendEmail(Teacher teacher) {

        MimeMessagePreparator preparator = getMessagePreparator(teacher);
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void sendRecoveryMail(User user) {
        MimeMessagePreparator preparator = getMessagePreparatorRecovery(user);
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void sendRecoveryMail(Students student) {
        MimeMessagePreparator preparator = getMessagePreparatorRecovery(student);
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void sendEmail(Students student) {
        MimeMessagePreparator preparator = getMessagePreparator(student);
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }


    @Override
    public void sendRecoveryMail(Teacher teacher) {
        MimeMessagePreparator preparator = getMessagePreparatorRecovery(teacher);
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
    private MimeMessagePreparator getMessagePreparator(final Teacher teacher) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom();
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(teacher.getEmail()));
                mimeMessage.setText("Дорогой " + teacher.getName()
                        + ", вы были успешно зарегестрированы на сервисе FineDiary! ");
                mimeMessage.setSubject("С Любовью, Ваш Hillel");
            }
        };
        return preparator;
    }
    private MimeMessagePreparator getMessagePreparator(final Students student) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom();
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(student.getEmail()));
                mimeMessage.setText("Дорогой " + student.getName()
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
                        + ", ваш новый пароль: " + user.getPasswordDecoded() + "\n");
                mimeMessage.setSubject("С Любовью, Ваш FineDiary");
            }
        };
        return preparator;
    }

    private MimeMessagePreparator getMessagePreparatorRecovery(final Teacher teacher) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom();
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(teacher.getEmail()));
                mimeMessage.setText("Дорогой " + teacher.getName()
                        + ", ваш новый пароль: " + teacher.getPasswordDecoded() + "\n");
                mimeMessage.setSubject("С Любовью, Ваш FineDiary");
            }
        };
        return preparator;
    }

    private MimeMessagePreparator getMessagePreparatorRecovery(final Students student) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom();
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(student.getEmail()));
                mimeMessage.setText("Дорогой " + student.getName()
                        + ", ваш новый пароль: " + student.getPasswordDecoded() + "\n");
                mimeMessage.setSubject("С Любовью, Ваш FineDiary");
            }
        };
        return preparator;


    }
}
