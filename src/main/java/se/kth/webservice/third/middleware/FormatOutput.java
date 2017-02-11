package se.kth.webservice.third.middleware;

import org.json.JSONArray;
import org.json.JSONObject;
import se.kth.webservice.third.middleware.formatters.JsonFormatter;
import se.kth.webservice.third.models.Model;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nick on 2/10/2017.
 */
@Provider
public class FormatOutput implements ContainerResponseFilter {
    JsonFormatter jsonFormatter = new JsonFormatter();


    private String buildJsonArray(List<Model> models){
        JSONArray arr = new JSONArray();

        for(int i = 0; i < models.size(); i++){
            arr.put(models.get(i).toJson());
        }

        return arr.toString();
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

        MultivaluedMap<String, String> requestParams = containerRequestContext.getUriInfo().getQueryParameters();

        if(containerResponseContext.getEntityClass() == List.class){
            System.out.println("This is a list");

            List<Model> models = (List<Model>) (List<?>)containerResponseContext.getEntity();

            //The defualt output is json
            if(!requestParams.containsKey("out") || requestParams.get("out").equals("json")){
                containerResponseContext.setEntity(buildJsonArray(models));
            }else if(requestParams.get("out").equals("xml")){
                //use xml
            }else {
                //use plaintext
            }

        }else{
            System.out.println("This is a single object");
        }


        //JSONObject o = (JSONObject) containerResponseContext.getEntity();

        //containerResponseContext.setEntity(jsonFormatter.format(containerResponseContext.getEntity().toString()));
    }
}
