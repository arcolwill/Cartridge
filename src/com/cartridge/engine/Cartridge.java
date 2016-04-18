package com.cartridge.engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.cartridge.engine.core.Scene;
import com.cartridge.engine.core.SceneManager;
import com.cartridge.engine.game.scenes.MainMenu;
import com.cartridge.engine.game.scenes.WorldTest;
import com.cartridge.engine.interfaces.IGameObject;

public class Cartridge extends ApplicationAdapter
{
	static Environment environment;

	@Override
	public void create ()
	{
		Gdx.graphics.setWindowedMode(1200, 600);

		// Create environment TODO: set in scene
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		// Load our content
		loadcontent();
	}

	private void loadcontent()
	{
		SceneManager sceneManager = SceneManager.Instance();
		sceneManager.AddScene(new MainMenu());
		sceneManager.AddScene(new WorldTest());
		sceneManager.LoadScene("WorldTest");
	}

	@Override
	public void render() {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		if(SceneManager.ActiveScene == null) return;
		for (IGameObject g : SceneManager.ActiveScene.Pool())
			if(g.Active()) g.Update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose()
	{
		environment = null;
	}
}