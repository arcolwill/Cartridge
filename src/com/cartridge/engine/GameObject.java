package com.cartridge.engine;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.cartridge.engine.core.CartridgeBehaviour;
import com.cartridge.engine.core.SceneManager;
import com.cartridge.engine.interfaces.ICartridgeBehaviour;
import com.cartridge.engine.interfaces.IGameObject;
import com.cartridge.engine.math.Transform;

import java.util.LinkedList;

import javax.swing.ComponentInputMap;

/**
 * Created by Aaron on 31/03/16.
 */
public abstract class GameObject<T> implements IGameObject<T>
{
    private Boolean             active;
    private String              name;
    private ModelBatch          modelBatch;
    private SpriteBatch         spriteBatch;

    private ModelInstance       mesh;
    private Texture             texture;
    private Transform           transform;
    private PerspectiveCamera   camera;
    private Material            material;
    private LinkedList<ICartridgeBehaviour> behaviours;

    public GameObject(String _name)
    {
        this.active         = true;
        this.name           = _name;
        this.modelBatch     = new ModelBatch();
        this.spriteBatch    = new SpriteBatch();
        this.transform      = new Transform(0.0f,0.0f,0.0f,1.0f,1.0f,1.0f);
        this.behaviours     = new LinkedList<ICartridgeBehaviour>();
        Start();
    }

    public GameObject(String _name, Object[] _components)
    {
        this.active         = true;
        this.name           = _name;
        this.modelBatch     = new ModelBatch();
        this.spriteBatch    = new SpriteBatch();
        this.transform      = new Transform(0.0f,0.0f,0.0f,1.0f,1.0f,1.0f);
        this.behaviours     = new LinkedList<ICartridgeBehaviour>();

        for(Object component : _components)
        {
            AddComponent((T)component);
        }

        Start();
    }

    void Start()
    {
        for(ICartridgeBehaviour b : behaviours) b.Start();
    }

    @Override
    public Boolean Active() { return this.active; }

    @Override
    public String Name() { return this.name; }

    @Override
    public ModelInstance Mesh() { return this.mesh; }

    @Override
    public Texture Texture() { return this.texture; }

    @Override
    public Transform Transform() { return this.transform; }

    @Override
    public PerspectiveCamera Camera() { return this.camera; }

    @Override
    public Material Material() { return this.material; }

    @Override
    public void SetActive(Boolean _active) { this.active = _active; }

    @Override
    public void AddComponent(T _component)
    {
        if(_component.getClass() == ModelInstance.class)
            mesh = (ModelInstance) _component;
        else if(_component.getClass() == Texture.class)
            texture = (Texture) _component;
        else if(_component.getClass() == Transform.class)
            transform = (Transform) _component;
        else if(_component.getClass() == Material.class)
            material = (Material) _component;
        else if(_component.getClass() == ICartridgeBehaviour.class)
            behaviours.add((CartridgeBehaviour) _component);                       // todo: fix loading of ICartridgeBehaviour
        else if(_component.getClass() == PerspectiveCamera.class) {
            camera = (PerspectiveCamera) _component;
            camera.position.set(0f, 0f, 0f);
            camera.lookAt(0,0,0);
            camera.near = 1f;
            camera.far = 300f;
            camera.update();
        }
    }

    @Override
    public T Find(String _name)
    {
        for(IGameObject<T> gameObject : SceneManager.ActiveScene.Pool()){
            if(gameObject.Name().equals(_name)) return (T)gameObject;
        }
        return null;
    }

    @Override
    public void Update(float _deltaTime)
    {
        for(ICartridgeBehaviour b : behaviours) b.Update();

        if (camera != null) {
            camera.update();
        }

        if(mesh != null && SceneManager.ActiveScene.Camera() != null) {
            mesh.transform.setTranslation(transform.x, transform.y, transform.z);
            mesh.transform.scale(transform.scalex, transform.scaley, transform.scalez);
            modelBatch.begin(SceneManager.ActiveScene.Camera().Camera());
            modelBatch.render(mesh, Cartridge.environment);
            modelBatch.end();
        }
        spriteBatch.begin();
        if(texture != null) spriteBatch.draw(texture, transform.x, transform.y, transform.scalex, transform.scaley);
        spriteBatch.end();
    }
}