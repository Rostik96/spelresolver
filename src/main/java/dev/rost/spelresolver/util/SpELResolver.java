package dev.rost.spelresolver.util;

import lombok.Setter;
import lombok.experimental.Delegate;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Setter
@Component
public class SpELResolver implements EmbeddedValueResolverAware {

    @Delegate
    private StringValueResolver embeddedValueResolver;
}
