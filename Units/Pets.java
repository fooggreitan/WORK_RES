import java.util.Date;
import java.util.List;

public abstract class Pets extends FriendsOfMan{

    public Pets(int id_Pets, String name, int age, List<String> commands, Date birthdat, int type_class_animals) {
        super(id_Pets, name, age, commands, birthdat, type_class_animals);
    }
}