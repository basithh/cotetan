package io.aimzero.consturte.consturte.model;

import jakarta.validation.constraints.Size;


public class Rer {

    @Size(max = 255)
    private String ere;

    public String getEre() {
        return ere;
    }

    public void setEre(final String ere) {
        this.ere = ere;
    }

}
