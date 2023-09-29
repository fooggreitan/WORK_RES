
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ArrayList<FriendsOfMan> animalsRegistry = new ArrayList<>();
        List<String> command = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean time = true;
            int age;
            Date date;
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Формат даты

            try (Counter counter = new Counter()) {
                while (time) {
                    System.out.println("Меню:\n1 - Завести новое животное\n2 - Посмотреть команды у животного\n"
                    + "3 - Обучить животное новым командам\n4 - Посмотреть список животных\n5 - Выход");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    try {
                        switch (choice) {
                            case 1:
                                counter.add();
                                System.out.println("Введите данные для нового животного:");
                                System.out.print("Имя: ");
                                String name = scanner.nextLine();
                                System.out.print("Дату рождения (в формате MM/dd/yyyy): ");
                                String dateStr = scanner.nextLine();
                                
                                try {
                                    date = dateFormat.parse(dateStr);
                                } catch (ParseException e) {
                                    throw new NotFormatException("Ошибка: Некорректный формат даты.");
                                }
                                System.out.print("Возраст: ");
   
                                try {
                                    age = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    throw new NotFormatException("Ошибка: Некорректный ввод возраста.");
                                }

                                scanner.nextLine();
                                System.out.println("Какого вы хотите животного:\n1 - Домашний\n2 - Вьючной");
                                int type_animals = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Какого вы хотите животного:");

                                if (type_animals == 1) {
                                    System.out.println("1 - Кошка\n2 - Собака\n3 - Хомяк");

                                    int type = scanner.nextInt();

                                    if (type == 1) {animalsRegistry.add(new Cat(animalsRegistry.size() + 1, name, age, command, date, type_animals));}
                                    else if (type == 2) {animalsRegistry.add(new Dog(animalsRegistry.size() + 1, name, age, command, date, type_animals));}
                                    else if (type == 3) {animalsRegistry.add(new Hamster(animalsRegistry.size() + 1, name, age, command, date, type_animals));}
                                }
                                else if (type_animals == 2) {
                                    System.out.println("1 - Лошадь\n2 - Верблюд\n3 - Осёл");
                                    
                                    int type = scanner.nextInt();

                                    if (type == 1) {animalsRegistry.add(new Hourse(animalsRegistry.size() + 1, name, age, command, date, type_animals));}
                                    else if (type == 2) {animalsRegistry.add(new Camels(animalsRegistry.size() + 1, name, age, command, date, type_animals));}
                                    else if (type == 3) {animalsRegistry.add(new Donkeys(animalsRegistry.size() + 1, name, age, command, date, type_animals));}
                                }
                                break;
                            case 2:
                                System.out.print("Введите номер животного: ");
                                int animalNumber = scanner.nextInt();
                                scanner.nextLine(); // Считываем перевод строки

                                if (animalNumber >= 1 && animalNumber <= animalsRegistry.size()) {
                                    FriendsOfMan animal = animalsRegistry.get(animalNumber - 1);

                                    animal.listCommands();
                                } else {
                                    System.out.println("Животное с таким номером не найдено.");
                                }
                                break;
                            case 3:
                                System.out.print("Введите номер животного, которому хотите добавить новую команду: ");
                                animalNumber = scanner.nextInt();
                                scanner.nextLine(); // Считываем перевод строки после ввода числа

                                if (animalNumber >= 1 && animalNumber <= animalsRegistry.size()) {
                                    System.out.print("Введите новую команду: ");
                                    String newCommand = scanner.nextLine();
                                    FriendsOfMan animal = animalsRegistry.get(animalNumber - 1);
                                    animal.addCommand(newCommand);
                                    System.out.println("Команда успешно добавлена.");
                                } else {
                                    System.out.println("Животное с таким номером не найдено.");
                                }
                                break;
                            case 4:
                                System.out.println("Список животных:\n" + animalsRegistry);
                                break;
                            case 5:
                                time = false;
                                break;
                            default:
                                System.out.println("Неверный выбор. Попробуйте еще раз.");
                                break;
                        }
                    } catch (NotFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Try one more time");
                    }
                }
            } catch (IllegalStateException e) {
                System.out.println("Ошибка: Счетчик не был закрыт корректно.");
            }
            catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }
}

class InvalidInputException extends Exception {
    /**
     * Исключение для недопустимых операций
     * @param message
     */
    public InvalidInputException(String message) {
        super(message);
    }
}

class NotFormatException extends InputMismatchException {
    /**
     * Исключение для неправильного ввода значений
     * @param message
     */
    public NotFormatException(String message) {
        super(message);
    }
}
