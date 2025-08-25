package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.currency.Currency.*;

class AccountingReportTest {

    @Test
    public void whenOldGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Currency source = RUB;
        Currency target = EUR;

        InMemoryCurrencyConverter currency = new InMemoryCurrencyConverter();

        Report engine = new AccountingReport(store, source, target);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary; SalaryConvert;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary()).append(" ")
                .append(currency.convert(source, worker.getSalary(), target))
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

    @Test
    public void when2Employees() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Alice", now, now, 200);
        store.add(worker);
        store.add(worker1);
        Currency source = RUB;
        Currency target = EUR;

        InMemoryCurrencyConverter currency = new InMemoryCurrencyConverter();

        Report engine = new AccountingReport(store, source, target);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary; SalaryConvert;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary()).append(" ")
                .append(currency.convert(source, worker.getSalary(), target))
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary()).append(" ")
                .append(currency.convert(source, worker1.getSalary(), target))
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

    @Test
    public void when3Employees() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Alice", now, now, 200);
        Employee worker2 = new Employee("Petr", now, now, 300);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        Currency source = RUB;
        Currency target = EUR;

        InMemoryCurrencyConverter currency = new InMemoryCurrencyConverter();

        Report engine = new AccountingReport(store, source, target);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary; SalaryConvert;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary()).append(" ")
                .append(currency.convert(source, worker.getSalary(), target))
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary()).append(" ")
                .append(currency.convert(source, worker1.getSalary(), target))
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary()).append(" ")
                .append(currency.convert(source, worker2.getSalary(), target))
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

}