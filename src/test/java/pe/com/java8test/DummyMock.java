package pe.com.java8test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pe.com.java8test.model.Transaction;

import java.io.IOException;
import java.util.List;

/**
 * Created on 30/01/2018.
 *
 * @author Entelgy
 */
public class DummyMock {
    private ObjectMapper objectMapper;
    public DummyMock() {
        objectMapper = new ObjectMapper();
    }

    public List<Transaction> getFormatoFMMAC71List() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("listTransactions.json"), new TypeReference<List<Transaction>>() {
        });
    }
}
