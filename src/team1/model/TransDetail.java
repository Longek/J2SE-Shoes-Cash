package team1.model;

/**
 *
 * @author bayug
 */
public class TransDetail {
    private String id_trans;    // id transaksi
    private String id_product;  // id produk
    private int amount;         // banyak dibeli
    private int sub_capital;    // sub modal
    private int sub_total;      // sub total bayar
    private int is_free;        // (1 0) free atau tidak 

    public String getId_trans() {
        return id_trans;
    }

    public void setId_trans(String id_trans) {
        this.id_trans = id_trans;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSub_capital() {
        return sub_capital;
    }

    public void setSub_capital(int sub_capital) {
        this.sub_capital = sub_capital;
    }

    public int getSub_total() {
        return sub_total;
    }

    public void setSub_total(int sub_total) {
        this.sub_total = sub_total;
    }

    public int getIs_free() {
        return is_free;
    }

    public void setIs_free(int is_free) {
        this.is_free = is_free;
    }
}
