package com.example.service;

import com.example.model.Mail;

import java.util.List;

public interface MailService {

    List<Mail> listMail();

    List<String> languages();

    List<Integer> pageSizes();

    Mail findById(int id);

    void update(int id, Mail mail);
}
