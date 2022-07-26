package simple_dictionary.repository.impl;

import org.springframework.stereotype.Repository;
import simple_dictionary.repository.IDictionaryRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    static Map<String, String> map = new HashMap<>();

    static {
        map.put("hello", "Xin chào");
        map.put("how", "Thế nào");
        map.put("book", "Quyển vở");
        map.put("computer", "Máy tính");
    }

    @Override
    public Map<String, String> dictionary() {
        return map;
    }
}
