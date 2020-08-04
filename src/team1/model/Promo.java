package team1.model;

/**
 *
 * @author bayug
 */
public class Promo {
    private String id;              // id promo
    private String name;            // nama promo 
    private String type;            // tipe = discount atau getfree
    private int discount;           // discount (10 atau 30) persen         | hanya angka tanpa persen
    private int max_get_discount;   // maksimal mendapatkan potongan harga  | dalam uang cth : 100000
    private int min_buy;            // minimal harga pembelian              | dalam uang cth : 300000
    private int min_items;          // minimal banyak pembelian             | dalam banyak cth : 2
    private int free_lots;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getMax_get_discount() {
        return max_get_discount;
    }

    public void setMax_get_discount(int max_get_discount) {
        this.max_get_discount = max_get_discount;
    }

    public int getMin_buy() {
        return min_buy;
    }

    public void setMin_buy(int min_buy) {
        this.min_buy = min_buy;
    }

    public int getMin_items() {
        return min_items;
    }

    public void setMin_items(int min_items) {
        this.min_items = min_items;
    }

    public int getFree_lots() {
        return free_lots;
    }

    public void setFree_lots(int free_lots) {
        this.free_lots = free_lots;
    }
    
    
}
