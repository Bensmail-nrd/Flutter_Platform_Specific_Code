package com.example.flutter_connectivity_plugin_test_java;

import android.widget.Toast;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        EventHandler eventHandler = new EventHandler();
        EventChannel eventChannel = new EventChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "eventChannel.bensmail");
        eventChannel.setStreamHandler(eventHandler);

        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "channel.bensmail")
                .setMethodCallHandler((call, result) -> {
                    if (call.method.equals("sendEvent")) {
                        Toast.makeText(getApplicationContext(), "Hello again", Toast.LENGTH_SHORT).show();
                        eventHandler.sendEvent();
                    }

                });


    }
}
