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
        Autor autor = new Autor("Gang of Four", "gangof4@designpatterns.com", "Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides. These authors are often referred to as the Gang of Four (GoF)");
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
                "        \"categoria\":"+categoria.getId()+"\n" +
                "}";

        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestSuccess)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    @Order(2)
    public void livroComTituloRepetidoRetorna400() throws Exception {
        Autor autor = autorRepository.findByEmail("gangof4@designpatterns.com").get();
        Categoria categoria = categoriaRepository.findByNome("Software Engineering").get();

        String requestSuccess = "{ \n" +
                "    \"titulo\":\"Design Patterns: Elements of Reusable Object-Oriented Software\",\n" +
                "    \"resumo\":\"is a software engineering book describing software design patterns. The book was written by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides, with a foreword by Grady Booch. The book is divided into two parts, with the first two chapters exploring the capabilities and pitfalls of object-oriented programming, and the remaining chapters describing 23 classic software design patterns. The book includes examples in C++ and Smalltalk.\",\n" +
                "    \"sumario\":\"## Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides *I, [Michael Parker](http://omgitsmgp.com/), own this book and took these notes to further my own learning. If you enjoy these notes, please [purchase the book](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)!* ### Chapter 1: Introduction * Expert designers know not to solve every problem from first principles, but reuse good solutions. This experience makes them experts. * A design pattern names, abstracts, and identifies the key aspects of a common design structure that make it useful for creating a reusable object-oriented design. * The hard part of object-oriented design is decomposing a system into objects, which is difficult because encapsulation, granularity, dependency, flexibility, performance, evolution, reusability, and more come into play. * When designing, strict modeling of the real world leads to a system that reflects today's realities not but not necessarily tomorrow's. Abstractions are key to making a design flexible. * Dynamic binding means that invoking a method doesn't commit to a particular implementation until runtime. * An object's class refers to how it's implemented, while an object's type refers to only its interface. * Class inheritance is a mechanism for code reuse and representation sharing, while interface inheritance describes when an object can be used in place of another. * Inheritance's ability to define families of objects with identical interfaces is important because polymorphism depends on it. * By manipulating objects through the interface of their abstract class, clients remain unaware of the specific types of objects they use, and the classes that implement them. This reduces implementation dependencies. * Class inheritance is white-box reuse, because parent class internals are visible, while object composition is black-box reuse, because no internal details are visible. * Class inheritance is directly supported by the programming language, and makes it easy to modify the implementation being reused. * But class inheritance is fixed at compile-time, and breaks encapsulation, where the subclass becomes strongly coupled to the parent class. The parent class can change and become unsuitable for extension. * Composition, unlike inheritance, doesn't break encapsulation, and there are fewer implementation dependencies. Also, it helps you keep each class encapsulated and focused on one task. * Advantage of delegation is that you can compose behaviors at runtime, and change the way they're composed. It's an extreme example of object composition. * Disadvantages of delegation are that dynamic nature can be hard to understand, and there can be runtime inefficiencies. Only use it when it simplifies, not complicates. * A design that doesn't take change into account risks major redesign in the future. Unanticipated changes are invariably expensive.\",\"preco\": 199.99,\n" +
                "        \"pag\": 395,\n" +
                "        \"isbn\":\"0-201-63361-2\",\n" +
                "        \"lancamento\":\"28/09/2021\",\n" +
                "        \"autor\":"+autor.getId()+",\n" +
                "        \"categoria\":"+categoria.getId()+"\n" +
                "}";
        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestSuccess)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void livroComCategoriaInexistenteRetorna400() throws Exception {
        Autor autor = new Autor("Kent Beck", "kent.beck@xp.com", "consistently challenges software engineering dogma, promoting ideas like patterns, test-driven development, and Extreme Programming. Currently affiliated with Three Rivers Institute and Agitar Software, he is the author of many Addison-Wesley titles.");
        autor = autorRepository.save(autor);

        String requestSuccess = "{ \n" +
                "    \"titulo\":\"Exetreme Programming Explained: Embrance Change. Second Edition.\",\n" +
                "    \"resumo\":\"In this second edition of Extreme Programming Explained, Kent Beck organizes and presents five years’ worth of experiences, growth, and change revolving around XP. If you are seriously interested in understanding how you and your team can start down the path of improvement with XP, you must read this book.\",\n" +
                "    \"sumario\":\"# Extreme Programming Explained. Embrance Change, Second Edition By Kent Beck. ### Chapter What is XP? * It's about social change. * Don't protect yourself from success by holding back. Do your best and then deal with the consequences. * It's a style of software development focusing on excellent application of programming techniques, clear communication, and teamwork. * It's a path of improvement to excellence for people coming together to develop software. It is distinguished by:     * Its short development cycles. * Its incremental planning approach. * Its ability to flexibly when the business needs change. * Its reliance on automated tests. * Its reliance on oral communication. * Its reliance on an evolutionary design process. * Its reliance on the close collaboration. * Its reliance on practices that work with both the short-term instincts of the team members and the long-term interests of the project. * XP is a lightweight methodology for small-to-medium-sized teams developing software in the face of vague or rapidly changing requirements. * In XP you only do what you need to do to create value for the customer. * The values and principles behind XP are applicable at any scale. * It's a methodology based on addressing constraints in software development. * XP demands that participants learn a high level of technique in service of the team's goals. * The risks in the development process: * Schedule slips.  * It calls for short release cycles, so the scope of any slip is limited. Within a release, XP uses one-week iterations of customer-requested features to create fine-grained feedback about progress. XP calls for implementing the highest priority features first, so any features that slip past the release will be of lower value. * Project canceled. * It asks the business-oriented part of the team to choose the smallest release that makes the most business sense, so there is less to go wrong before deploying and the value of the software is greatest. * System goes sour. * It creates and maintains a comprehensive suite of automated tests, which are run and rerun after every change to ensure a quality baseline. XP always keeps the system in deployable condition. Problems are not allowed to accumulate. * Defect rate. * It tests from the perspective of both programmers writing tests function-by-function and customers writing tests program-feature-by-program-feature. * Business misunderstood. * The specification of the project is continuously refined during development, so learning by the customer and the team can be reflected in the software. * Business changes. * It shortens the release cycle, so there is less change during the development of a single release. During a release, the customer is welcome to substitute new functionality for functionality not yet completed. The team doesn't even notice if it is working on newly discovered functionality or features defined years ago. * False feature rich. * XP insists that only the highest priority tasks are addressed. * Staff turnover.* XP asks programmers to accept responsibility for estimating and completing their own work, gives them feedback about the actual time taken so their estimates can improve, and respects those estimates. XP also encourages human contact among the team, reducing the loneliness that is often at the heart of job dissatisfaction. New team members are encouraged to gradually accept more and more responsibility.\",\n" +
                "        \"preco\": 299.99,\n" +
                "        \"pag\": 224,\n" +
                "        \"isbn\":\"9-780-32127865-4\",\n" +
                "        \"lancamento\":\"28/09/2021\",\n" +
                "        \"autor\":"+autor.getId()+",\n" +
                "        \"categoria\":99\n" +
                "}";
        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestSuccess)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
    }


    @Test
    public void livroComAutorInexistenteRetorna400() throws Exception {
        String requestSuccess = "{ \n" +
                "    \"titulo\":\"Exetreme Programming Explained: Embrance Change. Second Edition.\",\n" +
                "    \"resumo\":\"In this second edition of Extreme Programming Explained, Kent Beck organizes and presents five years’ worth of experiences, growth, and change revolving around XP. If you are seriously interested in understanding how you and your team can start down the path of improvement with XP, you must read this book.\",\n" +
                "    \"sumario\":\"# Extreme Programming Explained. Embrance Change, Second Edition By Kent Beck. ### Chapter What is XP? * It's about social change. * Don't protect yourself from success by holding back. Do your best and then deal with the consequences. * It's a style of software development focusing on excellent application of programming techniques, clear communication, and teamwork. * It's a path of improvement to excellence for people coming together to develop software. It is distinguished by:     * Its short development cycles. * Its incremental planning approach. * Its ability to flexibly when the business needs change. * Its reliance on automated tests. * Its reliance on oral communication. * Its reliance on an evolutionary design process. * Its reliance on the close collaboration. * Its reliance on practices that work with both the short-term instincts of the team members and the long-term interests of the project. * XP is a lightweight methodology for small-to-medium-sized teams developing software in the face of vague or rapidly changing requirements. * In XP you only do what you need to do to create value for the customer. * The values and principles behind XP are applicable at any scale. * It's a methodology based on addressing constraints in software development. * XP demands that participants learn a high level of technique in service of the team's goals. * The risks in the development process: * Schedule slips.  * It calls for short release cycles, so the scope of any slip is limited. Within a release, XP uses one-week iterations of customer-requested features to create fine-grained feedback about progress. XP calls for implementing the highest priority features first, so any features that slip past the release will be of lower value. * Project canceled. * It asks the business-oriented part of the team to choose the smallest release that makes the most business sense, so there is less to go wrong before deploying and the value of the software is greatest. * System goes sour. * It creates and maintains a comprehensive suite of automated tests, which are run and rerun after every change to ensure a quality baseline. XP always keeps the system in deployable condition. Problems are not allowed to accumulate. * Defect rate. * It tests from the perspective of both programmers writing tests function-by-function and customers writing tests program-feature-by-program-feature. * Business misunderstood. * The specification of the project is continuously refined during development, so learning by the customer and the team can be reflected in the software. * Business changes. * It shortens the release cycle, so there is less change during the development of a single release. During a release, the customer is welcome to substitute new functionality for functionality not yet completed. The team doesn't even notice if it is working on newly discovered functionality or features defined years ago. * False feature rich. * XP insists that only the highest priority tasks are addressed. * Staff turnover.* XP asks programmers to accept responsibility for estimating and completing their own work, gives them feedback about the actual time taken so their estimates can improve, and respects those estimates. XP also encourages human contact among the team, reducing the loneliness that is often at the heart of job dissatisfaction. New team members are encouraged to gradually accept more and more responsibility.\",\n" +
                "        \"preco\": 299.99,\n" +
                "        \"pag\": 224,\n" +
                "        \"isbn\":\"9-780-32127865-4\",\n" +
                "        \"lancamento\":\"28/09/2021\",\n" +
                "        \"autor\":99,\n" +
                "        \"categoria\":1\n" +
                "}";
        System.out.println(requestSuccess);
        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestSuccess)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void livroComLancamentoNoPassadoRetorna400() throws Exception {
        String requestSuccess = "{ \n" +
                "    \"titulo\":\"Exetreme Programming Explained: Embrance Change. Second Edition.\",\n" +
                "    \"resumo\":\"In this second edition of Extreme Programming Explained, Kent Beck organizes and presents five years’ worth of experiences, growth, and change revolving around XP. If you are seriously interested in understanding how you and your team can start down the path of improvement with XP, you must read this book.\",\n" +
                "    \"sumario\":\"# Extreme Programming Explained. Embrance Change, Second Edition By Kent Beck. ### Chapter What is XP? * It's about social change. * Don't protect yourself from success by holding back. Do your best and then deal with the consequences. * It's a style of software development focusing on excellent application of programming techniques, clear communication, and teamwork. * It's a path of improvement to excellence for people coming together to develop software. It is distinguished by:     * Its short development cycles. * Its incremental planning approach. * Its ability to flexibly when the business needs change. * Its reliance on automated tests. * Its reliance on oral communication. * Its reliance on an evolutionary design process. * Its reliance on the close collaboration. * Its reliance on practices that work with both the short-term instincts of the team members and the long-term interests of the project. * XP is a lightweight methodology for small-to-medium-sized teams developing software in the face of vague or rapidly changing requirements. * In XP you only do what you need to do to create value for the customer. * The values and principles behind XP are applicable at any scale. * It's a methodology based on addressing constraints in software development. * XP demands that participants learn a high level of technique in service of the team's goals. * The risks in the development process: * Schedule slips.  * It calls for short release cycles, so the scope of any slip is limited. Within a release, XP uses one-week iterations of customer-requested features to create fine-grained feedback about progress. XP calls for implementing the highest priority features first, so any features that slip past the release will be of lower value. * Project canceled. * It asks the business-oriented part of the team to choose the smallest release that makes the most business sense, so there is less to go wrong before deploying and the value of the software is greatest. * System goes sour. * It creates and maintains a comprehensive suite of automated tests, which are run and rerun after every change to ensure a quality baseline. XP always keeps the system in deployable condition. Problems are not allowed to accumulate. * Defect rate. * It tests from the perspective of both programmers writing tests function-by-function and customers writing tests program-feature-by-program-feature. * Business misunderstood. * The specification of the project is continuously refined during development, so learning by the customer and the team can be reflected in the software. * Business changes. * It shortens the release cycle, so there is less change during the development of a single release. During a release, the customer is welcome to substitute new functionality for functionality not yet completed. The team doesn't even notice if it is working on newly discovered functionality or features defined years ago. * False feature rich. * XP insists that only the highest priority tasks are addressed. * Staff turnover.* XP asks programmers to accept responsibility for estimating and completing their own work, gives them feedback about the actual time taken so their estimates can improve, and respects those estimates. XP also encourages human contact among the team, reducing the loneliness that is often at the heart of job dissatisfaction. New team members are encouraged to gradually accept more and more responsibility.\",\n" +
                "        \"preco\": 299.99,\n" +
                "        \"pag\": 224,\n" +
                "        \"isbn\":\"9-780-32127865-4\",\n" +
                "        \"lancamento\":\"28/09/2020\",\n" +
                "        \"autor\":1,\n" +
                "        \"categoria\":1\n" +
                "}";
        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestSuccess)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void recuperDetalhesDoLivroComSucessoRetorna200() throws Exception {

        String jsonContent = "{\n" +
                "    \"id\": 1,\n" +
                "    \"titulo\": \"Design Patterns: Elements of Reusable Object-Oriented Software\",\n" +
                "    \"resumo\": \"is a software engineering book describing software design patterns. The book was written by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides, with a foreword by Grady Booch. The book is divided into two parts, with the first two chapters exploring the capabilities and pitfalls of object-oriented programming, and the remaining chapters describing 23 classic software design patterns. The book includes examples in C++ and Smalltalk.\",\n" +
                "    \"sumario\": \"## Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides *I, [Michael Parker](http://omgitsmgp.com/), own this book and took these notes to further my own learning. If you enjoy these notes, please [purchase the book](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)!* ### Chapter 1: Introduction * Expert designers know not to solve every problem from first principles, but reuse good solutions. This experience makes them experts. * A design pattern names, abstracts, and identifies the key aspects of a common design structure that make it useful for creating a reusable object-oriented design. * The hard part of object-oriented design is decomposing a system into objects, which is difficult because encapsulation, granularity, dependency, flexibility, performance, evolution, reusability, and more come into play. * When designing, strict modeling of the real world leads to a system that reflects today's realities not but not necessarily tomorrow's. Abstractions are key to making a design flexible. * Dynamic binding means that invoking a method doesn't commit to a particular implementation until runtime. * An object's class refers to how it's implemented, while an object's type refers to only its interface. * Class inheritance is a mechanism for code reuse and representation sharing, while interface inheritance describes when an object can be used in place of another. * Inheritance's ability to define families of objects with identical interfaces is important because polymorphism depends on it. * By manipulating objects through the interface of their abstract class, clients remain unaware of the specific types of objects they use, and the classes that implement them. This reduces implementation dependencies. * Class inheritance is white-box reuse, because parent class internals are visible, while object composition is black-box reuse, because no internal details are visible. * Class inheritance is directly supported by the programming language, and makes it easy to modify the implementation being reused. * But class inheritance is fixed at compile-time, and breaks encapsulation, where the subclass becomes strongly coupled to the parent class. The parent class can change and become unsuitable for extension. * Composition, unlike inheritance, doesn't break encapsulation, and there are fewer implementation dependencies. Also, it helps you keep each class encapsulated and focused on one task. * Advantage of delegation is that you can compose behaviors at runtime, and change the way they're composed. It's an extreme example of object composition. * Disadvantages of delegation are that dynamic nature can be hard to understand, and there can be runtime inefficiencies. Only use it when it simplifies, not complicates. * A design that doesn't take change into account risks major redesign in the future. Unanticipated changes are invariably expensive.\",\n" +
                "    \"preco\": 199.99,\n" +
                "    \"pag\": 395,\n" +
                "    \"isbn\": \"0-201-63361-2\",\n" +
                "    \"lancamento\": \"28/09/2021\",\n" +
                "    \"categoria\": \"Software Engineering\",\n" +
                "    \"autor\": \"Gang of Four\",\n" +
                "    \"descricaoAutor\": \"Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides. These authors are often referred to as the Gang of Four (GoF)\"\n" +
                "}";

        URI uri = new URI("/livros/1");
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content().json(jsonContent));
    }

}
