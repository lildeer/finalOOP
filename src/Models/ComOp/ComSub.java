package Models.ComOp;

import Models.ComOperation;
import Models.Complex;

public class ComSub implements ComOperation {
    @Override
    public Complex mathOperation(Complex c1, Complex c2) {
        return new Complex(c1.getRe() - c2.getRe(), c1.getIm() - c2.getIm());
    }

    @Override
    public void print(Complex complex) {
        complex.print();
    }
}
