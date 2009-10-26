package jm.livrosonline.jsf.render;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import jm.livrosonline.jsf.components.UITooltip;

public class TooltipRender extends Renderer {
	
	public final static String RENDER_TYPE = "jm.livrosonline.render.tooltip";
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		if (!component.isRendered()) {
			return;
		}
		ResponseWriter writer = context.getResponseWriter();
		String id = component.getClientId(context);
		id = id.replaceAll(":", "-");
		writer.startElement("style", component);
		writer.writeAttribute("type", "text/css", "type");
		writer.writeText(generateComponentStyle(id, context.getExternalContext().getRequestContextPath()), component, null);
		writer.endElement("style");
		writer.startElement("a", component);
		writer.writeAttribute("id", id, "id");
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		if (!component.isRendered()) {
			return;
		}
		Map<String, Object> attributes = component.getAttributes();
		
		String id = component.getClientId(context);
		UITooltip tooltip = (UITooltip) component;
		ResponseWriter writer = context.getResponseWriter();
		// container  
		writer.startElement("span", tooltip);
		writer.writeAttribute("id", id + "_tooltip", "id");
		writer.writeAttribute("class", "tooltip", "styleClass");
		// top part
		writer.startElement("span", tooltip);
		writer.writeAttribute("id", id + "_top", "id");
		writer.writeAttribute("class", "top", "styleClass");
		writer.endElement("span");
		// content part
		writer.startElement("span", tooltip);
		writer.writeAttribute("id", id + "_middle", "id");
		writer.writeAttribute("class", "middle", "styleClass");
		// content container
		writer.startElement("div", tooltip);
		writer.writeAttribute("id", id + "_content", "id");
		writer.writeAttribute("class", attributes.get("styleClass"), "styleClass");
		writer.writeAttribute("style", attributes.get("style"), "styleClass");
		// render conntent
		UIComponent content = tooltip.getTootipContent();
		if (content != null) {
			content.encodeBegin(context);
			content.encodeChildren(context);
			content.encodeEnd(context);
		} else {
			writer.writeText(attributes.get("value"), component, null);
		}
		// ends content container
		writer.endElement("div");
		// ends content
		writer.endElement("span");
		// bottom part
		writer.startElement("span", tooltip);
		writer.writeAttribute("id", id + "_bottom", "id");
		writer.writeAttribute("class", "bottom", "styleClass");
		writer.endElement("span");
		// ends container
		writer.endElement("span");

		writer.endElement("a");
	}

	private String generateComponentStyle(String id, String context) {
		StringBuilder css = new StringBuilder();
		css.append("#" + id + " { ");
		css.append("	position:relative; ");
		css.append("	z-index:24; ");
		css.append("	text-decoration:none; ");
		css.append("} ");
		css.append("#" + id + " span.tooltip{ display: none; } ");
		css.append("#" + id + ":hover{ z-index:25; color: #aaaaff; background:;} ");
		css.append("#" + id + ":hover span.tooltip{ ");
		css.append("	display:block; ");
		css.append("	position:absolute; ");
		css.append("	top:0px; left:0; ");
		css.append("	padding: 10px 0 0 0; ");
		css.append("	width:200px; ");
		css.append("	color: #993300; ");
		css.append("	text-align: center; ");
		css.append("	filter: alpha(opacity:95); ");
		css.append("	KHTMLOpacity: 0.95; ");
		css.append("	MozOpacity: 0.95; ");
		css.append("	opacity: 0.95; ");
		css.append("} ");
		css.append("#" + id + ":hover span.top{ ");
		css.append("	display: block; ");
		css.append("	padding: 30px 8px 0; ");
		css.append("	background: url(" + context + "/img/bubble.gif) no-repeat top; ");
		css.append("} ");
		css.append("#" + id + ":hover span.middle, #" + id + ":hover span.middle span{ "); 
		css.append("	display: block; ");
		css.append("	padding: 0 8px;  ");
		css.append("	font-family:\"Trebuchet MS\", Arial, Verdana, sans-serif;  ");
		css.append("	font-size: 12px; ");
		css.append("	background: url(" + context + "/img/bubble_filler.gif) repeat bottom; "); 
		css.append("} ");
		css.append("#" + id + ":hover span.bottom{ ");
		css.append("	display: block; ");
		css.append("	padding:3px 8px 10px; ");
		css.append("	color: #548912; ");
		css.append("	background: url(" + context + "/img/bubble.gif) no-repeat bottom; ");
		css.append("} ");
		return css.toString();
	}
}
