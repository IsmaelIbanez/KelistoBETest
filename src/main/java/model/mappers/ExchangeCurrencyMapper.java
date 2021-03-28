package model.mappers;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class ExchangeCurrencyMapper {
    float exchangeRate;

    public void setExchangeRate(float newExchangeRate){
        this.exchangeRate = newExchangeRate;
    }

    public float toDao(StringBuffer response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map map = mapper.readValue(response.toString(), Map.class);
        String json = mapper.writeValueAsString(map.get("Realtime Currency Exchange Rate"));
        Map anotherMap = mapper.readValue(json, Map.class);
        String exchangeRateMapped = mapper.writeValueAsString(anotherMap.get("5. Exchange Rate"));
        exchangeRateMapped = exchangeRateMapped.replace('"', ' ');

        this.exchangeRate = Float.parseFloat(exchangeRateMapped);

        ExchangeCurrencyMapper updatedExchange = new ExchangeCurrencyMapper();
        updatedExchange.exchangeRate = exchangeRate;

        return (exchangeRate);

    }
}
