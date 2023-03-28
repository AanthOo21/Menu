package be.technifutur.menu;

public class ItemExcecutable extends Item {

    private Runnable action;
    public ItemExcecutable(String libel, Runnable action) {
        super(libel);
        this.action = action;
    }

    @Override
    public void execute() {
        if (isActif()) {
            this.action.run();
        }
    }
}
