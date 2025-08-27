package ru.job4j.ood.srp.model;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapter implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

  @Override
  public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext context) {
    return new JsonPrimitive(DATE_FORMAT.format(calendar.getTime()));
  }

  @Override
  public Calendar deserialize(JsonElement json, Type type, JsonDeserializationContext context)
      throws JsonParseException {
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(DATE_FORMAT.parse(json.getAsString()));
      return calendar;
    } catch (Exception e) {
      throw new JsonParseException(e);
    }
  }
}
