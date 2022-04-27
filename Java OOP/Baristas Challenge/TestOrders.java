import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
    
    // Menu items
    //mocha", "latte", "drip coffee" and "capuccino"

    Item item1=new Item();
    item1.setItemName("mocha");
    item1.setItemPrice(3.5);

    Item item2=new Item();
    item2.setItemName("latte");
    item2.setItemPrice(4.0);

    Item item3=new Item();
    item3.setItemName("drip coffee");
    item3.setItemPrice(4.5);

    Item item4=new Item();
    item4.setItemName("capuccino");
    item4.setItemPrice(5.0);
    
    //"Cindhuri", "Jimmy", "Noah", "Sam".
    // Order variables -- order1, order2 etc.
    Order order1=new Order();
    order1.setOrderName("Cindhuri");
    order1.getOrderTotal();
    order1.setOrderIsReady(false);
    order1.addItem(item3);
    
    Order order2=new Order();
    order2.setOrderName("Jimmy");
    order2.getOrderTotal();
    order2.setOrderIsReady(true);
    order2.addItem(item1);

    Order order3=new Order();
    order3.setOrderName("Noah");
    order3.getOrderTotal();
    order3.setOrderIsReady(false);
    order3.addItem(item4);

    Order order4=new Order();
    order4.setOrderName("Sam");
    order4.getOrderTotal();
    order4.setOrderIsReady(false);
    order4.addItem(item2);

    Order order5=new Order();

    order1.display();
    order2.display();
    order3.display();
    order4.display();
    order5.display();
    // order2.getStatusMessage();
    }
}