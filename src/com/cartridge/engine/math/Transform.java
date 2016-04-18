package com.cartridge.engine.math;

/**
 * Created by Aaron on 31/03/16.
 */
public class Transform
{
    public float x, y, z, w;
    public float scalex, scaley, scalez;
    public float rotatex, rotatey, rotatez;

    public Transform()
    {
        x = 0.0f;
        y = 0.0f;
        z = 0.0f;
        w = 1.0f;
        scalex = 1.0f;
        scaley = 1.0f;
        scalez = 1.0f;
        rotatex = 0.0f;
        rotatey = 0.0f;
        rotatez = 0.0f;
    }

    public Transform(float _x, float _y, float _z)
    {
        x = _x;
        y = _y;
        z = _z;
        w = 1.0f;
        scalex = 1.0f;
        scaley = 1.0f;
        scalez = 1.0f;
        rotatex = 0.0f;
        rotatey = 0.0f;
        rotatez = 0.0f;
    }

    public Transform(float _x, float _y, float _z, float _scalex, float _scaley, float _scalez)
    {
        x = _x;
        y = _y;
        z = _z;
        w = 1.0f;
        scalex = _scalex;
        scaley = _scaley;
        scalez = _scalez;
        rotatex = 0.0f;
        rotatey = 0.0f;
        rotatez = 0.0f;
    }

    public void Translate(float _x, float _y, float _z)
    {
        x = _x;
        y = _y;
        z = _z;
    }

    public void Scale(float _scalex, float _scaley, float _scalez)
    {
        scalex = _scalex;
        scaley = _scaley;
        scalez = _scalez;
    }

    public void Rotate(float _rotatex, float _rotatey, float _rotatez)
    {
        rotatex = _rotatex;
        rotatey = _rotatey;
        rotatez = _rotatez;
    }
}
