public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready, ";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice=3.0;
        double lattePrice=4.0;
        double capuccinoPrice=4.5;
        double lattePrice2=lattePrice*2;
        double orderDiff=lattePrice-dripCoffeePrice;

    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
        boolean isReadyOrder5 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        //Cindhuri
        if (isReadyOrder1){
            System.out.println(generalGreeting+customer1+readyMessage+displayTotalMessage+dripCoffeePrice);
        }
        else{
            System.out.println(generalGreeting+customer1+readyMessage+displayTotalMessage+pendingMessage);
        }

        //Sam
        if (isReadyOrder2==true && isReadyOrder5==true){
            System.out.println(generalGreeting+customer2+readyMessage+displayTotalMessage+lattePrice2);
        }
        else if(isReadyOrder2==true && isReadyOrder5==false){
            System.out.println(generalGreeting+customer2+readyMessage+displayTotalMessage+lattePrice+pendingMessage);
        }
        else if(isReadyOrder2==false && isReadyOrder5==true){
            System.out.println(generalGreeting+customer2+pendingMessage+readyMessage+displayTotalMessage+lattePrice+pendingMessage);
        }
        else{
            System.out.println(generalGreeting+customer2+pendingMessage);
        }

        //Jimmy
        if (isReadyOrder3){
            System.out.println(generalGreeting+customer3+readyMessage+displayTotalMessage+orderDiff);
        }
        else{
            System.out.println(generalGreeting+customer3+pendingMessage);
        }

        //Noah
        if (isReadyOrder4){
            System.out.println(generalGreeting+customer4+readyMessage+displayTotalMessage+capuccinoPrice);
        }
        else{
            System.out.println(generalGreeting+customer4+pendingMessage);
        }
        // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
    }
}