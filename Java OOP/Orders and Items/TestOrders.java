import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
    // Menu items
    //mocha", "latte", "drip coffee" and "capuccino"
    Item item1=new Item();
    item1.name="mocha";
    item1.price=3.5;

    Item item2=new Item();
    item2.name="latte";
    item2.price=4.0;

    Item item3=new Item();
    item3.name="drip coffee";
    item3.price=4.5;

    Item item4=new Item();
    item4.name="capuccino";
    item4.price=5.0;
    
    //"Cindhuri", "Jimmy", "Noah", "Sam".
    // Order variables -- order1, order2 etc.
    Order order1=new Order();
    order1.name="Cindhuri";
    order1.total=item3.price;
    order1.ready=true;
    order1.items.add(item3);
    
    Order order2=new Order();
    order2.name="Jimmy";
    order2.total=item3.price;
    order2.ready=true;
    order2.items.add(item1);

    Order order3=new Order();
    order3.name="Noah";
    order3.total=item4.price;
    order3.ready=false;
    order3.items.add(item4);

    Order order4=new Order();
    order4.name="Sam";
    order4.total=item2.price+item2.price+item2.price;
    order4.ready=false;
    order4.items.add(item2);
    order4.items.add(item2);
    order4.items.add(item2);

    // Application Simulations
    // Use this example code to test various orders' updates
    System.out.printf("Name: %s\n", order1.name);
    System.out.printf("Total: %s\n", order1.total);
    System.out.printf("Ready: %s\n", order1.ready);
    System.out.println(order1.items.get(0).name);
    }
}