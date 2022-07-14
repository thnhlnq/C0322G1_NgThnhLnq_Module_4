package simple_dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import simple_dictionary.service.IDictionaryService;

@Controller
public class DictionaryController {

    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/translate")
    public String formTranslate() {
        return "translate";
    }

    @PostMapping("/translate")
    public String simpleDictionary(@RequestParam String word, Model model) {
        String result = dictionaryService.dictionary(word);
        model.addAttribute("result", result);
        return "translate";
    }
}
