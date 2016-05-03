package com.cartridge.engine.core;

import com.cartridge.engine.interfaces.ICartridgeBehaviour;
import com.cartridge.engine.interfaces.IGameObject;
import com.cartridge.engine.interfaces.IScene;

import java.util.LinkedList;

/**
 * Created by Aaron on 04/04/16.
 */
public abstract class Scene implements IScene
{
    private String      levelName = "";
    private static int  _id = -1;
    private static int  levelId = -1;
    private boolean     loading = true;
    private double      loadProgress = 0.0;
    private LinkedList<IGameObject> objectPool;
    private LinkedList<ICartridgeBehaviour> behaviourPool;
    protected IGameObject camera;

    public Scene(String name) {
        Scene._id++;
        this.levelName = name;
        this.levelId = Scene._id;
        this.objectPool = new LinkedList<IGameObject>();
        this.behaviourPool = new LinkedList<ICartridgeBehaviour>();

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
    public LinkedList<ICartridgeBehaviour> BehaviourPool() { return this.behaviourPool; }

    @Override
    public void AddBehaviour(ICartridgeBehaviour behaviour)
    {
        behaviourPool.add(behaviour);
    }

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