/**
 * The Main class in Java represents an inventory management system for a clothing store with
 * functionalities to add, edit, search, and list products.
 */
import java.util.Scanner;

public class Main {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        manager.loadCSV("inventario_ropa_deportiva.csv");

        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    System.out.print("SKU: ");
                    String sku = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();
                    System.out.print("Tallas y cantidad: ");
                    String sizes = scanner.nextLine();
                    Product p = new Product(sku, name, desc, sizes);
                    manager.addProduct(p);
                    break;
                case 2:
                    System.out.print("SKU del producto a editar: ");
                    String editSku = scanner.nextLine();
                    manager.editProduct(editSku, scanner);
                    break;
                case 3:
                    System.out.print("SKU a buscar: ");
                    String searchSku = scanner.nextLine();
                    manager.searchBySKU(searchSku);
                    break;
                case 4:
                    System.out.print("Nombre a buscar: ");
                    String searchName = scanner.nextLine();
                    manager.searchByName(searchName);
                    break;
                case 5:
                    manager.listBySKU();
                    break;
                case 6:
                    manager.listByName();
                    break;
                case 7:
                    System.out.println("🌷 Gracias por usar el sistema Coquette, bye bye! ✨");
                    break;
                default:
                    System.out.println("❗ Opción inválida.");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n Bienvenido a tu Tienda Virtual :)");
        System.out.println(" ¿Qué deseas hacer hoy?");
        System.out.println("   1. Agregar un nuevo producto ");
        System.out.println("  2. Editar un producto existente ");
        System.out.println("  3. Buscar producto por SKU ");
        System.out.println("   4. Buscar producto por Nombre ");
        System.out.println("   5. Mostrar listado ordenado por SKU ");
        System.out.println("   6. Mostrar listado ordenado por Nombre ");
        System.out.println("   7. Salir ");
        System.out.print("\n Ingresa tu opción: ");
    }
}
