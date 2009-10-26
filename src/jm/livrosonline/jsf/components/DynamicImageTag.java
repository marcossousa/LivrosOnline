package jm.livrosonline.jsf.components;

import com.sun.faces.taglib.html_basic.GraphicImageTag;

public class DynamicImageTag extends GraphicImageTag {
	
	@Override
	public String getComponentType() {
		return UIDynamicImage.FAMILY;
	}

}
