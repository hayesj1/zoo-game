package menagerie.controls;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;

public class BreedableControl extends AbstractControl {
	protected float cooldown;
	protected float cooldownSpeed = 1.0f;
	protected boolean ready;
	protected boolean isFemale;
	protected boolean laysEggs;
	protected boolean gestates;
	protected boolean gestating;

	public BreedableControl() {
	}

	@Override
	protected void controlUpdate(float tpf) {

	}

	@Override
	protected void controlRender(RenderManager rm, ViewPort vp) {
	}
}
