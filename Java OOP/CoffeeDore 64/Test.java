public class Test {
    public static void main(String[] args) {
        OrderKiosk newOrder = new OrderKiosk();

        newOrder.addMenuItem( 0, "banana", 2.0 );
        newOrder.addMenuItem( 1, "coffee", 1.5 );
        newOrder.addMenuItem( 2, "latte", 4.5 );
        newOrder.addMenuItem( 3, "capuccino", 3.0 );
        newOrder.addMenuItem( 4, "muffin", 4.0 );

        newOrder.displayMenu();
        newOrder.newOrder();


    }
}
