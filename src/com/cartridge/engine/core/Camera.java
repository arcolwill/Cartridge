package com.cartridge.engine.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.cartridge.engine.GameObject;
import com.cartridge.engine.interfaces.IGameObject;

/**
 * Created by Aaron on 31/03/16.
 */
public class Camera extends GameObject implements IGameObject
{
    ModelBuilder modelBuilder = new ModelBuilder();
    private CameraInputController controller;
    private ModelInstance model;

    public Camera(String _name)
    {
        super(_name);
        Setup();
    }

    public Camera(String _name, Object[] _components)
    {
        super(_name, _components);
        Setup();
    }

    void Setup()
    {
        Model _model = modelBuilder.createCone(5f, 5f, 5f, 4,
                new Material(ColorAttribute.createDiffuse(Color.PURPLE)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        model = new ModelInstance(_model);

        this.AddComponent(model);

        controller = new CameraInputController(Camera());
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void Update(float _deltaTime)
    {
        if(model != null && Transform() != null)
            model.transform.set(this.Transform().x,this.Transform().y,this.Transform().z,this.Transform().w);

        super.Update(_deltaTime);
        controller.update();
    }
}
