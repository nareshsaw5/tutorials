package dodo.learning.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class RestraurantTest {

    @Test
    public void testTypicalRestraurant() throws InterruptedException {
        // need orders
        List<Order> orders = new ArrayList<>();

        // need Cook who bakes on orders
        new Cook(orders).start();
        // need Waiter who takes orders
        new Waiter(orders).start();
        new Cook(orders).start();
        new Waiter(orders).start();
        new Cook(orders).start();
        new Waiter(orders).start();
        Thread.currentThread().join(20000);
        System.out.println("Left out food to cook : "+orders.size());

    }

}

class Waiter extends Thread {
    private List<Order> orders;

    Waiter(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread().currentThread();
        // simulate to give order on behalf of customer
        while (true) {
            Order order = new Order();
            order.setFoodName("Food:" + new Random().nextInt());
            System.out.println(currentThread+ " Placing order " + order.getFoodName());
            orders.add(order);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Cook extends Thread {

    private List<Order> orders;

    Cook(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {
        // cook if there is an order
        Thread currentThread = Thread.currentThread().currentThread();
        while (true) {
            if (orders.size() == 0) {
                System.out.println(currentThread+" Nothing to cook, resting at moment ");
            } else {
                System.out.println(currentThread+" Foods in order "+orders.size());
                for (int i = 0; i < orders.size(); i++) {
                    Order order = orders.get(i);
                    if (!order.isReady()) {
                        System.out.println(currentThread+" Cooking " + orders.get(i).getFoodName());
                        order.setReady(true);
                        orders.remove(i);
                    }
                }
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Order {
    private String foodName;
    private boolean isReady = false;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

}
