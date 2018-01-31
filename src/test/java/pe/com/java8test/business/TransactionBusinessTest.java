package pe.com.java8test.business;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pe.com.java8test.DummyMock;
import pe.com.java8test.model.Merchant;
import pe.com.java8test.model.Transaction;

import java.io.IOException;
import java.util.List;
import java.util.OptionalInt;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created on 30/01/2018.
 *
 * @author Entelgy
 */
public class TransactionBusinessTest {
    private TransactionBusiness transactionBusiness;
    private DummyMock dummyMock;

    @org.junit.Before
    public void init(){
        transactionBusiness = new TransactionBusiness();
        dummyMock = new DummyMock();
    }

    @Test
    public void transactionsOfTheYear2017AndOrderedFromLowestToHighestTest() throws IOException {
        List<Transaction> result = transactionBusiness.transactionsOfTheYear2017AndOrderedFromLowestToHighest(dummyMock.getFormatoFMMAC71List());
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(),2);
        Assert.assertEquals(result.toString(),"[Transaction{merchant=Merchant{name='Hector', city='Ventanilla'}, year=2017, amount=300}, Transaction{merchant=Merchant{name='Pedro', city='Chorrillos'}, year=2017, amount=400}]");
    }

    @Test
    public void citiesWhereMerchantsWorkTest() throws IOException {
        List<String> results = transactionBusiness.citiesWhereMerchantsWork(dummyMock.getFormatoFMMAC71List());
        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(),2);
        Assert.assertEquals(results.toString(),"[Ventanilla, Chorrillos]");
    }

    @Test
    public void searchMerchantsByCityAndSortedByNameTest() throws IOException{
        List<String> results = transactionBusiness.searchMerchantsByCityAndSortedByName("Ventanilla",dummyMock.getFormatoFMMAC71List());
        Assert.assertNotNull(results);
        Assert.assertEquals(results.toString(),"[Gloria, Hector, Miryan]");
    }

    @Test
    public void nameOfAllMerchantsSortedByNameTest() throws IOException {
        String results = transactionBusiness.nameOfAllMerchantsSortedByName(dummyMock.getFormatoFMMAC71List());
        Assert.assertNotNull(results);
        Assert.assertEquals(results,"Gloria,Hector,Miryan,Pedro");
    }

    @Test
    public void searchMerchantsByCityAndSortedByNameWithChorrilloTest() throws IOException{
        List<String> results = transactionBusiness.searchMerchantsByCityAndSortedByName("Chorrillos",dummyMock.getFormatoFMMAC71List());
        Assert.assertNotNull(results);
        Assert.assertEquals(results.toString(),"[Pedro]");
    }

    @Test
    public void listOfTransactionsByCityTest() throws IOException {
        List<Transaction> results = transactionBusiness.listOfTransactionsByCity("Ventanilla",dummyMock.getFormatoFMMAC71List());
        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(),4);
        Assert.assertEquals(results.toString(),"[Transaction{merchant=Merchant{name='Hector', city='Ventanilla'}, year=2017, amount=300}, Transaction{merchant=Merchant{name='Miryan', city='Ventanilla'}, year=2018, amount=710}, Transaction{merchant=Merchant{name='Miryan', city='Ventanilla'}, year=2018, amount=700}, Transaction{merchant=Merchant{name='Gloria', city='Ventanilla'}, year=2018, amount=950}]");
    }

    @Test
    public void lookForTheBiggestTransaction()throws IOException{
        OptionalInt greaterTransaction = transactionBusiness.lookForTheBiggestTransaction(dummyMock.getFormatoFMMAC71List());
        Assert.assertNotNull(greaterTransaction);
        Assert.assertEquals(greaterTransaction.getAsInt(),1000);
    }

    @Test
    public void lookForTheTransactionWithTheSmallestValueTest()throws IOException{
        String transactionResult = transactionBusiness.lookForTheTransactionWithTheSmallestValue(dummyMock.getFormatoFMMAC71List());
        Assert.assertNotNull(transactionResult);
        Assert.assertEquals(transactionResult,"Optional[Transaction{merchant=Merchant{name='Hector', city='Ventanilla'}, year=2017, amount=300}]");
    }
}
