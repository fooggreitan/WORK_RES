import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class FriendsOfMan {
    protected int id;
    protected String name;
    protected int Age;
    protected Date Birthdat;
    protected List<String> commands = new ArrayList<>();
    protected int type_class_animals;

    public FriendsOfMan(int id, String name, int age, List<String> commands, Date birthdat, int type_class_animals) {
        this.id = id;
        this.name = name;
        this.Age = age;
        this.commands = commands;
        this.Birthdat = birthdat;
        this.type_class_animals = type_class_animals;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", Имя=" + name + ", Возраст=" + Age + ", День рождения=" + Birthdat + ", Команды="
                + commands + ", type_class_animals=" + type_class_animals + "]";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Age;
    }

    public Date getBirthdat() {
        return Birthdat;
    }

    public List<String> getCommands() {
        return commands;
    }

    public int getType_class_animals() {
        return type_class_animals;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setBirthdat(Date birthdat) {
        Birthdat = birthdat;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void setType_class_animals(int type_class_animals) {
        this.type_class_animals = type_class_animals;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
    public void listCommands() {
        System.out.println("Команды, которые выполняет " + getName() + ":");
        for (String command : commands) {
            System.out.println(command);
        }
    }
    
}
