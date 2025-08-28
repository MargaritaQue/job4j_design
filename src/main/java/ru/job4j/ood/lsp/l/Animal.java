package ru.job4j.ood.lsp.l;

class Animal {
    public String makeSound() {
        return "Some sound";
    }
}

class Dog extends Animal {
    @Override
    public String makeSound() {
        return "Woof";
    }
}

class Cat extends Animal {
    @Override
    public String makeSound() {
        return "Meow";
    }
}

class SilentAnimal extends Animal {
    @Override
    public String makeSound() {
        return null;
    }
}
