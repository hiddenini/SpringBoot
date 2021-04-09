package com.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * WebFlux 并不能使接口的响应时间缩短，它仅仅能够提升吞吐量和伸缩性
 * <p>
 * Spring WebFlux 是一个异步非阻塞式的 Web 框架，所以，它特别适合应用在 IO 密集型的服务中，比如微服务网关这样的应用中。
 * <p>
 * IO 密集型包括：磁盘IO密集型, 网络IO密集型
 * <p>
 * 微服务网关就属于网络 IO 密集型，使用异步非阻塞式编程模型，能够显著地提升网关对下游服务转发的吞吐量。
 */
@SpringBootApplication
@RestController
public class WebFluxBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxBootstrap.class, args);
    }

/*    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route(serverRequest -> {
                    URI uri = serverRequest.uri();
                    return "/hello-world".equals(uri.getPath());
                },
                request -> {
                    return ServerResponse.status(HttpStatus.OK).body(Mono.just("hello world"), String.class);
                });

    }*/

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route(GET("/hello-world"), this::helloWorld);
    }

    public Mono<ServerResponse> helloWorld(ServerRequest serverRequest) {
        println("hello world");
        return ServerResponse.status(HttpStatus.OK).body(Mono.just("hello world"), String.class);
    }

    @GetMapping("/mvc")
    public String mvc() {
        println("mvc");
        return "mvc";
    }

    @GetMapping("/mono")
    public Mono<String> flux() {
        println("Mono");
        return Mono.just("Mono");
    }

    private static void println(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程:" + threadName + "]" + message);
    }
}
