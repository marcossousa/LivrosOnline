package jm.livrosonline.jsf.components;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

import jm.livrosonline.jsf.render.TooltipRender;

public class TooltipTag extends UIComponentELTag {
	private ValueExpression style;
	private ValueExpression styleClass;
	private ValueExpression value;
	
	@Override
	public String getComponentType() {
		return UITooltip.FAMILY;
	}

	public String getDebugString() {
        return "id: " + this.getId() + " class: " +
            this.getClass().getName();
    }

	@Override
	public String getRendererType() {
		return TooltipRender.RENDER_TYPE;
	}

	public ValueExpression getStyle() {
		return style;
	}

	public ValueExpression getStyleClass() {
		return styleClass;
	}

	public ValueExpression getValue() {
		return value;
	}

	@Override
	public void release() {
        super.release();
        this.style = null;
        this.styleClass = null;
        this.value = null;        
    }
	
	@Override
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		component.setValueExpression("style", style);
		component.setValueExpression("styleClass", styleClass);
		component.setValueExpression("value", value);
	}

	public void setStyle(ValueExpression style) {
		this.style = style;
	}
	
	public void setStyleClass(ValueExpression styleClass) {
		this.styleClass = styleClass;
	}

    public void setValue(ValueExpression value) {
		this.value = value;
	}


}
