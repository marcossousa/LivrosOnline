package jm.livrosonline.jsf.components;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

// imports foram omitidos

public class UIDynamicImage extends HtmlGraphicImage{

	public static final String FAMILY = "jm.livrosonline.BinaryGraphicImage";
	public static final String MAPPING = "jm.jsf.DEFAULT_MAPPING";

	public static String getViewID() {
		return "DynamicImage";
	}
	
	Random random = new Random();
	
	private String buildImagemURI(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String mapping = extContext.getInitParameter(MAPPING);
        mapping = mapping == null || "".equals(mapping)
                ? "*.jsf"
                : mapping;
        mapping = mapping.replace("*", getViewID() + "/key/" + key);
        mapping = mapping.startsWith("/")
                ? mapping
                : "/" + mapping;
        return extContext.getRequestContextPath() + mapping;
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		if (super.getValue() instanceof byte[]) {
			byte[] image = (byte[]) super.getValue();
			Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
			String key = (Integer.toHexString(FAMILY.hashCode()) + "_" 
					+ Integer.toHexString(random.nextInt(Integer.MAX_VALUE)));
			sessionMap.put(key, image);
			writer.startElement("img", this);
			writer.writeAttribute("id", getClientId(context), null);
			writer.writeAttribute("src", buildImagemURI(key), null);
			// set other HTML attributes
			if (getAttributes() != null) {
				String[] imgAttributes = { "align", "alt", "border", "height", 
						"hspace", "ismap", "longdesc", "usemap", "vspace", "width", 
						"dir", "lang", "title", "style", "styleClass", "ondblclick",
				        "onmousedown", "onmouseup", "onmouseover", "onmousemove",
				        "onmouseout", "onkeypress", "onkeydown",  "onkeyup",
				        "onclick" };
				for (String property : imgAttributes) {
					Object value = getAttributes().get(property);
					String htmlProperty = "styleClass".equals(property) ? "class" : property;
					if (!"src".equals(property) && value != null) {
						writer.writeAttribute(htmlProperty, value, property);
					}
				}
			}
			writer.endElement("img");
		} else {
			throw new IllegalArgumentException("value must byte[] instance type");
		}
	}
	
	@Override
	public void encodeChildren(FacesContext arg0) throws IOException {}
	
	@Override
	public void encodeEnd(FacesContext arg0) throws IOException {}

	@Override
	public String getFamily() {
		return FAMILY;
	}

	@Override
	protected Renderer getRenderer(FacesContext context) {
		return null;
	}
}
