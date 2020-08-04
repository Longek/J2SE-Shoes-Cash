package team1.model;

/**
 *
 * @author bayug
 */
public class Profit {
    private int no;                     // nomor
    private String date;                // tanggal
    private int trans_today;            // banyak transaksi hari itu
    private int trans_total;            // banyak transaksi dari awal
    private int sold_today;             // banyak sepatu terjual hari itu
    private int sold_total;             // banyak sepatu terjual dari awal
    private int admission_fee_today;    // uang masuk hari itu
    private int admission_fee_total;    // uang masuk keseluruhan
    private int capital;                // modal keseluruhan
    private int income_today;           // pendapatan hari itu
    private int income_total;           // pendapatan keseluruhan

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTrans_today() {
        return trans_today;
    }

    public void setTrans_today(int trans_today) {
        this.trans_today = trans_today;
    }

    public int getTrans_total() {
        return trans_total;
    }

    public void setTrans_total(int trans_total) {
        this.trans_total = trans_total;
    }

    public int getSold_today() {
        return sold_today;
    }

    public void setSold_today(int sold_today) {
        this.sold_today = sold_today;
    }

    public int getSold_total() {
        return sold_total;
    }

    public void setSold_total(int sold_total) {
        this.sold_total = sold_total;
    }

    public int getAdmission_fee_today() {
        return admission_fee_today;
    }

    public void setAdmission_fee_today(int admission_fee_today) {
        this.admission_fee_today = admission_fee_today;
    }

    public int getAdmission_fee_total() {
        return admission_fee_total;
    }

    public void setAdmission_fee_total(int admission_fee_total) {
        this.admission_fee_total = admission_fee_total;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getIncome_today() {
        return income_today;
    }

    public void setIncome_today(int income_today) {
        this.income_today = income_today;
    }

    public int getIncome_total() {
        return income_total;
    }

    public void setIncome_total(int income_total) {
        this.income_total = income_total;
    }
}
