public class Item{
    private String name=new String();
    private double price;
    private int index;

    public String getItemName(){
        return name;
    }
    public void setItemName(String name){
        this.name=name;
    }

    public double getItemPrice(){
        return price;
    }
    public void setItemPrice(double price){
        this.price=price;
    }

    public Item(){
    }
    public Item(int iindex, String name, double price){
        this.index=index;
        this.name=name;
        this.price=price;
    }

    public int getIndex(){
        return index;
    }
    public void setIndex(int index){
        this.index=index;
    }


}