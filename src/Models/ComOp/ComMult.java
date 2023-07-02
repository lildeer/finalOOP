package Models.ComOp;

import Models.ComOperation;
import Models.Complex;

public class ComMult implements ComOperation {
    @Override
    public Complex mathOperation(Complex c1, Complex c2) {
        double resultRe = c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm();
        double resultIm = c1.getIm() * c2.getRe() + c1.getRe() * c2.getIm();
        return new Complex(resultRe, resultIm);
    }

    @Override
    public void print(Complex complex) {
        complex.print();
    }
}
