/**
 * The InventoryManager class manages a collection of products using Binary Search Trees for efficient
 * searching and listing operations.
 */
import java.io.*;
import java.util.Scanner;

public class InventoryManager {
    BinarySearchTree<String, Product> skuTree = new BinarySearchTree<>();
    BinarySearchTree<String, Product> nameTree = new BinarySearchTree<>();

    public void loadCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    Product p = new Product(parts[0], parts[1], parts[2], parts[3]);
                    skuTree.insert(parts[0], p);
                    nameTree.insert(parts[1], p);
                }
            }
            System.out.println("✅ Datos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al cargar archivo: " + e.getMessage());
        }
    }

    public void addProduct(Product p) {
        skuTree.insert(p.getSku(), p);
        nameTree.insert(p.getName(), p);
        System.out.println("✨ Producto agregado exitosamente.");
    }

    public void editProduct(String sku, Scanner scanner) {
        Product p = skuTree.search(sku);
        if (p != null) {
            System.out.print("Nueva descripción: ");
            p.setDescription(scanner.nextLine());
            System.out.print("Nuevas tallas y cantidad: ");
            p.setSizes(scanner.nextLine());
            System.out.println("📝 Producto actualizado.");
        } else {
            System.out.println("❗ Producto no encontrado.");
        }
    }

    public void searchBySKU(String sku) {
        Product p = skuTree.search(sku);
        if (p != null) System.out.println(p);
        else System.out.println("Producto no encontrado ❌");
    }

    public void searchByName(String name) {
        Product p = nameTree.search(name);
        if (p != null) System.out.println(p);
        else System.out.println("Producto no encontrado ❌");
    }

    public void listBySKU() {
        System.out.println("\n✧✧ Productos ordenados por SKU ✧✧");
        skuTree.inOrder();
    }

    public void listByName() {
        System.out.println("\n✧✧ Productos ordenados por Nombre ✧✧");
        nameTree.inOrder();
    }
}