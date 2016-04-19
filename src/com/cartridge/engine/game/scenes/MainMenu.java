package com.cartridge.engine.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.cartridge.engine.core.Camera;
import com.cartridge.engine.core.Plane;
import com.cartridge.engine.core.Scene;
import com.cartridge.engine.game.behaviours.MainMenuBehaviour;
import com.cartridge.engine.interfaces.IGameObject;
import com.cartridge.engine.math.Transform;

/**
 * Created by user on 10/04/16.
 */
public class MainMenu extends Scene
{
    public MainMenu(String name)
    {
        super(name);
    }

    @Override
    public void LoadContent()
    {
        super.LoadContent();

        // Create main camera
        PerspectiveCamera percamera = new PerspectiveCamera(70, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        super.camera = new Camera("Main Camera", new Object[]{ percamera, new Transform(0.0f,0.0f,0.0f) });
        super.camera.Transform().Rotate(0.5f, 0.0f, 0.5f);

        // Create our game objects
        IGameObject logo = new Plane("test image", new Object[]{
                new Texture("churchill.jpg"),
                new Transform(Gdx.graphics.getWidth()/2 - 260, Gdx.graphics.getHeight() /2 - 75, 0.0f, 500.0f, 200.0f, 0.0f)
        });

        // Create our game objects
        IGameObject spaceImage = new Plane("press space", new Object[]{
                new Texture("mario.png"),
                new Transform(Gdx.graphics.getWidth()/2 - 125.0f, Gdx.graphics.getHeight() /2 - 145.0f, 0.0f, 250.0f, 75.0f, 0.0f)
        });

        IGameObject logic = new Plane("logic", new Object[]{
                new MainMenuBehaviour()
        });

        // Add our game objects to the scene
        super.Pool().add(super.camera);
        super.Pool().add(logic);
        super.Pool().add(logo);
        super.Pool().add(spaceImage);
    }
}
