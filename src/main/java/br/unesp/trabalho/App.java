package br.unesp.trabalho;

import br.unesp.trabalho.models.Banda;
import br.unesp.trabalho.models.CD;
import br.unesp.trabalho.models.Cantor;
import br.unesp.trabalho.models.DVD;
import br.unesp.trabalho.repository.CatalogoRepository;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

    }

    public void initialize() {
        Cantor cantor = new Cantor("John", 2.3f);
        Cantor cantor2 = new Cantor("Roki", 22f);
        Banda banda = new Banda("Jwo", 5);
        Banda banda2 = new Banda("Tulipa", 2);

    }
}
