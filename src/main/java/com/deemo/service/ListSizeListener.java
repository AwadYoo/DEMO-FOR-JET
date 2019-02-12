package com.deemo.service;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ListSizeListener {

    @EventListener
    public void onApplicationEvent(MyEvent event) {
        event.printMsg();
    }
}
