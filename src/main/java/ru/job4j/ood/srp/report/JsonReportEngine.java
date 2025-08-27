package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.function.Predicate;

public class JsonReportEngine implements Report {
    private final MemoryStore store;

    public JsonReportEngine(MemoryStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        final Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(store.findBy(filter));
    }

}
