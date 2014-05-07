package com.github.bingoohuang.designpatterns.argumentsvalidators;

public class FixedSizeArgumentValidator implements ArgumentValidator {
    private final int fixedSize;
    private ArgumentValidator argumentValidator;

    public FixedSizeArgumentValidator(ArgumentValidator argumentValidator, int fixedSize) {
        this.argumentValidator = argumentValidator;
        this.fixedSize = fixedSize;
    }

    public FixedSizeArgumentValidator(int fixedSize) {
        this.fixedSize = fixedSize;
    }

    @Override
    public void validate(String arg) {
        if (argumentValidator != null) argumentValidator.validate(arg);

        if (fixedSize != arg.length()) throw new BadArgumentException(arg + " has not fixed length ");
    }
}
