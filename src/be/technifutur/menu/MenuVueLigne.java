package be.technifutur.menu;

import java.util.Scanner;

public class MenuVueLigne implements MenuVue {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String getChoice(Menu menu) {
        menu.getItemText().forEach((k,v) -> System.out.printf("%s: %s   |   ",k,v));
        System.out.print("Choix: ");
        return scanner.nextLine();
    }
}

