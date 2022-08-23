package com.example.flutter_connectivity_plugin_test_java;

import io.flutter.plugin.common.EventChannel;

public class EventHandler implements EventChannel.StreamHandler {
    EventChannel.EventSink events;

    @Override
    public void onListen(Object arguments, EventChannel.EventSink events) {
        this.events = events;
    }

    @Override
    public void onCancel(Object arguments) {
        this.events = null;

    }

    public void sendEvent() {
        this.events.success("Hello world, sendEvent Function worked !!!");
    }
}
