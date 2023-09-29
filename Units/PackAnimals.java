import java.util.Date;
import java.util.List;

public abstract class PackAnimals extends FriendsOfMan{

    public PackAnimals(int id_PackAnimals, String name, int age, List<String> commands, Date birthdat, int type_class_animals) {
        super(id_PackAnimals, name, age, commands, birthdat, type_class_animals);
    }
}
