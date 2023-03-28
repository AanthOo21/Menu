import be.technifutur.menu.Menu;
import be.technifutur.menu.MenuBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExempleMenuDinamique {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("toto", "dede", "lucas", "bill"));
        ExempleControler exempleControler = new ExempleControler(list);
        exempleControler.run();
    }
}

class ExempleControler implements Runnable {
    List<String> list;

    public ExempleControler(List<String> list) {
        this.list = list;
    }
    public void run() {
        MenuBuilder menuBuilder = new MenuBuilder();
        Menu actionSurX = menuBuilder.start("Action sur X");
        for (int i = 0; i < list.size(); i++) {
            int pos = i;
            menuBuilder.addItem(pos+1 +"", list.get(pos), () -> action(pos));
        }
        actionSurX.execute();
    }
    public void action(int pos) {
        String element = list.get(pos);
        System.out.println("je fais quelque chose avec " + element);
    }
}

