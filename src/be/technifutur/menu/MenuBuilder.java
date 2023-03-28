package be.technifutur.menu;

import java.util.ArrayDeque;
import java.util.Deque;

public class MenuBuilder {
    private MenuVue defaultVue = new MenuVueImpl();
    private Deque<Menu> pileMenu = new ArrayDeque<>();

    public Menu getMenu() {
        return pileMenu.peek();
    }

    public Item addItem(String key, String libel, Runnable action) {
        ItemExcecutable itemExcecutable = new ItemExcecutable(libel, action);
        pileMenu.peek().addItem(key, itemExcecutable);
        return itemExcecutable;
    }


    public Menu startMenu(String key, String libel) {
        return startMenu(key, libel, defaultVue);
    }
    public Menu startMenu(String key, String libel, MenuVue vue) {
        Menu menu = new Menu(libel, vue);
        pileMenu.peek().addItem(key, menu);
        pileMenu.push(menu);
        return menu;
    }
    public Menu endMenu() {
        return pileMenu.pop();
    }

    public Menu start(String menuPrincipalName) {
        return start(menuPrincipalName, defaultVue);
    }
    public Menu start(String menuPrincipalName, MenuVue vue) {
        Menu menu = new Menu(menuPrincipalName, vue);
        pileMenu.push(menu);
        return menu;
    }

    public void end() {
        pileMenu.clear();
    }
}
