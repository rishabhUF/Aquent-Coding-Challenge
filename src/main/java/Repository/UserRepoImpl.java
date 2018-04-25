package Repository;

import Entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }
}
