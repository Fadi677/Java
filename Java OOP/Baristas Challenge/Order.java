import java.util.ArrayList;
public class Order {
    
    private String name=new String();
    // public double total;
    private boolean ready;
    private ArrayList<Item> items=new ArrayList<Item>();

    
    public Order(){
        this.name="Guest";
    }
    public Order(String name){
        this.name=name;
    }

    public String getOrderName(){
        return name;
    }
    public void setOrderName(String name){
        this.name=name;
    }

    public boolean getOrderIsReady(){
        return ready;
    }
    public void setOrderIsReady(boolean ready){
        this.ready=ready;
    }

    public ArrayList<Item> getOrderItems(){
        return items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        boolean status=this.getOrderIsReady();
        if(status){
            System.out.println("the order is ready");
            return "the order is ready";
        }
        else{
            System.out.println("the order is not ready");
            return "the order is not ready";
        }
    }

    public double getOrderTotal(){
        double sum=0;
        for(int i=0;i<this.items.size();i++){
            sum+=this.items.get(i).getItemPrice();
        }
        return sum;
    }

    public void display(){
        System.out.println("Customer Name: "+getOrderName());
        for(int i=0;i<this.items.size();i++){
            System.out.println(this.items.get(i).getItemName()+" - $"+this.items.get(i).getItemPrice());
        }
        System.out.println("Total: $"+getOrderTotal());
    }

}