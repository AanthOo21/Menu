package be.technifutur.menu;

import java.util.Scanner;

public class MenuVueImpl implements MenuVue {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String getChoice(Menu menu) {
        menu.getItemText().forEach((k,v) -> System.out.println(k+": "+v));
        System.out.print("Choix: ");
        return scanner.nextLine();
    }
}
