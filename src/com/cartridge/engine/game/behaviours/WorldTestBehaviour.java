package com.cartridge.engine.game.behaviours;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.cartridge.engine.GameObject;
import com.cartridge.engine.core.SceneManager;
import com.cartridge.engine.interfaces.ICartridgeBehaviour;
import com.cartridge.engine.interfaces.IGameObject;

/**
 * Created by user on 11/04/16.
 */
public class WorldTestBehaviour implements ICartridgeBehaviour
{
    @Override
    public void Start()
    {
        System.out.println("WorldTestBehaviour Start");
    }

    @Override
    public void Update()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            SceneManager.Instance().LoadScene("Main");

        if(Gdx.input.isKeyPressed(Input.Keys.TAB)) {
            for (IGameObject g : SceneManager.ActiveScene.Pool()) {
                if (g.Name() == "editor grid") g.SetActive(false);
            }
        }
    }
}
