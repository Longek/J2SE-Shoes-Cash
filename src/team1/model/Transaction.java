package team1.model;

/**
 *
 * @author bayug
 */
public class Transaction {
    private String id;          // id Transaksi
    private String datetime;    // tanggal dan waktu
    private int tot_sold;       // total produk yang dibeli
    private String promo;       // id promo, null kalau tidak ada
    private String discount;    // harga diskon
    private String tot_capital; // total modal
    private String pay;         // total bayar

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getTot_sold() {
        return tot_sold;
    }

    public void setTot_sold(int tot_sold) {
        this.tot_sold = tot_sold;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTot_capital() {
        return tot_capital;
    }

    public void setTot_capital(String tot_capital) {
        this.tot_capital = tot_capital;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
