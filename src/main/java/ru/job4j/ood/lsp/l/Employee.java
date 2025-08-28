package ru.job4j.ood.lsp.l;

class Employee {
    public double getSalary() {
        return 1000;
    }
}

class Manager extends Employee {
    @Override
    public double getSalary() {
        return super.getSalary() + 500;
    }
}