package se.kth.webservice.third.middleware;

import se.kth.webservice.third.middleware.formatters.JsonFormatter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by Nick on 2/10/2017.
 */
@Provider
public class FormatOutput implements ContainerResponseFilter {
    JsonFormatter jsonFormatter = new JsonFormatter();

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

        MultivaluedMap<String, String> requestParams = containerRequestContext.getUriInfo().getQueryParameters();
        containerResponseContext.setEntity(jsonFormatter.format(containerResponseContext.getEntity().toString()));
    }
}
