import be.technifutur.menu.*;

public class Main {
    public static void main(String[] args) {

        // Menu menuPrincipal = getMenu();

        MenuBuilder menuBuilder = new MenuBuilder();
        Menu menuPrincipal = menuBuilder.start("Menu Principal");
        {
            menuBuilder.addItem("1", "Option 1", getOption1());
            menuBuilder.addItem("2", "Option 2", getOption2());
            menuBuilder.addItem("3", "Option 3", getOption3());
            Menu menuSecondaire = menuBuilder.startMenu("+", "Menu Secondaire");
            {
                menuBuilder.addItem("1", "Option 4", getOption4());
                menuBuilder.addItem("2", "Option 5", getOption5());
                Menu menu3 = menuBuilder.startMenu("+", "Menu 3", new MenuVueLigne());
                {
                    menuBuilder.addItem("3", "Option 6", getOption6());
                    menuBuilder.addItem("0", "Quitter", () -> menu3.setFinish(true));
                }
                menuBuilder.endMenu();
            }
            menuBuilder.endMenu();
            menuBuilder.addItem("0", "Quitter", () -> menuPrincipal.setFinish(true));
        }
        menuBuilder.end();

        while (!menuPrincipal.isFinish()) {
            menuPrincipal.execute();
        }
    }

    private static Menu getMenu() {
        Menu menuPrincipal = new Menu("Menu Principal", new MenuVueImpl());
        Menu menuSecondaire = new Menu("Menu Secondaire", new MenuVueImpl());

        ItemExcecutable option1 = new ItemExcecutable("Option 1", getOption1());
        ItemExcecutable option2 = new ItemExcecutable("Option 2", getOption2());
        ItemExcecutable option3 = new ItemExcecutable("Option 3", getOption3());
        ItemExcecutable option4 = new ItemExcecutable("Option 4", getOption4());
        ItemExcecutable option5 = new ItemExcecutable("Option 5", getOption5());
        ItemExcecutable option6 = new ItemExcecutable("Option 6", getOption6());

        menuPrincipal.addItem("1", option1);
        menuPrincipal.addItem("2", option2);
        menuPrincipal.addItem("3", option3);
        menuPrincipal.addItem("4", option4);
        menuPrincipal.addItem("+", menuSecondaire);
        menuSecondaire.addItem("1", option5);
        menuSecondaire.addItem("2", option6);
        menuSecondaire.addItem("+", menuPrincipal);
        menuPrincipal.addItem("0", new ItemExcecutable("Quitter", () -> menuPrincipal.setFinish(true)));
        menuSecondaire.addItem("0", new ItemExcecutable("Quitter", () -> menuPrincipal.setFinish(true)));
        return menuPrincipal;
    }

    private static Runnable getOption1() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Vous avez choisi l'option 1");
            }
        };
    }

    private static Runnable getOption2() {
        return () -> System.out.println("Vous avez choisi l'option 2");
    }

    private static Runnable getOption3() {
        return () -> System.out.println("Vous avez choisi l'option 3");
    }

    private static Runnable getOption4() {
        return () -> System.out.println("Vous avez choisi l'option 4");
    }

    private static Runnable getOption5() {
        return () -> System.out.println("Vous avez choisi l'option 5");
    }

    private static Runnable getOption6() {
        return () -> System.out.println("Vous avez choisi l'option 6");
    }
}
