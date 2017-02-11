package se.kth.webservice.third.middleware;

import org.json.JSONArray;
import org.json.JSONObject;
import se.kth.webservice.third.models.Model;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by Nick on 2/10/2017.
 */
@Provider
public class FormatOutput implements ContainerResponseFilter {


    private String buildJsonArray(List<Model> models){
        JSONArray arr = new JSONArray();

        for(int i = 0; i < models.size(); i++){
            arr.put(models.get(i).toJson());
        }

        return arr.toString();
    }

    private String buildXMLArray(List<Model> models){

        throw new NotImplementedException();
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

        MultivaluedMap<String, String> requestParams = containerRequestContext.getUriInfo().getQueryParameters();

        String out = requestParams.get("out") == null || requestParams.get("out").size() <= 0 ? "json" : requestParams.get("out").get(0);

        if(containerResponseContext.getEntityClass() == List.class){
            System.out.println("This is a list");

            List<Model> models = (List<Model>) (List<?>)containerResponseContext.getEntity();


            //The defualt output is json
            if(out.equals("json")){
                containerResponseContext.setEntity(buildJsonArray(models));
            }else if(out.equals("xml")){
                //use xml
                containerResponseContext.setEntity(buildXMLArray(models));
            }else if(out.equals("plain")){
                //use plaintext
                containerResponseContext.setEntity(buildPlainArray(models));
            }

        }else if(containerResponseContext.getEntityClass() == Model.class){

            Model model = (Model)containerResponseContext.getEntity();
            //The defualt output is json
            if(out.equals("json")){
                containerResponseContext.setEntity(model.toJson().toString());
            }else if(out.equals("xml")){
                //use xml
                containerResponseContext.setEntity(model.toXml());
            }else if(out.equals("plain")){
                //use plaintext
                containerResponseContext.setEntity(model.toPlain());
            }

            System.out.println("This is a single object");
        }else{

        }


        //JSONObject o = (JSONObject) containerResponseContext.getEntity();

        //containerResponseContext.setEntity(jsonFormatter.format(containerResponseContext.getEntity().toString()));
    }

    private String buildPlainArray(List<Model> models) {

        String res = "";

        for(int i = 0; i < models.size(); i++){
           res += models.get(0).toPlain();
        }

        return res;

    }
}
