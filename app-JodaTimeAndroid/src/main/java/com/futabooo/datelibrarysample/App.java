package com.futabooo.datelibrarysample;

import net.danlew.android.joda.JodaTimeAndroid;

import android.app.Application;

  public class App extends Application {

      @Override
      public void onCreate() {
          super.onCreate();
          JodaTimeAndroid.init(this);
      }
  }
