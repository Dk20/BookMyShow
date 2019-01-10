package org.BookMyShow;

import org.BookMyShow.Handler.MovieTServiceHandler;
import org.BookMyShow.Handler.SeatTServiceHandler;
import org.BookMyShow.Handler.ShowTServiceHandler;
import org.BookMyShow.Handler.UserTServiceHandler;
import org.BookMyShow.thrift.gen.MovieTService;
import org.BookMyShow.thrift.gen.SeatTService;
import org.BookMyShow.thrift.gen.ShowTService;
import org.BookMyShow.thrift.gen.UserTService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// TODO : Configuration package
@Configuration
public class BookMyShowServerConfig {

    @Bean
    public TProtocolFactory tProtocolFactory(){
        return new TBinaryProtocol.Factory();
    }

    @Bean
    public ServletRegistrationBean MovieTServlet(TProtocolFactory protocolFactory, MovieTServiceHandler movieTServiceHandler){
        TServlet tServlet = new TServlet(new MovieTService.Processor<>(movieTServiceHandler),protocolFactory);
        ServletRegistrationBean bean = new ServletRegistrationBean(tServlet,"/movie");
        bean.setName("MovieTServlet");
        return bean;
    }
    @Bean
    public ServletRegistrationBean UserTServlet(TProtocolFactory protocolFactory, UserTServiceHandler userTServiceHandler){
         TServlet tServlet = new TServlet(new UserTService.Processor<>(userTServiceHandler),protocolFactory);
         ServletRegistrationBean bean=new ServletRegistrationBean(tServlet,"/user");
         bean.setName("UserTServlet");
         return bean;
    }
    @Bean
    public ServletRegistrationBean ShowTServlet(TProtocolFactory protocolFactory, ShowTServiceHandler showTServiceHandler){
        TServlet tServlet = new TServlet(new ShowTService.Processor<>(showTServiceHandler),protocolFactory);
        ServletRegistrationBean bean=new ServletRegistrationBean(tServlet,"/show");
        bean.setName("ShowTServlet");
        return bean;
    }
    @Bean
    public ServletRegistrationBean SeatTServlet(TProtocolFactory protocolFactory, SeatTServiceHandler seatTServiceHandler){
        TServlet tServlet = new TServlet(new SeatTService.Processor<>(seatTServiceHandler),protocolFactory);
        ServletRegistrationBean bean=new ServletRegistrationBean(tServlet,"/seat");
        bean.setName("SeatTServlet");
        return bean;
    }
}
