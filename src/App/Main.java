package App;

import MVP.Presenter;
import MVP.View;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        new Presenter(new View()).buttonClick();
    }
}
