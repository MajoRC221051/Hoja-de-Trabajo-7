import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InventoryManagerTest {

    private static final String TEST_SKU = "1234";
    private static final String TEST_NAME = "Camisa Deportiva";
    private static final String TEST_DESC = "Camisa deportiva de alta calidad";
    private static final String TEST_SIZES = "S:10,M:20,L:30";
    private InventoryManager manager;

    @BeforeEach
    public void setup() {
        // Inicializar InventoryManager y agregar un producto de prueba
        manager = new InventoryManager();
        Product testProduct = new Product(TEST_SKU, TEST_NAME, TEST_DESC, TEST_SIZES);
        manager.skuTree.insert(TEST_SKU, testProduct);
        manager.nameTree.insert(TEST_NAME, testProduct);
    }

    @Test
    public void testInsert() {
        // Verificar que el producto ha sido insertado en ambos árboles
        Product productBySKU = manager.skuTree.search(TEST_SKU);
        assertNotNull(productBySKU, "El producto con el SKU debe existir.");
        assertEquals(TEST_NAME, productBySKU.getName(), "El nombre del producto debe coincidir.");

        Product productByName = manager.nameTree.search(TEST_NAME);
        assertNotNull(productByName, "El producto con el nombre debe existir.");
        assertEquals(TEST_SKU, productByName.getSku(), "El SKU del producto debe coincidir.");
    }

    @Test
    public void testSearch() {
        // Buscar por SKU
        Product product = manager.skuTree.search(TEST_SKU);
        assertNotNull(product, "El producto no debe ser nulo al buscar por SKU.");
        assertEquals(TEST_NAME, product.getName(), "El nombre del producto debe coincidir al buscar por SKU.");

        // Buscar por nombre
        product = manager.nameTree.search(TEST_NAME);
        assertNotNull(product, "El producto no debe ser nulo al buscar por nombre.");
        assertEquals(TEST_SKU, product.getSku(), "El SKU del producto debe coincidir al buscar por nombre.");
    }
}
