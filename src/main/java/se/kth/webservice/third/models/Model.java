package se.kth.webservice.third.models;

import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ObjectInput;
import java.io.StringWriter;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
public abstract class Model {

    public abstract JSONObject toJson();
    protected abstract java.lang.Class getModelClass();
    protected abstract Object getChildInstance();
    public abstract String toPlain();


    public String toXml() {

        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(getModelClass());
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            StringWriter sw = new StringWriter();
            m.marshal(getChildInstance(), sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return xmlString;
    }
}
