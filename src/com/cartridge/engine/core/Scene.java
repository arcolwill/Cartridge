package com.cartridge.engine.core;

import com.cartridge.engine.interfaces.IGameObject;
import com.cartridge.engine.interfaces.IScene;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Aaron on 04/04/16.
 */
public abstract class Scene implements IScene
{
    private String      levelName = "";
    private static int  levelId = -1;
    private boolean     loading = true;
    private double      loadProgress = 0.0;
    private LinkedList<IGameObject> objectPool;
    protected IGameObject camera;

    public Scene(String name) {
        levelName = name;
        levelId = Scene.levelId++;
        objectPool = new LinkedList<IGameObject>();

        /*
        try {
            BufferedReader br = new BufferedReader(new FileReader("levels/" + name + ".level"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    public boolean Loading() { return this.loading; }

    @Override
    public double LoadProgress() { return this.loadProgress; }

    @Override
    public String LevelName() { return this.levelName; }

    @Override
    public int LevelId() { return this.levelId; }

    @Override
    public IGameObject Camera() { return this.camera; }

    @Override
    public LinkedList<IGameObject> Pool() { return this.objectPool; }

    @Override
    public void Load(int scene)
    {
        SceneManager.Instance().LoadScene(scene);
    }

    @Override
    public void Load(String scene)
    {
        SceneManager.Instance().LoadScene(scene);
    }

    @Override
    public void LoadContent()
    {
        // todo: load content into various game object pools
    }
}