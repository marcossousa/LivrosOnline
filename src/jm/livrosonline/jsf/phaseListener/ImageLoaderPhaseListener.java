package jm.livrosonline.jsf.phaseListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jm.livrosonline.jsf.components.UIDynamicImage;

public class ImageLoaderPhaseListener implements PhaseListener {
	private static final long serialVersionUID = -2711890280803223561L;
	private static String getResourceKey(String viewId){
        String resource = viewId.substring(viewId.lastIndexOf('/') + 1, viewId.length());
        resource = resource.indexOf('.') != -1 ? resource.substring(0, resource.indexOf('.')) : resource;
        return resource;
    }

    public static DateFormat htmlExpiresDateFormat(){
        DateFormat httpDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        httpDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return httpDateFormat;
    }

	public void afterPhase(PhaseEvent event) {
		
	}

	public void beforePhase(PhaseEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
        String viewRootId = ((HttpServletRequest)facesContext.getExternalContext().getRequest()).getRequestURI();
        if (viewRootId != null && viewRootId.indexOf(UIDynamicImage.getViewID()) != -1){
            serveResource(facesContext, viewRootId);
        }
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	private void serveResource(FacesContext facesContext, String viewId){
		try {
			Map<String, Object>  sessionMap = facesContext.getExternalContext().getSessionMap();
			String resourceKey = getResourceKey(viewId);
			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			if (!sessionMap.containsKey(resourceKey)) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found");
				facesContext.responseComplete();
			} else {
				Object obj = sessionMap.remove(resourceKey);
				if (obj instanceof byte[]) {
					response.setStatus(HttpServletResponse.SC_OK);
					Calendar c = Calendar.getInstance();
                    c.add(Calendar.SECOND, 3600000);
                    response.setHeader("Pragma", "cache");
                    response.setHeader("Cache-Control", "PUBLIC, max-age=" + 360000000);
                    response.setHeader("Expires", htmlExpiresDateFormat().format(c.getTime()));
					ServletOutputStream os = response.getOutputStream();
					os.write((byte[])obj);
					os.flush();
					os.close();
					facesContext.responseComplete();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Error loading resource", e);
		}
	}
}