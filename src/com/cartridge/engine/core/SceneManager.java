package com.cartridge.engine.core;

import com.cartridge.engine.interfaces.IScene;

import java.util.LinkedList;

/**
 * Created by user on 04/04/16.
 */
public class SceneManager
{
    public LinkedList<IScene> scenes = new LinkedList<IScene>();

    // singleton
    private static SceneManager instance =  null;
    protected SceneManager(){}
    public static SceneManager Instance()
    {
        if(instance == null)
            instance = new SceneManager();
        return instance;
    }

    public static IScene ActiveScene = null;

    public void AddScene(IScene scene)
    {
        scenes.add(scene);
    }

    public void LoadScene(int scene)
    {
        for(IScene s : scenes)
            if(s.LevelId() == scene)
                SetActiveScene(s);
    }

    public void LoadScene(String scene)
    {
        for(IScene s : scenes)
            if(s.LevelName() == scene)
                SetActiveScene(s);
    }

    private void SetActiveScene(IScene scene)
    {
        ActiveScene = scene;
        ActiveScene.LoadContent();
    }

}
