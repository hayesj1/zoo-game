package main.java.menagerie;

import com.jme3.app.SimpleApplication;
import com.jme3.input.ChaseCamera;
import com.jme3.light.AmbientLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;

public class Menagerie extends SimpleApplication {

	private Spatial cube;
	private ChaseCamera chaseCam;

	public static void main(String[] args) {
		Menagerie game = new Menagerie();
		game.start();
	}

	@Override
	public void simpleInitApp() {
		speed = 1.0f;
		chaseCam = new ChaseCamera(cam, inputManager);

		Material matCube = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		Box meshCube = new Box(1.0f, 1.0f, 1.0f);

		Material matSphere = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		Sphere meshSphere = new Sphere(64, 64, 1.5f);

		cube = new Geometry("TEST-cube", meshCube);
		Spatial sphere = new Geometry("TEST-sphere", meshSphere);

		matCube.setColor("Color", ColorRGBA.Red);
		matSphere.setColor("Color", ColorRGBA.Green);

		cube.setMaterial(matCube);
		sphere.setMaterial(matSphere);
		sphere.move(1.0f, 0.0f, 2.0f);

		cube.addControl(chaseCam);

		rootNode.attachChild(cube);
		rootNode.attachChild(sphere);
		initLighting();

	}

	private void initLighting() {
		// We add light so we see the scene
		AmbientLight al = new AmbientLight();
		al.setColor(ColorRGBA.White.mult(1.3f));
		rootNode.addLight(al);
	}

	@Override
	public void simpleUpdate(float tpf) {
		super.simpleUpdate(tpf);

		cube.rotate(0.0f, 5.0f * tpf, 0.0f);

	}
}
