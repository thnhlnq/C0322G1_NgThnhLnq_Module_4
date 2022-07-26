package currency_converter.service.impl;

import currency_converter.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {

    @Override
    public double currencyConvert(double rate, double usd) {
        return rate * usd;
    }
}
