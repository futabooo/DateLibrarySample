package com.futabooo.datelibrarysample;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        DateTime now = DateTime.now();
        text.add("Now: " + now);
        text.add("Now + 30 minutes: " + now.plusMinutes(30));
        text.add("Now + 5 hours: " + now.plusHours(5));
        text.add("Now + 2 days: " + now.plusDays(2));
        addSample("DateTime", text);
    }

    private void sampleDaysPeriod() {
        List<String> text = new ArrayList<String>();
        DateTime from = new DateTime("2012-04-18T20:00:00");
        DateTime to = new DateTime("2014-5-18T10:00:00");
        Duration duration = new Duration(from, to);
        text.add("from: " + from);
        text.add("to: " + to);
        text.add("Days: " + duration.getStandardDays());
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
