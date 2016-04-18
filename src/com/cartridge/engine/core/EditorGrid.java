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
 * Created by user on 31/03/16.
 */
public class EditorGrid extends GameObject implements IGameObject
{
    ModelBuilder modelBuilder = new ModelBuilder();

    public EditorGrid(String _name) {
        super(_name);
        Model grid = modelBuilder.createLineGrid(10,10,10.0f,10.0f,new Material(ColorAttribute.createDiffuse(Color.GRAY)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        ModelInstance instance = new ModelInstance(grid);

        this.AddComponent(instance);
    }

    public EditorGrid(String _name, Object[] _components) {
        super(_name, _components);
        Model grid = modelBuilder.createLineGrid(10,10,10.0f,10.0f,new Material(ColorAttribute.createDiffuse(Color.GRAY)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        ModelInstance instance = new ModelInstance(grid);

        this.AddComponent(instance);
    }
}
