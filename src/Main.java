import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("----------------------");
    }
}

public class Main {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int option;

        do {
            System.out.println("\n=== CONTACT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Select option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    addContact();
                    break;

                case 2:
                    viewContacts();
                    break;

                case 3:
                    searchContact();
                    break;

                case 4:
                    deleteContact();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 5);
    }

    static void addContact() {

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));

        System.out.println("Contact added successfully.");
    }

    static void viewContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact c : contacts) {
            c.display();
        }
    }

    static void searchContact() {

        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                c.display();
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    static void deleteContact() {

        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();

        for (int i = 0; i < contacts.size(); i++) {

            if (contacts.get(i).name.equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}
