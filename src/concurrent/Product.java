package concurrent;

public class Product {
    private final int num;

    public Product(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Product:" + num;
    }
}
