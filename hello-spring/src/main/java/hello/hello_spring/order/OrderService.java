package hello.hello_spring.order;

public interface OrderService {
    Order createOrder(Long memId, String itemName, int itemPrice);
}
