package com.webservices.provider;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * Jackson JSON processor could be controlled via providing a custom Jackson ObjectMapper instan
 * ce. 
 * This could be handy if you need to redefine the default Jackson behavior and to fine-tune how 
 * your JSON data structures look like (copied from Jersey web site). * 
 * @see https://jersey.java.net/documentation/latest/media.html#d0e4799
 */

@Provider
//@Produces({MediaType.APPLICATION_JSON})
//@Consumes(MediaType.APPLICATION_JSON)
//@Singleton
public class MyJacksonJsonProvider implements ContextResolver<ObjectMapper> {
	
    private static final ObjectMapper MAPPER = new ObjectMapper();
    final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static {
      MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      MAPPER.setSerializationInclusion(Include.NON_EMPTY);
      MAPPER.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
      MAPPER.setDateFormat(df);     
      //MAPPER.disable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
      
      /**
       * mapper.enable(SerializationFeature.INDENT_OUTPUT);
// to allow serialization of "empty" POJOs (no properties to serialize)
// (without this setting, an exception is thrown in those cases)
mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
// to write java.util.Date, Calendar as number (timestamp):
mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

// DeserializationFeature for changing how JSON is read as POJOs:

// to prevent exception when encountering unknown property:
mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
// to allow coercion of JSON empty String ("") to null Object value:
mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

// JsonParser.Feature for configuring parsing settings:

// to allow C/C++ style comments in JSON (non-standard, disabled by default)
// (note: with Jackson 2.5, there is also `mapper.enable(feature)` / `mapper.disable(feature)`)
mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
// to allow (non-standard) unquoted field names in JSON:
mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
// to allow use of apostrophes (single quotes), non standard
mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

// JsonGenerator.Feature for configuring low-level JSON generation:

// to force escaping of non-ASCII characters:
mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
       */
    }
 
    public MyJacksonJsonProvider() {
        System.out.println("Instantiate MyJacksonJsonProvider");
    }
     
    @Override
    public ObjectMapper getContext(Class<?> type) {
        System.out.println("MyJacksonProvider.getContext() called with type: "+type);
        return MAPPER;
    } 
}