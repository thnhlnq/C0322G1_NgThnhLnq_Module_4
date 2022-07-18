package com.example.service.impl;

import com.example.model.Mail;
import com.example.repository.MailRepository;
import com.example.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    MailRepository mailRepository;

    @Override
    public List<Mail> listMail() {
        return mailRepository.listMail();
    }

    @Override
    public List<String> languages() {
        return mailRepository.languages();
    }

    @Override
    public List<Integer> pageSizes() {
        return mailRepository.pageSizes();
    }

    @Override
    public Mail findById(int id) {
        return mailRepository.findById(id);
    }

    @Override
    public void update(int id, Mail mail) {
        mailRepository.update(id, mail);
    }
}
