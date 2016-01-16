package com.futabooo.datelibrarysample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        // default format example [Wed Jan 20 11:32:45 GMT+9:00 2016]
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        calendar.setTime(now);
        text.add("Now: " + simpleDateFormat.format(calendar.getTime()));
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, 30);
        text.add("Now + 30 minutes: " + simpleDateFormat.format(calendar.getTime()));
        calendar.setTime(now);
        calendar.add(Calendar.HOUR, 5);
        text.add("Now + 5 hours: " + simpleDateFormat.format(calendar.getTime()));
        calendar.setTime(now);
        calendar.add(Calendar.DATE, 2);
        text.add("Now + 2 days: " + simpleDateFormat.format(calendar.getTime()));
        addSample("DateTime", text);
    }

    private void sampleDaysPeriod() {
        List<String> text = new ArrayList<String>();
        Date from = null;
        Date to = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        try {
            from = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2012-04-18T20:00:00");
            to = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2014-5-18T10:00:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        text.add("from: " + simpleDateFormat.format(from));
        text.add("to: " + simpleDateFormat.format(to));
        long diff = to.getTime() - from.getTime();
        text.add("Days: " + diff / (24 * 60 * 60 * 1000));
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
