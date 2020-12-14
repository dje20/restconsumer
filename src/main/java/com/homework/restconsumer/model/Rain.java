package com.homework.restconsumer.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Rain {

    @JsonAlias("1h")
    private double _1h;

    public double get_1h() {
        return _1h;
    }

    public void set_1h(double _1h) {
        this._1h = _1h;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "_1h=" + _1h +
                '}';
    }
}
