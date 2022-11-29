import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    //lab 11! list maker
    static ArrayList<String> list = new ArrayList<>();

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        final String menu = "A = Add  D = Delete  P = Print  Q = Quit";
        boolean done = false;
        String cmd = "";

        do {

            displayList();


            cmd = SafeInputs.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();


            switch(cmd) {
                case "A":
                    addItems();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    done = quitProgram();
                    break;
            }

        }
        while (!done);
    }
//private statics go here
    private static boolean quitProgram() {
        boolean quit = SafeInputs.getYNConfirm(in, "Are you SURE you want to quit?");

        return quit;
    }

    private static void deleteItem() {
        int index = SafeInputs.getRangedInt(in, "Which index would you like to remove?", 1, list.size());
        index -= 1;

        list.remove(index);
    }

    private static void addItems() {
        String newItem = SafeInputs.getNonZeroLenString(in, "What would you like to add to your list?");
        list.add(newItem);
    }

    private static void displayList() {
        System.out.println("==================================================");
        if (list.size() !=0) {
            for (int x = 0; x < list.size(); x++) {
                System.out.printf("%-3d%-15s", x+1, list.get(x));
            }
        }
        else {
            System.out.print("===                 List Maker                 ===");
        }
        System.out.println("\n==================================================");
    }


}
