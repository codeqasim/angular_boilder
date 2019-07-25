package com.sugar.boilerplate.Network.Utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.DateFormat;

public class GsonUtil {

    private static GsonUtil instance;
    private Gson gson;

    private GsonUtil() {

        gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new StringAdapter())
                .serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .setLenient()
                .create();
    }

    public static GsonUtil ins() {
        if (instance == null) {
            instance = new GsonUtil();
        }
        return instance;
    }

    public Gson getGson() {
        return gson;
    }

    public String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static class StringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                reader.setLenient(true);
                return "";
            }
            return reader.nextString();
        }
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                writer.setLenient(true);
                return;
            }
            writer.value(value);
        }
    }

}