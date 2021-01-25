package  ma.zs.generated.ws.rest.provided.vo;

import ma.zs.generated.bean.Product;
import ma.zs.generated.bean.User;

import java.math.BigDecimal;

public class PricingCollaboratorVo {
     private String priceMax ;
     private String price ;
     private String priceMin ;
     private String id ;
     private String priceMaxMax ;
     private String priceMaxMin ;
     private String priceMinMax ;
     private String priceMinMin ;
    private ProductVo product;
    private UserVo collaborator;


    public PricingCollaboratorVo(){
       super();
     }

    public String getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(String priceMax) {
        this.priceMax = priceMax;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(String priceMin) {
        this.priceMin = priceMin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriceMaxMax() {
        return priceMaxMax;
    }

    public void setPriceMaxMax(String priceMaxMax) {
        this.priceMaxMax = priceMaxMax;
    }

    public String getPriceMaxMin() {
        return priceMaxMin;
    }

    public void setPriceMaxMin(String priceMaxMin) {
        this.priceMaxMin = priceMaxMin;
    }

    public String getPriceMinMax() {
        return priceMinMax;
    }

    public void setPriceMinMax(String priceMinMax) {
        this.priceMinMax = priceMinMax;
    }

    public String getPriceMinMin() {
        return priceMinMin;
    }

    public void setPriceMinMin(String priceMinMin) {
        this.priceMinMin = priceMinMin;
    }

    public ProductVo getProduct() {
        return product;
    }

    public void setProduct(ProductVo product) {
        this.product = product;
    }

    public UserVo getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(UserVo collaborator) {
        this.collaborator = collaborator;
    }
}