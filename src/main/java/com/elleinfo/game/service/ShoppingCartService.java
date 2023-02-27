package com.elleinfo.game.service;

import com.elleinfo.game.entity.Order;
import com.elleinfo.game.entity.OrderDetail;
import com.elleinfo.game.model.CartInfo;
import com.elleinfo.game.model.CartLineInfo;
import com.elleinfo.game.model.CustomerInfo;
import com.elleinfo.game.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartService.class);
    @Autowired
    private OrderRepository orderRepository;


    @Transactional
    public void saveOrder(CartInfo cartInfo) {
        Order order = new Order();

        //order.setId(UUID.randomUUID().toString());
        order.setOrderDate(new Date());
        order.setAmount(cartInfo.getAmountTotal());

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        order.setCustomerName(customerInfo.getName());
        order.setCustomerEmail(customerInfo.getEmail());
        order.setCustomerAddress(customerInfo.getAddress());
        order.setOrderDate(new Date());

        // Create a list of OrderDetail instances
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (CartLineInfo line : cartInfo.getCartLines()) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);

            detail.setAmount(line.getAmount());
            detail.setGameId(line.getGameId());
            detail.setGameName(line.getGameName());
            detail.setQuantity(line.getQuantity());
            orderDetails.add(detail);
        }
        order.setOrderDetails(orderDetails);

         orderRepository.save(order);
        LOGGER.info("Order id after save:"+order.getId());

        // Order Number!
        cartInfo.setOrderNum(order.getId());
    }
}
