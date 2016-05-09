import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Allergies {

    private final List<Allergen> allergens;

    public Allergies(final int score) {
        allergens = Stream
                .of(Allergen.values())
                .filter(allergen -> (score & allergen.getScore()) == allergen.getScore())
                .collect(Collectors.toList());
    }

    public boolean isAllergicTo(final Allergen allergen) {
        return allergens.contains(allergen);
    }

    public List<Allergen> getList() {
        return Collections.unmodifiableList(allergens);
    }
}
