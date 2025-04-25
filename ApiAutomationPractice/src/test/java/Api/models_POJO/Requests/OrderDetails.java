package Api.models_POJO.Requests;

public class OrderDetails {
    private String country;
    private String productOrderedId;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "country='" + country + '\'' +
                ", productOrderedId='" + productOrderedId + '\'' +
                '}';
    }

    public OrderDetails(String country, String productOrderedId) {
        this.country = country;
        this.productOrderedId=productOrderedId;
    }

    public String getProductOrderedId() {
        return productOrderedId;
    }

    public void setProductOrderedId(String productOrderedId) {
        this.productOrderedId = productOrderedId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
