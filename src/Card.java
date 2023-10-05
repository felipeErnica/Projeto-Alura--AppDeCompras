import java.util.ArrayList;
import java.util.Collections;

public class Card {
    private double cardLimit;
    private ArrayList<Product> listProducts;

    public Card (double cardLimit){
        this.cardLimit = cardLimit;
        listProducts =  new ArrayList<>();
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public boolean newTransaction(Product product){
        if (product.getPrice() > cardLimit){
            return false;
        }
        else {
            listProducts.add(product);
            cardLimit -= product.getPrice();
            return true;
        }
    }

    public boolean removeTransaction(int index){
        if (index <= listProducts.size()) {
            cardLimit += listProducts.get(index-1).getPrice();
            listProducts.remove(index-1);
            return true;
        }
        else {
            return false;
        }
    }

    public void printList(){
        int index = 0;
        Collections.sort(listProducts);

        for (Product product: listProducts) {
            index +=1;
            System.out.println(index + " - " + product);
        }
    }

}
