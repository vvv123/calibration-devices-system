package com.softserve.edu.documents.size;

public class SizeUnitConverter {
    public static double convert(double value, SizeUnit originalSizeUnit, SizeUnit resultSizeUnit) {
        double valueInTwips = value * originalSizeUnit.inTwips;
        return  valueInTwips / resultSizeUnit.inTwips;
    }
}
