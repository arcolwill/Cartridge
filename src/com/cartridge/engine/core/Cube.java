package com.cartridge.engine.core;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.cartridge.engine.GameObject;
import com.cartridge.engine.interfaces.IGameObject;

/**
 * Created by Aaron on 31/03/16.
 */
public class Cube extends GameObject implements IGameObject
{
    ModelBuilder modelBuilder = new ModelBuilder();

    public Cube(String _name)
    {
        super(_name);

        Model model = modelBuilder.createBox(5f, 5f, 5f,
                new Material(ColorAttribute.createDiffuse(Color.GOLD)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        ModelInstance instance = new ModelInstance(model);

        this.AddComponent(instance);
    }

    public Cube(String _name, Object[] _components)
    {
        super(_name, _components);
        Model model = modelBuilder.createBox(5f, 5f, 5f,
                new Material(ColorAttribute.createDiffuse(Color.GOLD)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        ModelInstance instance = new ModelInstance(model);
        this.AddComponent(instance);
    }
}
