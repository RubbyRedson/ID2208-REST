package se.kth.webservice.third.middleware.formatters;

import org.json.JSONObject;

/**
 * Created by Nick on 2/10/2017.
 */
public class JsonFormatter implements Formatter {
    @Override
    public String format(String input) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("response", input);
        return jsonObject.toString();
    }
}
