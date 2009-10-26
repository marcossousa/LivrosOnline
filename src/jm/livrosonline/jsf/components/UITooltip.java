package jm.livrosonline.jsf.components;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;

import jm.livrosonline.jsf.render.TooltipRender;

public class UITooltip extends UIOutput {
	
	public final static String FAMILY = "jm.livrosonline.tooltip";
	@Override
	public String getFamily() {
		return FAMILY;
	}
	@Override
	public String getRendererType() {
		return TooltipRender.RENDER_TYPE;
	}
	public UIComponent getTootipContent() {
		return getFacets().get("content");
	}
	@Override
	public void restoreState(FacesContext context, Object state) {
		Object[] values = (Object[])state;
	    super.restoreState(context, values[0]);
	    if (values[1] != null) {
			getAttributes().put("value", values[1]);
		}
	    if (values[2] != null) {
			getAttributes().put("style", values[2]);
		}
	    if (values[3] != null) {
			getAttributes().put("styleClass", values[3]);
		}
	}
	@Override
	public Object saveState(FacesContext arg0) {
		Object[] values = new Object[4];
		values[0] = super.saveState(arg0);
		values[1] = getAttributes().get("value");
		values[2] = getAttributes().get("style");
		values[3] = getAttributes().get("styleClass");
		return values;
	}
	public void setTootipContent(UIComponent header) {
		getFacets().put("content", header);
	}
}
