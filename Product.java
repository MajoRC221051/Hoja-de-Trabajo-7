/**
 * The Product class represents a product with SKU, name, description, and sizes, providing methods to
 * access and modify its attributes.
 */
public class Product {
    private String sku;
    private String name;
    private String description;
    private String sizes;

    public Product(String sku, String name, String description, String sizes) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.sizes = sizes;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public void setDescription(String description) { this.description = description; }
    public void setSizes(String sizes) { this.sizes = sizes; }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "SKU: " + sku + " | Nombre: " + name + " | Descripción: " + description + " | Tallas: " + sizes;
    }
} 