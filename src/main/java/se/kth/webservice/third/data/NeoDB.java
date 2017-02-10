package se.kth.webservice.third.data;

import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Path;
import org.neo4j.driver.v1.types.Relationship;
import se.kth.webservice.third.models.TravelPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by victoraxelsson on 2017-02-06.
 */
public class NeoDB {

    private Driver driver;
    private Session session;


    public NeoDB(){
        driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( "neo4j", "root" ) );
        session = driver.session();
    }

    private TravelPath buildPaths(Path p){
        HashMap<String, Node> nodeMap = new HashMap<String, Node>();

        Node n = null;
        Iterator<Node> iterator = p.nodes().iterator();
        while (iterator.hasNext()){
            n = iterator.next();
            nodeMap.put(n.id() + "", n);
        }

        TravelPath previous = null;
        TravelPath start = null;
        Relationship r = null;
        HashMap<String, TravelPath> travelPaths = new HashMap<String, TravelPath>();
        Iterator<Relationship> relationIterator = p.relationships().iterator();
        while (relationIterator.hasNext()){
             r = relationIterator.next();

             if(r.hasType("OUTGOING_FLIGHT")){
                Node startNode = nodeMap.get(r.startNodeId() + "");
                Node endNode = nodeMap.get(r.endNodeId() + "");

                TravelPath tp = new TravelPath();
                tp.setRouteId((endNode.get("id") + "").replaceAll("\"", ""));
                if(previous != null){
                    previous.setNext(tp);
                }

                if(start == null){
                    start = tp;
                }

                travelPaths.put(endNode.id() + "", tp);

                tp.setFrom(startNode.get("name") + "");
                tp.setLabel("Travel from " + startNode.get("name") + " to " + endNode.get("destinationAirport"));

             }else if(r.hasType("INCOMMING_FLIGHT")){
                 Node startNode = nodeMap.get(r.startNodeId() + "");
                 Node endNode = nodeMap.get(r.endNodeId() + "");

                 TravelPath tp = travelPaths.get(startNode.id() + "");
                 previous = tp;

                 tp.setTo(endNode.get("name") + "");
                 tp.setLabel("Travel from " + tp.getFrom() + " and land in " +
                         endNode.get("name"));
             }
        }

        return start;
    }

    public List<TravelPath> getRoutes(String fromAirportId, String toAirportId){

        //From = 12, to = 55;

        /*
        StatementResult result = session.run("MATCH path = \n" +
                "(a1:Airport {id: {fromId}})-[:OUTGOING_FLIGHT]->(:Route)-[:INCOMMING_FLIGHT]->\n" +
                "(:Airport)-[:OUTGOING_FLIGHT]->(:Route)-[:INCOMMING_FLIGHT]->\n" +
                "(:Airport)-[:OUTGOING_FLIGHT]->(:Route)-[:INCOMMING_FLIGHT]->\n" +
                "(:Airport)-[:OUTGOING_FLIGHT]->(:Route)-[:INCOMMING_FLIGHT]->\n" +
                "(:Airport)-[:OUTGOING_FLIGHT]->(:Route)-[:INCOMMING_FLIGHT]->\n" +
                "(:Airport)-[:OUTGOING_FLIGHT]->(:Route)-[:INCOMMING_FLIGHT]->\n" +
                "(a3:Airport {id: {toId}}) return path",
                parameters("fromId", fromAirportId, "toId", toAirportId));
                */

        String query = "MATCH (a:Airport { id: {fromId} }),(b:Airport { id: {toId} }), path = shortestPath((a)-[*..15]->(b)) RETURN path";
        StatementResult result = session.run(query, parameters("fromId", fromAirportId, "toId", toAirportId));


        List<TravelPath> availableTravelPaths = new ArrayList<TravelPath>();
        while ( result.hasNext() )
        {
            Record record = result.next();
            Path path = record.get("path").asPath();

            TravelPath p = buildPaths(path);
            availableTravelPaths.add(p);
        }

        return availableTravelPaths;
    }


}
