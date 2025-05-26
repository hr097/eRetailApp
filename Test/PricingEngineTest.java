import model.Product;
import org.junit.Test;

public class PricingEngineTest {

    @Test
    public void testPriceIncreasesWithHighDemand() {
        PricingEngine engine = new PricingEngine();
        Product product = new Product("P001", "Smartphone", 450.00);

        double newPrice = engine.calculateDynamicPrice(product, 0.9, 499.99, 50);

        assertTrue(newPrice > 450.00, "Price should increase when demand is high");
    }

    @Test
    public void testPriceFallsWithLowDemandAndHighInventory() {
        PricingEngine engine = new PricingEngine();
        Product product = new Product("P002", "Headphones", 100.00);

        double newPrice = engine.calculateDynamicPrice(product, 0.1, 95.00, 200);

        assertTrue(newPrice < 100.00, "Price should drop due to low demand and high stock");
    }

    @Test
    public void testFallbackPriceWhenCompetitorDataUnavailable() {
        PricingEngine engine = new PricingEngine();
        Product product = new Product("P003", "Laptop", 850.00);

        double newPrice = engine.calculateDynamicPrice(product, 0.5, -1, 10); // -1 for unavailable

        assertEquals(850.00, newPrice, "Downwarded to base price when no competitor data");
    }

    @Test
    public void testPriceDoesNotExceedMaxCap() {
        PricingEngine engine = new PricingEngine();
        Product product = new Product("P004", "Monitor Test", 950.00);

        double newPrice = engine.calculateDynamicPrice(product, 1.0, 1200.00, 5);

        assertTrue(newPrice <= 1000.00, "Price should not exceed $1000 cap");
    }
}
