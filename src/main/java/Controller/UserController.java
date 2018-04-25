package Controller;

import Entity.Order;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/order/findAll" , method = RequestMethod.GET)
    public List<Order> findAll() {
        return userService.readDataFromDB();
    }

    @RequestMapping(value = "/api/order", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order)
    {
        return userService.createOrder(order);
    }
}
