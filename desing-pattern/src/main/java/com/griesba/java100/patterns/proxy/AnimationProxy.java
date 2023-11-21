package com.griesba.java100.patterns.proxy;

public class AnimationProxy implements Animation {

    protected Film film = null;
    protected String photo = "affichage de la photo";

    public void click()
    {
        if (film == null)
        {
            film = new Film();
            film.charge();
        }
        film.joue();
    }

    public void draw()
    {
        if (film != null)
            film.draw();
        else
            draw(photo);
    }

    public void draw(String photo)
    {
        System.out.println(photo);
    }
}
