package pe.com.java8test.business;

import pe.com.java8test.model.Merchant;
import pe.com.java8test.model.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * Created on 30/01/2018.
 *
 * @author Entelgy
 */
public class TransactionBusiness {
    /**
     * Metodo que filtra transacciones del año 2017 y ordenadas de menor a mayor
     * @param inputLisTransaction listado de transacciones
     * @return {@link List<Transaction>}
     */
    public List<Transaction> transactionsOfTheYear2017AndOrderedFromLowestToHighest(List<Transaction> inputLisTransaction){
        List<Transaction> results = inputLisTransaction.stream()
                .filter(t -> t.getYear()==2017)
                .map(transaction -> transaction)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .collect(Collectors.toList());
        return results;
    }

    /**
     * Método  que devuelve las ciudades donde trabajan los comerciantes
     * @param inputListTransaction listado de transacciones
     * @return {@link List<Transaction>}
     */
    public List<String> citiesWhereMerchantsWork(List<Transaction> inputListTransaction){
        List<String> results = inputListTransaction.stream()
                .map(transaction -> transaction.getMerchant().getCity())
                .distinct().collect(Collectors.toList());
        return results;
    }

    /**
     * Metodo que devuelve un listado de comerciantes filtrados por ciudad y ordenados por nombre
     * @param city ciudad por el cual se realiza el filtro
     * @param inputListTransaction listado de Tx
     * @return {@link List<String>}
     */
    public List<String> searchMerchantsByCityAndSortedByName(String city,List<Transaction> inputListTransaction){
        List<String> results = inputListTransaction.stream()
                .filter(transaction -> city.equalsIgnoreCase(transaction.getMerchant().getCity()))
                .map(transaction -> transaction.getMerchant().getName())
                .sorted(String::compareTo).distinct().collect(Collectors.toList());
        return results;
    }

    /**
     *  Metodo que devuelve una cadena con todos los nombres de los comerciantes ordenados por nombre
     * @param inpuTransactionList listado de Tx
     * @return {@link String}
     */
    public String nameOfAllMerchantsSortedByName(List<Transaction> inpuTransactionList){
        StringBuffer namesMerchant = new StringBuffer();
        String names = inpuTransactionList.stream()
                .map(transaction ->  transaction.getMerchant().getName()).sorted(String::compareTo).distinct()
                .collect(Collectors.joining(","));
        return names;
    }

    /**
     * Metodo que devuelve un listado de tx filtrados por una ciudad dada
     * @param city ciudad por la cual se realiza el filtro
     * @param inputTransactionList listado de Tx
     * @return {@link List<Transaction>}
     */
    public List<Transaction> listOfTransactionsByCity(String city, List<Transaction> inputTransactionList){
        List<Transaction> results = inputTransactionList.stream()
                .filter(transaction -> city.equalsIgnoreCase(transaction.getMerchant().getCity()))
                .map(transaction -> {
                    System.out.println(transaction.toString());
                    return transaction;
                }).collect(Collectors.toList());
        return results;
    }

    /**
     * Metodo que trae el valor de la mayor Tx realizada
     * @param inputTransactionList listado de Tx
     * @return {@link OptionalInt}
     */
    public OptionalInt lookForTheBiggestTransaction(List<Transaction> inputTransactionList){
        OptionalInt result = inputTransactionList.stream().mapToInt(Transaction::getAmount).max();
        return result;
    }

    /**
     * Metodo que busca la tranaccion con menor valor
     * @param inputTransactionList listado de Tx
     * @return {@link String}
     */
    public String lookForTheTransactionWithTheSmallestValue(List<Transaction> inputTransactionList){
        String transaction = inputTransactionList.stream().min(Comparator.comparing(Transaction::getAmount)).toString();
        return transaction;
    }

}
