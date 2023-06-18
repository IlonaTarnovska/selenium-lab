package project.pages.model;

public class ProductModel {

    private float priceNew;
    private float priceOld;
    private float tax;
    private String productName;

    public ProductModel(float priceNew, float priceOld, float tax, String productName) {
        this.priceNew = priceNew;
        this.priceOld = priceOld;
        this.tax = tax;
        this.productName = productName;
    }

    public float getPriceNew() {
        return priceNew;
    }

    public float getPriceOld() {
        return priceOld;
    }

    public float getTax() {
        return tax;
    }

    public String getProductName() {
        return productName;
    }

}
