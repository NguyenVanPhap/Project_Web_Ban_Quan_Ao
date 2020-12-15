package com.webbanquanao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CartitemEntityPK implements Serializable {
    private String cartId;
    private int proId;

    @Column(name = "cart_id")
    @Id
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @Column(name = "pro_id")
    @Id
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartitemEntityPK that = (CartitemEntityPK) o;
        return proId == that.proId &&
                Objects.equals(cartId, that.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, proId);
    }
}
