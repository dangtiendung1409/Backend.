package demo7;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class News implements INews {
    private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;
    private List<Float> RateList;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getAuthor() {
        return Author;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getContent() {
        return Content;
    }

    public float getAverageRate() {
        return AverageRate;
    }

    public void Calculate() {
        float sum = 0;
        for (float rate : RateList) {
            sum += rate;
        }
        AverageRate = sum / RateList.size();
    }

    public void AddRate(float rate) {
        if (RateList == null) {
            RateList = new ArrayList<>();
        }
        RateList.add(rate);
        Calculate();
    }

    @Override
    public void Display() {
        System.out.println("Title: " + Title);
        System.out.println("Publish Date: " + PublishDate);
        System.out.println("Author: " + Author);
        System.out.println("Content: " + Content);
        System.out.println("Average Rate: " + AverageRate);
    }
}