import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> shoppingList = new ArrayList<>();
        int credit;
        String productName;
        int productPrice;


        System.out.println("Insert initial credit: ");
        credit = sc.nextInt();

        while (true){
            System.out.println("Enter item to shop (write exit if you want to leave): ");
            productName = sc.next();
            if (productName.equalsIgnoreCase("exit")){
                break;
            }
            else {
                System.out.println("Enter price:");
                productPrice = sc.nextInt();
                if (productPrice > credit) {
                    System.out.println("Insufficient credit");
                    break;
                } else {
                    Product product = new Product(productName, productPrice);
                    shoppingList.add(product);
                    credit -= productPrice;
                }
            }
        }
        shoppingList.sort(Comparator.comparing(Product::productPrice).reversed());
        shoppingList.forEach(System.out::println);
    }
}
