package com.prova.fileprocessor.route;

import org.apache.camel.builder.RouteBuilder;

public abstract class RouteBuilderSupport extends RouteBuilder {

    public final void configure() throws Exception {
       // this.onException(Exception.class).bean(RouteExceptionProcessor.class);
        this.configureRoute();
    }

    protected abstract void configureRoute() throws Exception;
}
