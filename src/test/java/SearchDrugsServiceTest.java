import org.example.entity.Drugs;
import org.example.service.SearchDrugsService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchDrugsServiceTest {

    @Test
    public void searchDrug() {
        SearchDrugsService searchDrugsService = new SearchDrugsService();
        List<Drugs> inventory = createDummyInventory(); // Create a dummy inventory for testing

        // Test case 1: Search by ID - Expecting 1 result
        List<Drugs> results = new ArrayList<>();
        searchDrugsService.searchDrugs(inventory, "id", "1", results);
        printSearchResults(results);

        // Test case 2: Search by Name - Expecting 2 results
        results.clear(); // Clear the previous results
        searchDrugsService.searchDrugs(inventory, "name", "aspirin", results);
        printSearchResults(results);

        // Test case 3: Search by Category - Expecting 1 result
        results.clear(); // Clear the previous results
        searchDrugsService.searchDrugs(inventory, "category", "painkiller", results);
        printSearchResults(results);

        // Test case 4: Search by Price - Expecting 1 result
        results.clear(); // Clear the previous results
        searchDrugsService.searchDrugs(inventory, "price", "9.99", results);
        printSearchResults(results);

        // Test case 5: Search by Quantity - Expecting no results
        results.clear(); // Clear the previous results
        searchDrugsService.searchDrugs(inventory, "quantity", "100", results);
        printSearchResults(results);

        // Test case 6: Invalid search parameter - Expecting error message
        results.clear(); // Clear the previous results
        searchDrugsService.searchDrugs(inventory, "invalid", "invalid", results);
        printSearchResults(results);
    }

    private static List<Drugs> createDummyInventory() {
        List<Drugs> inventory = new ArrayList<>();
        inventory.add(new Drugs(1, "Aspirin", "Painkiller", 9.99, 50));
        inventory.add(new Drugs(2, "Paracetamol", "Painkiller", 4.99, 100));
        inventory.add(new Drugs(3, "Ibuprofen", "Anti-inflammatory", 7.99, 75));
        return inventory;
    }

    private static void printSearchResults(List<Drugs> results) {
        if (results.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("Search results:");
            for (Drugs drugs : results) {
                System.out.println(drugs);
            }
        }
        System.out.println();
    }
}
