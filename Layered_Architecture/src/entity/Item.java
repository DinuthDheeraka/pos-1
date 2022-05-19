package entity;

import java.math.BigDecimal;

public class Item {
    String code;
    String description;
    BigDecimal unitPrice;
    int qoh;

    public Item() {
    }

    public Item(String code, String description, BigDecimal unitPrice, int qoh) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }
}
