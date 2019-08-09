package com.example.yoonjiseok.school;

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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class thirdlayout extends Fragment {

    View v;
    private Context context;

    private String htmlPageUrl = "http://www.sungil.hs.kr/?_page=25&_action=view&_view=view&yy="; //파싱할 홈페이지의 URL주소
    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat1="";
    private String htmlContentInStringFormat2="";
    private String htmlContentInStringFormat3="";



    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {



        v = inflater.inflate(R.layout.thridlayout, container, false);


        textviewHtmlDocument = (TextView) v.findViewById(R.id.hangsa_text);


        Button htmlTitleButton = (Button) v.findViewById(R.id.hangsa_button);
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
                Elements hangsa1= doc.select("#menu_rightcolumn > table:nth-child(2) > tbody > tr:nth-child(2) > td");
                Elements hangsa2 = doc.select("#menu_rightcolumn > table:nth-child(3) > tbody > tr:nth-child(2) > td");
                Elements hangsa3 = doc.select("#menu_rightcolumn > table:nth-child(4) > tbody > tr:nth-child(2) > td");
                Elements hangsa4 = doc.select("#menu_rightcolumn > table:nth-child(5) > tbody > tr:nth-child(2) > td");
                Elements hangsa5 = doc.select("#menu_rightcolumn > table:nth-child(6) > tbody > tr:nth-child(2) > td");
                Elements hangsa6 = doc.select("#menu_rightcolumn > table:nth-child(7) > tbody > tr:nth-child(2) > td");

                Elements a = hangsa1;
                Elements b = hangsa2;
                Elements c = hangsa3;
                Elements d = hangsa4;
                Elements e = hangsa5;
                Elements f = hangsa6;

                    System.out.println("meal: " + a.text());
                    htmlContentInStringFormat1 += a.text().trim()+ "\n" +"\n" + b.text().trim() + "\n" +"\n" +  c.text().trim()+ "\n" +"\n"+ d.text().trim() + "\n" +"\n"+ e.text().trim() + "\n" +"\n"+ f.text().trim() ;




            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            textviewHtmlDocument.setText(htmlContentInStringFormat1);

        }
    }







}
