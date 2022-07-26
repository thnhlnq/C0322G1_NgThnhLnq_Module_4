package com.example.repository.impl;

import com.example.model.Mail;
import com.example.repository.MailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepositoryImpl implements MailRepository {

    static List<Mail> mails = new ArrayList<>();

    static List<String> languages = new ArrayList<>();

    static List<Integer> pageSizes = new ArrayList<>();

    static {
        mails.add(new Mail(1, "English", 5, true, "King, Asgard"));
        mails.add(new Mail(2, "Vietnamese", 10, false, "King"));
        mails.add(new Mail(3, "Japanese", 50, true, "Asgard"));
    }

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
    }

    static {
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
    }

    @Override
    public List<Mail> listMail() {
        return mails;
    }

    @Override
    public List<String> languages() {
        return languages;
    }

    @Override
    public List<Integer> pageSizes() {
        return pageSizes;
    }

    @Override
    public Mail findById(int id) {
        Mail mail = null;
        for (Mail item : mails) {
            if (item.getId() == id) {
                mail = new Mail(item.getId(), item.getLanguage(), item.getPageSize(), item.getSpamFilter(), item.getSignature());
            }
        }
        return mail;
    }

    @Override
    public void update(int id, Mail mail) {
        for (Mail item : mails) {
            if (mail.getId() == item.getId()) {
                item.setLanguage(mail.getLanguage());
                item.setPageSize(mail.getPageSize());
                item.setSpamFilter(mail.getSpamFilter());
                item.setSignature(mail.getSignature());
            }
        }
    }
}
