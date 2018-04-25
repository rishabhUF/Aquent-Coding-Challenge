package Repository;

import Entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo {

    public List<Order> findAll();
    public Order save(Order order);
}
