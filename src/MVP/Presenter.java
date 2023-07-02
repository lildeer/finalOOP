package MVP;

import Models.*;
import Models.ComOp.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Presenter {
    private View view;
    private Logger logger;

    public Presenter(View view) {
        this.view = view;
    }

    public void buttonClick() {
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        try {
            Complex c1 = new Complex(view.inputValue("Re: "), view.inputValue("Im: "));

            char operation = view.inputOperationSign("Operation Sign: ");

            Complex c2 = new Complex(view.inputValue("Re: "), view.inputValue("Im: "));

            switch (operation) {
                case '+' -> {
                    ComOperation complexOperation = new ComAdd();
                    Complex result = complexOperation.mathOperation(c1, c2);
                    complexOperation.print(result);
                    logger.log(Level.INFO, c1 + " + " + c2 + " = " + result);
                }
                case '-' -> {
                    ComOperation complexOperation = new ComSub();
                    Complex result = complexOperation.mathOperation(c1, c2);
                    complexOperation.print(result);
                    logger.log(Level.INFO, c1 + " - " + c2 + " = " + result);
                }
                case '*' -> {
                    ComOperation complexOperation = new ComMult();
                    Complex result = complexOperation.mathOperation(c1, c2);
                    complexOperation.print(result);
                    logger.log(Level.INFO, c1 + " * " + c2 + " = " + result);
                }
                case '/' -> {
                    ComOperation complexOperation = new ComDiv();
                    Complex result = complexOperation.mathOperation(c1, c2);
                    complexOperation.print(result);
                    logger.log(Level.INFO, c1 + " / " + c2 + " = " + result);
                }
                default -> logger.log(Level.WARNING, "Unexpected sign: " + operation);
            }
            fileHandler.close();
        } catch (InputMismatchException ex) {
            logger.log(Level.WARNING, "Введены некорректные данные при вводе комлексного числа!");
        }
    }
}
