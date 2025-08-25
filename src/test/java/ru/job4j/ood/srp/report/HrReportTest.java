package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class HrReportTest {

    @Test
    public void when2Employees() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Alice", now, now, 200);
        store.add(worker);
        store.add(worker1);

        Report engine = new HrReport(store);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary())
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

        Report engine = new HrReport(store);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}