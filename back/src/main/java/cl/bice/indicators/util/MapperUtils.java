package cl.bice.indicators.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class MapperUtils {
    public static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);

    private static String CHARSET_DEFAULT = "UTF-8";

    public static <T extends List<?>> T cast(Object obj) {
        return (T) obj;
    }

    public static <T> T castStringToClass(String value, Class<?> target) {
        try {
            return stringToClass(value, target);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T castStringToClass(String value, boolean decoded, Class<?> target) {
        try {
            if (decoded) {
                value = new String(Base64.getDecoder().decode(value.getBytes()), CHARSET_DEFAULT);
            }
            return stringToClass(value, target);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T castStringToClass(String value, boolean decoded, boolean toList, Class<?> target) {
        try {
            if (decoded) {
                value = new String(Base64.getDecoder().decode(value.getBytes()), CHARSET_DEFAULT);
            }
            return toList ? stringToListClass(value, target) : stringToClass(value, target);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T castObjectToClass(Object value, Class<?> target) {
        try {
            return objectToClass(value, target);
        } catch (Exception e) {
            return null;
        }
    }

    public static String castClassToString(Object target) {
        try {
            return classToString(target);
        } catch (Exception e) {
            return null;
        }
    }

    public static String castClassToString(Object target, boolean encoded) {

        try {
            String response = MAPPER.writeValueAsString(target);
            if (encoded) {
                response = Base64.getEncoder().encodeToString(response.getBytes());
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T stringToClass(String value, Class<?> target) throws ClassNotFoundException, IOException {
        return MAPPER.readValue(value, MAPPER.getTypeFactory().constructType(Class.forName(target.getName())));
    }


    public static <T> T objectToClass(Object value, Class<?> target) throws ClassNotFoundException {
        return MAPPER.convertValue(value, MAPPER.getTypeFactory().constructType(Class.forName(target.getName())));
    }

    public static String classToString(Object value) throws JsonProcessingException {
        return MAPPER.writeValueAsString(value);
    }

    static JavaType listOf(Class clase) {
        return TypeFactory.defaultInstance().constructCollectionType(List.class, clase);
    }


    public static <T> T stringToListClass(String value, Class<?> target) throws IOException {
        return MapperUtils.MAPPER.readValue(value, MapperUtils.listOf(target));
    }
};

