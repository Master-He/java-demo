package com.github.demo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import javax.inject.Inject;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class GuiceDemo3 {
    @Qualifier
    @Retention(RUNTIME)
    @interface Message {
    }

    static class DemoModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(Integer.class)
                    .annotatedWith(Names.named("Count"))
                    .toInstance(3);
        }

        @Provides
        @Message
        static String provideMessage() {
            return "hello world";
        }
    }

    static class Greeter {
        private final String message;
        private final int count;

        @Inject
        Greeter(@Message String message, @Named("Count") int count) {
            this.message = message;
            this.count = count;
        }

        void sayHello() {
            for (int i = 0; i < count; i++) {
                System.out.println(message);
            }
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DemoModule());
        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.sayHello();
    }
}