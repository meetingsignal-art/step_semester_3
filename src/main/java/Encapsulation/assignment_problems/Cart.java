package Encapsulation.assignment_problems;

class Cart {
    private double[] prices;
    private int count;
    private final String cartId;

    public Cart(String cartId, int maxSize) {
        this.cartId = cartId;
        prices = new double[maxSize];
        count = 0;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }
}