import org.example.entity.Drugs;
import org.example.service.ListDrugsService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListDrugsServiceTest {

    @Test
    public void testListService() {
        ListDrugsService service = new ListDrugsService();
        List<Drugs> drugs = createDummyDrugs(); // Create a dummy list of drugs for testing

        // Test case 1: Sort by ID
        System.out.println("Sort by ID:");
        service.listDrug("id", drugs);

        // Test case 2: Sort by Name
        System.out.println("Sort by Name:");
        service.listDrug("name", drugs);

        // Test case 3: Sort by Category
        System.out.println("Sort by Category:");
        service.listDrug("category", drugs);

        // Test case 4: Sort by Price
        System.out.println("Sort by Price:");
        service.listDrug("price", drugs);

        // Test case 5: Sort by Quantity
        System.out.println("Sort by Quantity:");
        service.listDrug("quantity", drugs);

        // Test case 6: Invalid sort order - Expecting error message
        System.out.println("Sort by Invalid Order:");
        service.listDrug("invalid", drugs);
    }

    private static List<Drugs> createDummyDrugs() {
        List<Drugs> drugs = new ArrayList<>();
        drugs.add(new Drugs(2, "Paracetamol", "Painkiller", 4.99, 100));
        drugs.add(new Drugs(1, "Aspirin", "Painkiller", 9.99, 50));
        drugs.add(new Drugs(3, "Ibuprofen", "Anti-inflammatory", 7.99, 75));
        return drugs;
    }
}
