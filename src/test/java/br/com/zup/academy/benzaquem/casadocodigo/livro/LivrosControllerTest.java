package br.com.zup.academy.benzaquem.casadocodigo.livro;

import br.com.zup.academy.benzaquem.casadocodigo.autor.Autor;
import br.com.zup.academy.benzaquem.casadocodigo.autor.AutorRepository;
import br.com.zup.academy.benzaquem.casadocodigo.categoria.Categoria;
import br.com.zup.academy.benzaquem.casadocodigo.categoria.CategoriaRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LivrosControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;


    @Test
    @Order(1)
    public void livroCadastradoComSucessoRetorna200() throws Exception {
        Autor autor = new Autor("Gang of Four", "gangoffour@designpatterns.com", "Erich Gamma, John Vlissides, Richard Helm, Ralph Johnson");
        Categoria categoria = new Categoria("Software Engineering");
        autor = autorRepository.save(autor);
        categoria = categoriaRepository.save(categoria);

        String requestSuccess = "{ \n" +
                "    \"titulo\":\"Design Patterns: Elements of Reusable Object-Oriented Software\",\n" +
                "    \"resumo\":\"is a software engineering book describing software design patterns. The book was written by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides, with a foreword by Grady Booch. The book is divided into two parts, with the first two chapters exploring the capabilities and pitfalls of object-oriented programming, and the remaining chapters describing 23 classic software design patterns. The book includes examples in C++ and Smalltalk.\",\n" +
                "    \"sumario\":\"## Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides *I, [Michael Parker](http://omgitsmgp.com/), own this book and took these notes to further my own learning. If you enjoy these notes, please [purchase the book](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)!* ### Chapter 1: Introduction * Expert designers know not to solve every problem from first principles, but reuse good solutions. This experience makes them experts. * A design pattern names, abstracts, and identifies the key aspects of a common design structure that make it useful for creating a reusable object-oriented design. * The hard part of object-oriented design is decomposing a system into objects, which is difficult because encapsulation, granularity, dependency, flexibility, performance, evolution, reusability, and more come into play. * When designing, strict modeling of the real world leads to a system that reflects today's realities not but not necessarily tomorrow's. Abstractions are key to making a design flexible. * Dynamic binding means that invoking a method doesn't commit to a particular implementation until runtime. * An object's class refers to how it's implemented, while an object's type refers to only its interface. * Class inheritance is a mechanism for code reuse and representation sharing, while interface inheritance describes when an object can be used in place of another. * Inheritance's ability to define families of objects with identical interfaces is important because polymorphism depends on it. * By manipulating objects through the interface of their abstract class, clients remain unaware of the specific types of objects they use, and the classes that implement them. This reduces implementation dependencies. * Class inheritance is white-box reuse, because parent class internals are visible, while object composition is black-box reuse, because no internal details are visible. * Class inheritance is directly supported by the programming language, and makes it easy to modify the implementation being reused. * But class inheritance is fixed at compile-time, and breaks encapsulation, where the subclass becomes strongly coupled to the parent class. The parent class can change and become unsuitable for extension. * Composition, unlike inheritance, doesn't break encapsulation, and there are fewer implementation dependencies. Also, it helps you keep each class encapsulated and focused on one task. * Advantage of delegation is that you can compose behaviors at runtime, and change the way they're composed. It's an extreme example of object composition. * Disadvantages of delegation are that dynamic nature can be hard to understand, and there can be runtime inefficiencies. Only use it when it simplifies, not complicates. * A design that doesn't take change into account risks major redesign in the future. Unanticipated changes are invariably expensive.\",\"preco\": 199.99,\n" +
                "        \"pag\": 395,\n" +
                "        \"isbn\":\"0-201-63361-2\",\n" +
                "        \"lancamento\":\"28/09/2021\",\n" +
                "        \"autor\":"+autor.getId()+",\n" +
                "        \"categoria\":"+categoria.toResponse().getId()+"\n" +
                "}";

        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestSuccess)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    @Order(2)
    public void livroComTituloRepedidoRetorna400() throws Exception {
        Autor autor = autorRepository.findByEmail("gangoffour@designpatterns.com").get();
        Categoria categoria = categoriaRepository.findByNome("Software Engineering").get();

        String requestSuccess = "{ \n" +
                "    \"titulo\":\"Design Patterns: Elements of Reusable Object-Oriented Software\",\n" +
                "    \"resumo\":\"is a software engineering book describing software design patterns. The book was written by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides, with a foreword by Grady Booch. The book is divided into two parts, with the first two chapters exploring the capabilities and pitfalls of object-oriented programming, and the remaining chapters describing 23 classic software design patterns. The book includes examples in C++ and Smalltalk.\",\n" +
                "    \"sumario\":\"## Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides *I, [Michael Parker](http://omgitsmgp.com/), own this book and took these notes to further my own learning. If you enjoy these notes, please [purchase the book](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)!* ### Chapter 1: Introduction * Expert designers know not to solve every problem from first principles, but reuse good solutions. This experience makes them experts. * A design pattern names, abstracts, and identifies the key aspects of a common design structure that make it useful for creating a reusable object-oriented design. * The hard part of object-oriented design is decomposing a system into objects, which is difficult because encapsulation, granularity, dependency, flexibility, performance, evolution, reusability, and more come into play. * When designing, strict modeling of the real world leads to a system that reflects today's realities not but not necessarily tomorrow's. Abstractions are key to making a design flexible. * Dynamic binding means that invoking a method doesn't commit to a particular implementation until runtime. * An object's class refers to how it's implemented, while an object's type refers to only its interface. * Class inheritance is a mechanism for code reuse and representation sharing, while interface inheritance describes when an object can be used in place of another. * Inheritance's ability to define families of objects with identical interfaces is important because polymorphism depends on it. * By manipulating objects through the interface of their abstract class, clients remain unaware of the specific types of objects they use, and the classes that implement them. This reduces implementation dependencies. * Class inheritance is white-box reuse, because parent class internals are visible, while object composition is black-box reuse, because no internal details are visible. * Class inheritance is directly supported by the programming language, and makes it easy to modify the implementation being reused. * But class inheritance is fixed at compile-time, and breaks encapsulation, where the subclass becomes strongly coupled to the parent class. The parent class can change and become unsuitable for extension. * Composition, unlike inheritance, doesn't break encapsulation, and there are fewer implementation dependencies. Also, it helps you keep each class encapsulated and focused on one task. * Advantage of delegation is that you can compose behaviors at runtime, and change the way they're composed. It's an extreme example of object composition. * Disadvantages of delegation are that dynamic nature can be hard to understand, and there can be runtime inefficiencies. Only use it when it simplifies, not complicates. * A design that doesn't take change into account risks major redesign in the future. Unanticipated changes are invariably expensive.\",\"preco\": 199.99,\n" +
                "        \"pag\": 395,\n" +
                "        \"isbn\":\"0-201-63361-2\",\n" +
                "        \"lancamento\":\"28/09/2021\",\n" +
                "        \"autor\":"+autor.getId()+",\n" +
                "        \"categoria\":"+categoria.toResponse().getId()+"\n" +
                "}";
        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestSuccess)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
    }
}
