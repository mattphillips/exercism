import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Allergies {

    private final List<Allergen> list;

    public Allergies(final int score) {
        list = Stream
                .of(Allergen.values())
                .filter(allergen -> (score & allergen.getScore()) == allergen.getScore())
                .collect(Collectors.toList());
    }

    public boolean isAllergicTo(final Allergen allergen) {
        return list.contains(allergen);
    }

    public List<Allergen> getList() {
        return Collections.unmodifiableList(list);
    }
}
