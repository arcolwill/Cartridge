package com.cartridge.engine.core;

import com.cartridge.engine.GameObject;
import com.cartridge.engine.interfaces.IGameObject;

/**
 * Created by user on 31/03/16.
 */
public class Plane extends GameObject implements IGameObject
{
    public Plane(String _name)
    {
        super(_name);
    }

    public Plane(String _name, Object[] _components)
    {
        super(_name, _components);
    }
}
