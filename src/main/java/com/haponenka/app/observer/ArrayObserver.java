package com.haponenka.app.observer;

import com.haponenka.app.event.ArrayEvent;

public interface ArrayObserver {
  void update(ArrayEvent event);
}
