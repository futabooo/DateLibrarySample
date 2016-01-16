package com.futabooo.datelibrarysample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import hirondelle.date4j.DateTime;

public class MainActivity extends AppCompatActivity {

    private ViewGroup mContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContent = (ViewGroup) findViewById(R.id.content);

        sampleDateTime();
        sampleDaysPeriod();
    }

    private void sampleDateTime() {
        List<String> text = new ArrayList<String>();

    DateTime now = DateTime.now(TimeZone.getDefault());
    text.add("Now: " + now);
    text.add("Now + 30 minutes: " + now.plus(0, 0, 0, 0, 30, 0, 0, DateTime.DayOverflow.LastDay));
    text.add("Now + 5 hours: " + now.plus(0, 0, 0, 5, 0, 0, 0, DateTime.DayOverflow.LastDay));
    text.add("Now + 2 days: " + now.plus(0, 0, 2, 0, 0, 0, 0, DateTime.DayOverflow.LastDay));

        addSample("DateTime", text);
    }

    private void sampleDaysPeriod() {
        List<String> text = new ArrayList<String>();

        // このフォーマットだとExceptionをはく
        // DateTime from = new DateTime("2012-04-18T20:00:00");
        // DateTime to = new DateTime("2014-5-18T10:00:00");

        DateTime from = new DateTime(2012, 4, 18, 20, 0, 0, null);
        DateTime to = new DateTime(2014, 5, 18, 10, 0, 0, null);
        text.add("from: " + from);
        text.add("to: " + to);
        text.add("Days: " + from.numDaysFrom(to));

        addSample("DaysPeriod", text);
    }

    private void addSample(CharSequence title, Iterable<String> text) {
        addSample(title, TextUtils.join("\n", text));
    }

    private void addSample(CharSequence title, CharSequence text) {
        View view = LayoutInflater.from(this).inflate(R.layout.include_sample, mContent, false);
        ((TextView) view.findViewById(R.id.title)).setText(title);
        ((TextView) view.findViewById(R.id.text)).setText(text);
        mContent.addView(view);
    }
}
