package zad2;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add("+7 986 589 9358", "Гусев");
        phonebook.add("+7 950 205 5811", "Титов");
        phonebook.add("+7 964 172 6211", "Акимов");
        phonebook.add("+7 951 860 0714", "Львов");
        phonebook.add("+7 961 596 1381", "Данилов");
        phonebook.add("+7 905 523 5833", "Львов");
        phonebook.add("+7 951 833 8391", "Львов");

        phonebook.get("Гусев");
        phonebook.get("Акимов");
        phonebook.get("Львов");
        phonebook.get("Данилов");
        phonebook.get("Суслов");
        phonebook.get("Титов");

    }
}