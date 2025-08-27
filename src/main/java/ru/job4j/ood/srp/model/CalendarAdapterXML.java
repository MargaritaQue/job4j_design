package ru.job4j.ood.srp.model;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarAdapterXML extends XmlAdapter<String, Calendar> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar unmarshal(String v) throws Exception {
        Date date = dateFormat.parse(v);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    @Override
    public String marshal(Calendar v) throws Exception {
        return dateFormat.format(v.getTime());
    }
}
