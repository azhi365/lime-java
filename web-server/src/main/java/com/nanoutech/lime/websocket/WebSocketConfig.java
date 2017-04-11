package com.nanoutech.lime.websocket;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 *
 */
//@Configuration
//@EnableWebMvc
//@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(new DefaultWebSocketHandler(), "/websocket").addInterceptors(new HandshakeInterceptor());
        registry.addHandler(new DefaultWebSocketHandler(), "/sockjs").addInterceptors(new HandshakeInterceptor()).withSockJS();

    }
}
