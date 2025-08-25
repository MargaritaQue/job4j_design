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
        double res = currency.convert(source, worker.getSalary(), target);
        Report engine = new AccountingReport(store, source, target);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary; SalaryConvert;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary()).append(" ")
                .append(res)
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

}