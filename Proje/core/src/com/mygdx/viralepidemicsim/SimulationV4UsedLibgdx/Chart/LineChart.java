package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class LineChart extends JFrame {

    private JFreeChart chart;

    public LineChart(String title){
        super(title);

        // 创建数据集
        XYSeriesCollection dataset = createDataset();

        // 创建图表
        chart = ChartFactory.createXYLineChart(
                "疫情相关人数变化",
                "日期",
                "人数",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }
    private XYSeriesCollection createDataset() {
        // 创建数据集
        XYSeries normal = new XYSeries("正常人数");
        XYSeries closeContact = new XYSeries("密接人数");
        XYSeries infectedCases = new XYSeries("感染人数");

        // 假设的数据
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 30; i++) {
            calendar.set(2023, 0, i + 1);
            Date date = calendar.getTime();
            normal.add(date.getTime(), 100 + i * 2);
            closeContact.add(date.getTime(), 5 + i);
            infectedCases.add(date.getTime(), 1 + i / 10);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(normal);
        dataset.addSeries(closeContact);
        dataset.addSeries(infectedCases);

        return dataset;
    }

    public JFreeChart getChart() {
        return chart; // 返回 JFreeChart 对象
    }

}
