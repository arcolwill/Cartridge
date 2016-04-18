package com.cartridge.engine.interfaces;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.cartridge.engine.math.Transform;

/**
 * Created by Aaron on 31/03/16.
 */
public interface IGameObject<T>
{
    Boolean             Active();
    String              Name();
    ModelInstance       Mesh();
    Texture             Texture();
    Transform           Transform();
    PerspectiveCamera   Camera();
    Material            Material();

    void                SetActive(Boolean _active);
    void                AddComponent(T _component);
    T                   Find(String _name);
    void                Update(float _deltaTime);
}
