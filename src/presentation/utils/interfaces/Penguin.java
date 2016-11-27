package presentation.utils.interfaces;

public class Penguin implements Bird {

    @Override
    public String getFeather() {
        return "Penguin Feather";
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
