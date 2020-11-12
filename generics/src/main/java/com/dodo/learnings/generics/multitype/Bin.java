package com.dodo.learnings.generics.multitype;

public class Bin<W, D> {

    private W wetWaste;
    private D dryWaste;

    public W getWetWaste() {
        return wetWaste;
    }

    public void setWetWaste(W wetWaste) {
        this.wetWaste = wetWaste;
    }

    public D getDryWaste() {
        return dryWaste;
    }

    public void setDryWaste(D dryWaste) {
        this.dryWaste = dryWaste;
    }

    @Override public String toString() {
        return "Bin{" + "wetWaste=" + wetWaste + ", dryWaste=" + dryWaste + '}';
    }
}
