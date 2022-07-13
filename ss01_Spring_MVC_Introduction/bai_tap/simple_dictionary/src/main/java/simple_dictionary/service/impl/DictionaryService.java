package simple_dictionary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple_dictionary.repository.IDictionaryRepository;
import simple_dictionary.service.IDictionaryService;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    IDictionaryRepository dictionaryRepository;

    @Override
    public String dictionary(String word) {
        String search = dictionaryRepository.dictionary().get(word);

        if (search != null) {
            return search;
        } else {
            return "Not Found !";
        }
    }
}
