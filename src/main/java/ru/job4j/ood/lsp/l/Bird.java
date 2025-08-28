package ru.job4j.ood.lsp.l;

class Bird {
    public Bird getBird() {
        return new Bird();
    }
}

class Ostrich extends Bird {
    @Override
    public Ostrich getBird() {
        return new Ostrich();
    }
}
