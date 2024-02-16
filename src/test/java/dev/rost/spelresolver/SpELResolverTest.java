package dev.rost.spelresolver;

import dev.rost.spelresolver.service.StringAppenderService;
import dev.rost.spelresolver.util.SpELResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {"first=firstEnvValue", "second=secondEnvValue"})
class SpELResolverTest {

	@Autowired
	SpELResolver spELResolver;

	@Autowired
	Environment env;


	@Test
	@SuppressWarnings("ConstantConditions")
	void contextLoads() {
		//language="SpEL"
		var first = "${first}";
		assertThat(spELResolver.resolveStringValue(first))
				.isEqualTo(env.getProperty("first"));

		//language="SpEL"
		var second = "#{stringAppender.append('${second}')}";
		assertThat(spELResolver.resolveStringValue(second))
				.isEqualTo(StringAppenderService.class.getSimpleName().concat(env.getProperty("second")));

		//language="SpEL"
		var third = "#{stringAppender.append('third')}";
		assertThat(spELResolver.resolveStringValue(third))
				.isEqualTo(StringAppenderService.class.getSimpleName().concat("third"));
	}
}
