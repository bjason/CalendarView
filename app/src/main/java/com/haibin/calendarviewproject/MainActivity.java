package com.haibin.calendarviewproject;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarviewproject.base.activity.BaseActivity;
import com.haibin.calendarviewproject.colorful.ColorfulActivity;
import com.haibin.calendarviewproject.custom.CustomActivity;
import com.haibin.calendarviewproject.index.IndexActivity;
import com.haibin.calendarviewproject.meizu.MeiZuActivity;
import com.haibin.calendarviewproject.pager.ViewPagerActivity;
import com.haibin.calendarviewproject.progress.ProgressActivity;
import com.haibin.calendarviewproject.simple.SimpleActivity;
import com.haibin.calendarviewproject.single.SingleActivity;
import com.haibin.calendarviewproject.solay.SolarActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements
        CalendarView.OnDateSelectedListener,
        CalendarView.OnMonthChangeListener,
        CalendarView.OnYearChangeListener,
        CalendarView.OnDateLongClickListener,
        CalendarView.OnViewChangeListener,
        View.OnClickListener {

    TextView mTextMonthDay;

    TextView mTextYear;

    TextView mTextLunar;

    TextView mTextCurrentDay;

    CalendarView mCalendarView;

    RelativeLayout mRelativeTool;
    private int mYear;
    CalendarLayout mCalendarLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        setStatusBarDarkMode();
        mTextMonthDay = (TextView) findViewById(R.id.tv_month_day);
        mTextYear = (TextView) findViewById(R.id.tv_year);
        mTextLunar = (TextView) findViewById(R.id.tv_lunar);
        mRelativeTool = (RelativeLayout) findViewById(R.id.rl_tool);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mTextCurrentDay = (TextView) findViewById(R.id.tv_current_day);
        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCalendarLayout.isExpand()) {
                    mCalendarView.showYearSelectLayout(mYear);
                    return;
                }
                mCalendarView.showYearSelectLayout(mYear);
                mTextLunar.setVisibility(View.GONE);
                mTextYear.setVisibility(View.GONE);
                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });
        findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
                //mCalendarView.scrollToCalendar(2018,7,14);
                Log.e("scrollToCurrent", "   --  " + mCalendarView.getSelectedCalendar());
            }
        });

        mCalendarLayout = (CalendarLayout) findViewById(R.id.calendarLayout);
        mCalendarView.setOnYearChangeListener(this);
        mCalendarView.setOnDateSelectedListener(this);
        mCalendarView.setOnMonthChangeListener(this);
        mCalendarView.setOnDateLongClickListener(this, true);
        mCalendarView.setOnViewChangeListener(this);
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));
    }

    @Override
    protected void initData() {
        final List<Calendar> schemes = new ArrayList<>();
        final int year = mCalendarView.getCurYear();
        final int month = mCalendarView.getCurMonth();
        schemes.add(getSchemeCalendar(year, month, 3, 0xFF40db25, "假"));
        schemes.add(getSchemeCalendar(year, month, 6, 0xFFe69138, "事"));
        schemes.add(getSchemeCalendar(year, month, 9, 0xFFdf1356, "议"));
        schemes.add(getSchemeCalendar(year, month, 13, 0xFFedc56d, "记"));
        schemes.add(getSchemeCalendar(year, month, 14, 0xFFedc56d, "记"));
        schemes.add(getSchemeCalendar(year, month, 15, 0xFFaacc44, "假"));
        schemes.add(getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记"));
        schemes.add(getSchemeCalendar(year, month, 25, 0xFF13acf0, "假"));
        schemes.add(getSchemeCalendar(year, month, 27, 0xFF13acf0, "多"));
//        for (int y = year; y < 2082; y++) {
//            for (int m = 1; m < 12; m++) {
//                schemes.add(getSchemeCalendar(y, m, 1, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 2, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 3, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 4, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 5, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 6, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 7, 0xFFe69138, "事"));
//                schemes.add(getSchemeCalendar(y, m, 8, 0xFFdf1356, "议"));
//                schemes.add(getSchemeCalendar(y, m, 9, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 10, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 11, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 12, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 13, 0xFFedc56d, "记"));
//                schemes.add(getSchemeCalendar(y, m, 14, 0xFFedc56d, "记"));
//                schemes.add(getSchemeCalendar(y, m, 15, 0xFFaacc44, "假"));
//                schemes.add(getSchemeCalendar(y, m, 16, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 17, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 18, 0xFFbc13f0, "记"));
//                schemes.add(getSchemeCalendar(y, m, 19, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 20, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 21, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 22, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 23, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 24, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 25, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 26, 0xFF13acf0, "假"));
//                schemes.add(getSchemeCalendar(y, m, 37, 0xFF40db25, "假"));
//                schemes.add(getSchemeCalendar(y, m, 38, 0xFF40db25, "假"));
//            }
//        }
        mCalendarView.setSchemeDate(schemes);
        findViewById(R.id.ll_flyme).setOnClickListener(this);
        findViewById(R.id.ll_simple).setOnClickListener(this);
        findViewById(R.id.ll_colorful).setOnClickListener(this);
        findViewById(R.id.ll_index).setOnClickListener(this);
        findViewById(R.id.ll_tab).setOnClickListener(this);
        findViewById(R.id.ll_single).setOnClickListener(this);
        findViewById(R.id.ll_solar_system).setOnClickListener(this);
        findViewById(R.id.ll_progress).setOnClickListener(this);
        findViewById(R.id.ll_custom).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_flyme:
                MeiZuActivity.show(this);
                break;
            case R.id.ll_simple:
                SimpleActivity.show(this);
                break;
            case R.id.ll_colorful:
                ColorfulActivity.show(this);
                break;
            case R.id.ll_index:
                IndexActivity.show(this);
                break;
            case R.id.ll_tab:
                ViewPagerActivity.show(this);
                break;
            case R.id.ll_single:
                SingleActivity.show(this);
                break;
            case R.id.ll_solar_system:
                SolarActivity.show(this);
                break;
            case R.id.ll_progress:
                ProgressActivity.show(this);
                break;
            case R.id.ll_custom:
                CustomActivity.show(this);
                break;
        }
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        return calendar;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        //Log.e("onDateSelected", "  -- " + calendar.getYear() + "  --  " + calendar.getMonth() + "  -- " + calendar.getDay());
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
        if (isClick) {
            Toast.makeText(this, getCalendarText(calendar), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDateLongClick(Calendar calendar) {
        Toast.makeText(this, "长按不选择日期\n" + getCalendarText(calendar), Toast.LENGTH_SHORT).show();
    }

    private static String getCalendarText(Calendar calendar) {
        return String.format("新历%s \n 农历%s \n 公历节日：%s \n 农历节日：%s \n 节气：%s \n 是否闰月：%s",
                calendar.getMonth() + "月" + calendar.getDay() + "日",
                calendar.getLunarCakendar().getMonth() + "月" + calendar.getLunarCakendar().getDay() + "日",
                TextUtils.isEmpty(calendar.getGregorianFestival()) ? "无" : calendar.getGregorianFestival(),
                TextUtils.isEmpty(calendar.getTraditionFestival()) ? "无" : calendar.getTraditionFestival(),
                TextUtils.isEmpty(calendar.getSolarTerm()) ? "无" : calendar.getSolarTerm(),
                calendar.getLeapMonth() == 0 ? "否" : String.format("闰%s月", calendar.getLeapMonth()));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onMonthChange(int year, int month) {
        //Log.e("onMonthChange", "  -- " + year + "  --  " + month);
        Calendar calendar = mCalendarView.getSelectedCalendar();
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
    }

    @Override
    public void onViewChange(boolean isMonthView) {
        Log.e("onViewChange", "  ---  " + (isMonthView ? "月视图" : "周视图"));
    }

    @Override
    public void onYearChange(int year) {
        mTextMonthDay.setText(String.valueOf(year));
    }

}


