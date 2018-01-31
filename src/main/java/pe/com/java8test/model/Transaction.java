package pe.com.java8test.model;

/**
 * Created on 30/01/2018.
 *
 * @author Entelgy
 */
public class Transaction {
    private Merchant merchant;
    private Integer year;
    private Integer amount;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "merchant=" + merchant +
                ", year=" + year +
                ", amount=" + amount +
                '}';
    }
}
