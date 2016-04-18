package com.cartridge.engine.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.cartridge.engine.GameObject;
import com.cartridge.engine.core.SceneManager;
import com.cartridge.engine.interfaces.IGameObject;

/**
 * Created by user on 31/03/16.
 */
public class Player extends GameObject implements IGameObject
{
    public Player(String _name)
    {
        super(_name);
        Setup();
    }

    public Player(String _name, Object[] _components)
    {
        super(_name, _components);
        Setup();
    }

    void Setup()
    {
        // Disable main camera
        IGameObject cam = SceneManager.ActiveScene.Camera();
        cam.SetActive(false);

        // Create and activate player cameraR
        PerspectiveCamera camera = new PerspectiveCamera(70, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        AddComponent(camera);
    }

    @Override
    public void Update(float _deltaTime)
    {
        super.Update(_deltaTime);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            IGameObject cam = (IGameObject)Find("Main Camera");
            cam.SetActive(true);
            SetActive(false);
        }
        // Todo: do stuff for player movement
    }
}
