package contactsSearch;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner userInput = new Scanner(System.in);
        String action;

        String filename = "phonebook.db";
        Contacts phoneBook = new Contacts(); //(Contacts) SerializationUtils.deserialize(filename);
        CurrentState currentState = new CurrentState();

        while (true) {
            currentState.askingUserAction();
            action = userInput.nextLine();
            if (action.equals("exit")) { break; }
            switch (action) {
                case "add":
                    phoneBook.addRecord();
                    try {
                        SerializationUtils.serialize(phoneBook, filename);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "list":
                    currentState.setCurrentState("list");
                    phoneBook.printContacts();
                    break;
                case "search":
                    //phoneBook.searchRecords();
                    currentState.setCurrentState("search");
                    phoneBook.searchRecords();///???
                    currentState.setCurrentState("list");
                    break;
                case "count":
                    phoneBook.countRecords();
                    break;
                case "menu":
                    currentState.setCurrentState("menu");
                    currentState.searchList = null;
                    break;
                case "edit":
                    currentState.getCurrentRecord().editRecord();
                    break;
                case "back":
                    currentState.setCurrentState("menu");
                    break;
                case "delete":
                    phoneBook.removeRecord(currentState.getCurrentRecord());
                    currentState.setCurrentRecord(null);
                case "again":
                    currentState.setCurrentState("list");
                    phoneBook.searchRecords();
                    //break;
                default:
                    if (action.matches("[0-9]+")) {
                        if (currentState.getCurrentState().equals("search")) {
                            currentState.setCurrentRecord(currentState.searchList.get(Integer.parseInt(action) - 1));
                        } else {
                            currentState.setCurrentRecord(phoneBook.records.get(Integer.parseInt(action) - 1));
                        }
                        currentState.setCurrentState("record");
                        currentState.getCurrentRecord().printInfo();
                    }
            }
            System.out.println();
        }
    }
}
