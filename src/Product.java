public record Product(String productName, int productPrice) {
    public String toString() {
        return productName + " - " + productPrice;
    }
}
