package org.githug.hwj;

import com.demo.spi.service.OrderService;

import java.util.ServiceLoader;

/**
 * @author hewenji
 * @Date 2022/9/4 16:20
 */
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<OrderService> orderServices = ServiceLoader.load(OrderService.class);
        for (OrderService orderService : orderServices) {
            System.out.println(orderService.getClass().getSimpleName() + "服务");
            System.out.println(orderService.getOrderCountById(1));
        }
    }
}
