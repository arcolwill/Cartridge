package com.cartridge.engine.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.cartridge.engine.GameObject;
import com.cartridge.engine.core.Camera;
import com.cartridge.engine.core.Cube;
import com.cartridge.engine.core.EditorGrid;
import com.cartridge.engine.core.Scene;
import com.cartridge.engine.core.SceneManager;
import com.cartridge.engine.interfaces.IGameObject;
import com.cartridge.engine.math.Transform;

/**
 * Created by user on 10/04/16.
 */
public class WorldTest extends Scene
{
    public WorldTest()
    {
        super("WorldTest");
    }

    @Override
    public void LoadContent()
    {
        super.LoadContent();

        // Create main camera
        PerspectiveCamera percamera = new PerspectiveCamera(70, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        super.camera = new Camera("Player Camera", new Object[]{ percamera, new Transform(0.0f,0.0f,0.0f) });
        super.camera.Transform().Rotate(0.5f, 0.0f, 0.5f);

        // Create our editor objects
        IGameObject grid = new EditorGrid("editor grid", new Object[]{
                new Transform(0.0f,-1.5f,-10.0f,1.0f,1.0f,1.0f)
        });

        IGameObject box = new Cube("test cube", new Object[]{
                new Transform(0.0f,1.5f,-10.0f,1.0f,1.0f,1.0f)
        });

        IGameObject box2 = new Cube("test cube 2", new Object[]{
                new Transform(10.0f,1.5f,-10.0f,1.0f,1.0f,1.0f)
        });

        // Add our game objects to the scene
        super.Pool().add(super.camera);
        super.Pool().add(grid);
        super.Pool().add(box);
        super.Pool().add(box2);
    }
}
