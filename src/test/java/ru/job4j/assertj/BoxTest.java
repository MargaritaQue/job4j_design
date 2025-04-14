package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(3, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isThisUnknownObjectEdge() {
        Box box = new Box(3, 0);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void getNumberOfVertices4() {
        Box box = new Box(4, 4);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4);
    }

    @Test
    void getNumberOfVerticesMinus1() {
        Box box = new Box(3, 6);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(-1);
    }

    @Test
    void objectIsExist() {
        Box box = new Box(4, 4);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void objectIsNotExist() {
        Box box = new Box(3, 4);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(1256.63d, withPrecision(0.008d));
    }

    @Test
    void getAreaTetrahedron() {
        Box box = new Box(4, 4);
        double area = box.getArea();
        assertThat(area).isEqualTo(27.71d, withPrecision(0.003d));
    }

    @Test
    void getAreaCube() {
        Box box = new Box(8, 6);
        double area = box.getArea();
        assertThat(area).isEqualTo(216.0d);
    }
}