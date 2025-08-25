package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class AccountingReport implements Report {
    private final Store store;
    private final Currency source;
    private final Currency target;

    public AccountingReport(Store store, Currency source, Currency target) {
        this.store = store;
        this.source = source;
        this.target = target;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        InMemoryCurrencyConverter currency = new InMemoryCurrencyConverter();

        StringBuilder text = new StringBuilder();
        text.append("Name; Salary; SalaryConvert;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary()).append(" ")
                    .append(currency.convert(source, employee.getSalary(), target))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
