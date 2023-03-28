package be.technifutur.menu;

import java.util.*;

public class Menu extends Item {

    private Map<String, Item> itemMap = new LinkedHashMap<>();
    private MenuVue vue;
    private boolean finish = false;

    public Menu(String libel, MenuVue vue) {
        super(libel);
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public MenuVue getVue() {
        return vue;
    }

    public void setVue(MenuVue vue) {
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    public Item addItem(String key, Item value) {
        return itemMap.put(key, value);
    }

    public Item removeItem(Object key) {
        return itemMap.remove(key);
    }

    public Menu(String libel) {
        super(libel);
    }

    @Override
    public void execute() {
        String choix = vue.getChoice(this);
        while (!itemMap.containsKey(choix)) {
            choix = vue.getChoice(this);
        }
        itemMap.get(choix).execute();
    }

    public Map<String, String> getItemText() {

        Map<String, String> menuMap = new LinkedHashMap<>();

        // -------------------- Même code que celui en-dessous --------------------

        /*Iterator<Map.Entry<String, Item>> iterator = itemMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Item> next = iterator.next();
            String key = next.getKey();
            Item value = next.getValue();
            menuMap.put(key, value.getLibel());
        }
        return menuMap;*/

        for (Map.Entry<String, Item> next: itemMap.entrySet()) {
            menuMap.put(next.getKey(), next.getValue().getLibel());
        }
        return menuMap;
    }
}
