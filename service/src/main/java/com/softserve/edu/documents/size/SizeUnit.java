package com.softserve.edu.documents.size;

public enum SizeUnit {
    CM(566.929133858), PT(20d), TWIP(1d);

    final Double inTwips;

    SizeUnit(Double inTwips) {
        this.inTwips = inTwips;
    }
}
