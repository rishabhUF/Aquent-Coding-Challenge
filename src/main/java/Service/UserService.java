package Service;

import Entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<Order> readDataFromDB();
    public Order createOrder(Order order);
}
