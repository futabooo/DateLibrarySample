package com.futabooo.datelibrarysample;

import org.threeten.bp.Duration;
import org.threeten.bp.ZonedDateTime;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContent = (ViewGroup) findViewById(R.id.content);

        sampleDateTime();
        sampleDaysPeriod();
    }

    private void sampleDateTime() {
        List<String> text = new ArrayList<String>();

        ZonedDateTime now = ZonedDateTime.now();
        text.add("Now: " + now);
        text.add("Now + 30 minutes: " + now.plusMinutes(30));
        text.add("Now + 5 hours: " + now.plusHours(5));
        text.add("Now + 2 days: " + now.plusDays(2));

        addSample("DateTime", text);
    }

    private void sampleDaysPeriod(){
        List<String> text = new ArrayList<String>();

        ZonedDateTime from = ZonedDateTime.parse("2012-04-18T20:00:00+09:00[Asia/Tokyo]");
        ZonedDateTime to = ZonedDateTime.parse("2014-05-18T10:00:00+09:00[Asia/Tokyo]");
        text.add("from: " + from);
        text.add("to: " + to);
        text.add("Days: " + Duration.between(from, to).toDays());

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
