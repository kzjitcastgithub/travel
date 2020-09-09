package cn.itcast.ssm.domain;

public class ProductExt {

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductExt{" +
                "product=" + product +
                '}';
    }
}
