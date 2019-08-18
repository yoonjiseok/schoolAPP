package com.tester.yoonjiseok.school;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class secondlayout extends Fragment {

    View v;
    private Context context;

    private String htmlPageUrl = "http://www.sungil.hs.kr/?_page=39&_action=view&_view=view&yy="; //파싱할 홈페이지의 URL주소
    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat="";




    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {



        v = inflater.inflate(R.layout.second_layout, container, false);


        textviewHtmlDocument = (TextView) v.findViewById(R.id.meal);


        Button htmlTitleButton = (Button) v.findViewById(R.id.meal_button);
        htmlTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();

              Toast.makeText(v.getContext(),"찍힘",Toast.LENGTH_SHORT).show();


            }
        });



        return v;




    }




    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                Document doc = Jsoup.connect(htmlPageUrl).get();


                //테스트1
                Elements meal1= doc.select("#menu_rightcolumn > div:nth-child(3) > div.day_food_right > dl > dd");
                Elements meal2= doc.select("#menu_rightcolumn > div:nth-child(5) > div.day_food_right > dl > dd");

                Elements date = doc.select("#menu_rightcolumn > div.performance_top.box_bg_gray.box_1line_tb > span > span");
                Elements a = meal1;
                Elements b = meal2;

                Elements d = date;
                    System.out.println("meal: " + a.text());
                    System.out.println("meal: " + b.text());

                    htmlContentInStringFormat += d.text().trim()+ ("급식") +"\n"+"\n"+ "중식 : "+a.text().trim()  +"\n" +"\n" + "석식 : "+ b.text().trim() ;



            } catch (IOException e) {
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            textviewHtmlDocument.setText(htmlContentInStringFormat);
        }
    }







}
