package com.nopac.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {
/**
 * 
 * @param context
 * @return
 */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapWS/*");
    }

/**
 * Detection du schéma .xsd
 * @return
 */
    @Bean
    public XsdSchema calculSchema() {
        return new SimpleXsdSchema(new ClassPathResource("calcul.xsd"));
    }

    /**
     * Definition de la route par laquelle on vas requeter
     * @param calculSchema
     * @return
     */
    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema calculSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(calculSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("CalculServicePort");
        definition.setTargetNamespace("http://nopac.com/spring-boot-soap/calcul");
        return definition;
    }


}
