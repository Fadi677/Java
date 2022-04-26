import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CafeUtil{

    public int getStreakGoal(){
        int sum=0;
        for(int i=0; i<10 ;i++){
            sum +=i;// number of drinks
        }
        return sum;

    }

    public double getOrderTotal(double[] prices){
        double total=0;
        for(int i=0; i< prices.length;i++){
            total+=prices[i];

        }
        return total;
    }
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> myArray){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " +userName);

            System.out.println("There are " +myArray.size()+" people in front of you:");

        myArray.add(userName); // to add an item to an ArrayList

    }

}