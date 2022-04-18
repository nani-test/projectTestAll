package restAssured.test.dto;

public class BuilderProduct {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String img;

    public static BuilderProduct build()
    {
        return new BuilderProduct();
    }

    public BuilderProduct setTitle(String title)
    {
        this.title= title;
        return this;
    }

    public BuilderProduct setPrice(Double price)
    {
        this.price= price;
        return this;
    }

    public ProductDTO getProduct()
    {
        return new ProductDTO();
    }
}
