package com.cartridge.engine.interfaces;

import java.util.LinkedList;

/**
 * Created by Aaron on 04/04/16.
 */
public interface IScene
{
    String  LevelName();
    int     LevelId();
    void    Load(int scene);
    void    Load(String scene);
    boolean Loading();
    double  LoadProgress();
    LinkedList<IGameObject> Pool();
    IGameObject Camera();

    void    LoadContent();
}
