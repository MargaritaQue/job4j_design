package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;


import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {
    private final MemoryStore store;

    public XmlReportEngine(MemoryStore store) {
        this.store = store;
    }

    @XmlRootElement(name = "employees")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EmployeesWrapper {
        @XmlElement(name = "employee")
        private List<Employee> employees;

        public EmployeesWrapper() {
        }

        public EmployeesWrapper(List<Employee> employees) {
            this.employees = employees;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        try {
            List<Employee> filteredEmployees = store.findBy(filter);
            EmployeesWrapper wrapper = new EmployeesWrapper(filteredEmployees);

            JAXBContext context = JAXBContext.newInstance(EmployeesWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();

            marshaller.marshal(wrapper, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
