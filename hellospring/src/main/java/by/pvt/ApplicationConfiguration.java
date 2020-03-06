package by.pvt;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("by.pvt")
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    @Scope("prototype")
    public Message message() {
        return new Message();
    }


}

