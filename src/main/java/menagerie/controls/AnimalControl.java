package menagerie.controls;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import menagerie.objects.animals.Animal;

public abstract class AnimalControl extends AbstractControl {
	protected Animal animal;

	public AnimalControl() {
	}

	@Override
	protected void controlUpdate(float tpf) {
	}

	@Override
	protected void controlRender(RenderManager rm, ViewPort vp) {
	}
}
