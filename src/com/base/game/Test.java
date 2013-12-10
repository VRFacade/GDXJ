package com.base.game;

import com.base.engine.*;

public class Test
{
	public static void main(String[] args)
	{
		Engine.init(new Game(),new RenderingEngine(), 800, 600, "3D Engine", false);
		
		Material bricks = new Material(new Texture("color_map.jpg"), new Vector3f(1,1,1), 1, 8);
		bricks.setNormalTexture(new Texture("normal_map.jpg"));
		bricks.setBumpTexture(new Texture("height_map.jpg"));
		bricks.setSpecularIntensity(0.25f);
		bricks.setSpecularPower(1);
		
		GameObject cube = new GameObject(new RenderableMesh(Mesh.getCube(), bricks));
		cube.addComponent(new ChaseComponent());
		cube.getTransform().move(new Vector3f(0,-0.5f,2));
		cube.getTransform().rotate(new Vector3f(0,30,0));
		cube.getTransform().scale(new Vector3f(12,7,5));
		
		GameObject cube2 = new GameObject(new RenderableMesh(Mesh.getCube(), bricks));
		//cube.addComponent(new ChaseComponent());
		cube2.getTransform().move(new Vector3f(3,-0.5f,7));
		cube2.getTransform().rotate(new Vector3f(0,-30,0));
		
		GameObject floor = new GameObject(new RenderableMesh(Mesh.getPlane(), Material.getDefaultMaterial()));
		floor.getTransform().scale(30);
		floor.setCastShadows(false);
		floor.getTransform().move(new Vector3f(0,-1,3));
		
		Engine.getGame().addObject(cube);
		Engine.getGame().addObject(cube2);
		Engine.getGame().addObject(floor);
		
//		Engine.getRenderer().setDirectionalLight(new DirectionalLight(Vector3f.ZERO, 0, Vector3f.ZERO));
//		Engine.getRenderer().setSpotLights(new SpotLight[] {new SpotLight(new PointLight(new BaseLight(new Vector3f(0,1f,1f), 0.8f), new Attenuation(0,0,0.3f), new Vector3f(-2,0.5f,5f), 30),
//									  new Vector3f(1,-1,-1), 0.7f)});
		
		Engine.start();
	}
}
