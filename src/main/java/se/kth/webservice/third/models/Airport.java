package se.kth.webservice.third.models;

import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2017-02-06.
 */
public class Airport extends Model{

    private int id;
    private String name;
    private String city;
    private String country;
    private String iata;
    private String icao;
    private float lat;
    private float lng;
    private int altitudeFeet;
    private String timezone;
    private String dst;
    private String tzDb;
    private String type;
    private String source;

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", iata='" + iata + '\'' +
                ", icao='" + icao + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", altitudeFeet=" + altitudeFeet +
                ", timezone='" + timezone + '\'' +
                ", dst='" + dst + '\'' +
                ", tzDb='" + tzDb + '\'' +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public int getAltitudeFeet() {
        return altitudeFeet;
    }

    public void setAltitudeFeet(int altitudeFeet) {
        this.altitudeFeet = altitudeFeet;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getTzDb() {
        return tzDb;
    }

    public void setTzDb(String tzDb) {
        this.tzDb = tzDb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("name", name);
        obj.put("city", city);
        obj.put("country", country);
        obj.put("iata", iata);
        obj.put("icao", icao);
        obj.put("lat", lat);
        obj.put("lng", lng);
        obj.put("altitudeFeet", altitudeFeet);
        obj.put("timezone", timezone);
        obj.put("dst", dst);
        obj.put("tzDb", tzDb);
        obj.put("type", type);
        obj.put("source", source);

        return obj;
    }



    @Override
    protected Class getModelClass() {
        return Airport.class;
    }

    @Override
    protected Object getChildInstance() {
        return this;
    }

    @Override
    public String toPlain() {
        return toString();
    }
}
