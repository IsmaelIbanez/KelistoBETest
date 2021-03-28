package model;
import model.mappers.ExchangeCurrencyMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

            public class ExchangeCurrencyRepository {
                public float exchangeRatio;

                public ExchangeCurrencyRepository(String fromCurrency, String toCurrency) throws IOException {

                    String apiKey = "2Y66O6M6IAYZCWK6";
                    URL urlForGetRequest = new URL("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=" + fromCurrency + "&to_currency=" + toCurrency + "&apikey=" + apiKey);
                    requestToApi(urlForGetRequest);
                 }

                private void requestToApi(URL urlForGetRequest) throws IOException {

                    ExchangeCurrencyMapper exchangeCurrencyMapper = new ExchangeCurrencyMapper();
                    String readLine = null;
                    HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
                    connection.setRequestMethod("GET");
                    int responseCode = connection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
                        StringBuffer response = new StringBuffer();
                        while ((readLine = in .readLine()) != null) {
                            response.append(readLine);
                        } in .close();

                        exchangeRatio = exchangeCurrencyMapper.toDao(response);

                    } else {
                        System.out.println("GET NOT WORKED" + responseCode);
                        exchangeRatio = 0;
                    }
                }

            }
