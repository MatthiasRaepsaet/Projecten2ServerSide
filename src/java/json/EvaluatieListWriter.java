package json;

import domein.Evaluatie;
import domein.EvaluatieMoment;
import domein.Onderdeel;
import domein.RijOnderdeel;
import domein.VerkeersOnderdeel;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/*
 * Deze klasse is een JAX-RS provider die een List<Evaluatie> kan uitschrijven als JSON.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class EvaluatieListWriter implements MessageBodyWriter<List<Evaluatie>> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (!List.class.isAssignableFrom(type)) {
            return false;
        }

        // Het volgende stukje code controleert of de List wel een List<Evaluatie> was.
        if (genericType instanceof ParameterizedType) {
            Type[] arguments = ((ParameterizedType) genericType).getActualTypeArguments();
            return arguments.length == 1 && arguments[0].equals(Evaluatie.class);
        } else {
            return false;
        }
    }

    @Override
    public long getSize(List<Evaluatie> evaluaties, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(List<Evaluatie> evaluaties, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        JsonArrayBuilder jsonEvaluaties = Json.createArrayBuilder();

        for (Evaluatie evaluatie : evaluaties) {
            JsonObjectBuilder jsonEvaluatie = Json.createObjectBuilder();

            jsonEvaluatie.add("evaluatieNummer", evaluatie.getEvaluatieNummer());
            jsonEvaluatie.add("rijtechniekenScore", evaluatie.getRijtechniekenScore());
            jsonEvaluatie.add("verkeerstechniekenScore", evaluatie.getRijtechniekenScore());
            jsonEvaluatie.add("algemeneScore", evaluatie.getAlgemeneScore());
            jsonEvaluatie.add("algemeneOpmerkingen", evaluatie.getAlgemeneOpmerkingen());
            jsonEvaluatie.add("rotonde", evaluatie.getRotonde().getHexValue());
            jsonEvaluatie.add("steenweg", evaluatie.getSteenweg().getHexValue());
            jsonEvaluatie.add("bebouwdeKom", evaluatie.getBebouwdeKom().getHexValue());
            jsonEvaluatie.add("autostrade", evaluatie.getAutostrade().getHexValue());

            JsonArrayBuilder jsonEvaluatieMomenten = Json.createArrayBuilder();
            for (EvaluatieMoment evam : evaluatie.getEvaLijst()) {
                JsonObjectBuilder jsonEvaluatieMoment = Json.createObjectBuilder();
                jsonEvaluatieMoment.add("id", evam.getId());
                jsonEvaluatieMoment.add("naam", evam.getNaam());
                JsonArrayBuilder jsonRijtechniekOnderdelen = Json.createArrayBuilder();
                for (RijOnderdeel o : evam.getRijtechniekOnderdelen()) {
                    JsonObjectBuilder jsonRijtechniekOnderdeel = Json.createObjectBuilder();
                    jsonRijtechniekOnderdeel.add("rijtechniekOnderdeelId", o.getOnderdeelId());
                    jsonRijtechniekOnderdeel.add("rijtechniekOnderdeelNaam", o.getNaam());
                    jsonRijtechniekOnderdeel.add("rijtechniekOnderdeelKleur", o.getKleur().getHexValue());

//                    JsonArrayBuilder jsonRijtechniekOnderdelenOpmerkingen = Json.createArrayBuilder();
//                    for(String opmerking : o.getOpmerkingen()){
//                        jsonRijtechniekOnderdelenOpmerkingen.add(opmerking);
//                    }
//                    jsonRijtechniekOnderdeel.add("rijtechniekOpmerkingen", jsonRijtechniekOnderdelenOpmerkingen);
                    jsonRijtechniekOnderdelen.add(jsonRijtechniekOnderdeel);
                }
                jsonEvaluatieMoment.add("rijtechniekOnderdelen", jsonRijtechniekOnderdelen);

                JsonArrayBuilder jsonVerkeerstechniekOnderdelen = Json.createArrayBuilder();
                for (VerkeersOnderdeel o : evam.getVerkeerstechniekOnderdelen()) {
                    JsonObjectBuilder jsonVerkeerstechniekOnderdeel = Json.createObjectBuilder();
                    jsonVerkeerstechniekOnderdeel.add("verkeerstechniekOnderdeelId", o.getOnderdeelId());
                    jsonVerkeerstechniekOnderdeel.add("verkeerstechniekOnderdeelNaam", o.getNaam());
                    jsonVerkeerstechniekOnderdeel.add("verkeertechniekOnderdeelKleur", o.getKleur().getHexValue());

//                    JsonArrayBuilder jsonVerkeerstechniekOnderdelenOpmerkingen = Json.createArrayBuilder();
//                    for(String opmerking : o.getOpmerkingen()){
//                        jsonVerkeerstechniekOnderdelenOpmerkingen.add(opmerking);
//                    }
//                    jsonVerkeerstechniekOnderdeel.add("verkeerstechniekOpmerkingen", jsonVerkeerstechniekOnderdelenOpmerkingen);
                    jsonVerkeerstechniekOnderdelen.add(jsonVerkeerstechniekOnderdeel);
                }
                jsonEvaluatieMoment.add("verkeersTechniekOnderdelen", jsonVerkeerstechniekOnderdelen);
                jsonEvaluatieMomenten.add(jsonEvaluatieMoment);
            }
            jsonEvaluatie.add("evaLijst", jsonEvaluatieMomenten);

            jsonEvaluatie.add("links1", evaluatie.getLinks1().getHexValue());
            jsonEvaluatie.add("links2", evaluatie.getLinks2().getHexValue());
            jsonEvaluatie.add("links3", evaluatie.getLinks3().getHexValue());
            jsonEvaluatie.add("rechts1", evaluatie.getRechts1().getHexValue());
            jsonEvaluatie.add("rechts2", evaluatie.getRechts2().getHexValue());
            jsonEvaluatie.add("rechts3", evaluatie.getRechts3().getHexValue());

            jsonEvaluaties.add(jsonEvaluatie);
        }

        try (JsonWriter out = Json.createWriter(entityStream)) {
            out.writeArray(jsonEvaluaties.build());
        }
    }
}
