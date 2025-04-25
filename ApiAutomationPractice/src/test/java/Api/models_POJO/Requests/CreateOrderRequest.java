package Api.models_POJO.Requests;

import java.util.List;

public class CreateOrderRequest {
    private List<OrderDetails> orders;

    public CreateOrderRequest(List<OrderDetails> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "orders=" + orders +
                '}';
    }

    public List<OrderDetails> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetails> orders) {
        this.orders = orders;
    }
}
