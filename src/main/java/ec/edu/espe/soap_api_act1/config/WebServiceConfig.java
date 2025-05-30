package ec.edu.espe.soap_api_act1.config;

import ec.edu.espe.soap_api_act1.exception.TrackingNotFoundException;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import java.util.Properties;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true); 
        return new ServletRegistrationBean<>(servlet, "/*");
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("ec.edu.espe.soap_api_act1.models");
        return marshaller;
    }

    @Bean(name = "tracking")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema emptyXsdSchema) { 
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TrackingServicePortType");
        wsdl11Definition.setLocationUri("/"); 
        wsdl11Definition.setTargetNamespace("http://miservicio.tracking");
        wsdl11Definition.setSchema(emptyXsdSchema); 
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema emptyXsdSchema() {
        return new org.springframework.xml.xsd.SimpleXsdSchema(new org.springframework.core.io.ClassPathResource("xsd/tracking.xsd")); 
    }
    
    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() {
        SoapFaultMappingExceptionResolver exceptionResolver = new SoapFaultMappingExceptionResolver();
        Properties errorMappings = new Properties();
        errorMappings.setProperty(TrackingNotFoundException.class.getName(), "CLIENT");
        exceptionResolver.setExceptionMappings(errorMappings);
        return exceptionResolver;
    }
}