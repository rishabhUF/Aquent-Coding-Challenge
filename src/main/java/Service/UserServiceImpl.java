package Service;

import Entity.Order;
import Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public List<Order> readDataFromDB() {

        return userRepo.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        return userRepo.save(order);
    }
}
