package com.example.service.impl;

import com.example.service.ISpiceSandwichService;
import org.springframework.stereotype.Service;

@Service
public class SpiceSandwichService implements ISpiceSandwichService {

    public String save(String[] condiment) {

        String sandwich = "";

        if (condiment.length == 0) {
            return "Don't!";
        } else {
            for (String item : condiment) {
                sandwich += item + " ";
            }
        }
        return sandwich;
    }
}
