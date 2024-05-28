package spel.valid;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhaoxiaoping
 * @date 2024-5-28
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "spel")
public class SpelConfig {}
