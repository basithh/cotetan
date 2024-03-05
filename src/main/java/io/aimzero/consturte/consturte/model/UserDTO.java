package io.aimzero.consturte.consturte.model;

import jakarta.validation.constraints.Size;


public class UserDTO {

    private Long id;

    @Size(max = 255)
    private String r;

    private Long rt;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getR() {
        return r;
    }

    public void setR(final String r) {
        this.r = r;
    }

    public Long getRt() {
        return rt;
    }

    public void setRt(final Long rt) {
        this.rt = rt;
    }

}
