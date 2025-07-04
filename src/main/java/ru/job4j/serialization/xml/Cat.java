package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "cat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cat {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private String name;

    private String[] statuses;

    public Cat() { }

    public Cat(boolean sex, int age, String name, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", name=" + name
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Cat cat = new Cat(false, 1, "Tolya",
                new String[] {"Vaccinated", "Sterilized"});

        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(cat, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
