package com.griesba.java100.patterns.proxy;

public class VueVehicule {

    public static void main(String[] args) {
        Animation animation = new AnimationProxy();
        animation.draw();
        animation.click();
        animation.draw();
    }
}
