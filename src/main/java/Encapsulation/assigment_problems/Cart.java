package main.java.Encapsulation.assigment_problems;

public class Cart {
   
    private final String id;

   
    private final double[] prices;
    private int count = 0;

  
    public Cart(String id, int maxItems) {
        this.id = id;
        this.prices = new double[maxItems];
    }

   
    public String getId() {
        return id;
    }

   
    public void addItem(double price) {
        if (price >= 0 && count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

   
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

 
    public int getItemCount() {
        return count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + (int) cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}