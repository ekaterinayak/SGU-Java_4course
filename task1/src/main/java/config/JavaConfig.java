package config;

import lombok.SneakyThrows;
import model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mirzoeva
 */
@Configuration
public class JavaConfig {

    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b() {
        return new B(a());
    }

    @Bean
    public C c() {
        return new C() {
            @Override
            protected D createD() {
                return d();
            }
        };
    }

    @Bean
    public D d() {
        return new D();
    }

    @Bean
    public E e() {
        return new E() {

            @Override
            @SneakyThrows
            public void sayBye() {
                methodReplacerImpl().reimplement(this, getClass().getMethod("sayBye"), null);
            }
        };
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public F f() {
        return new F();
    }

    @Bean
    public MethodReplacerImpl methodReplacerImpl() {
        return new MethodReplacerImpl();
    }
}
