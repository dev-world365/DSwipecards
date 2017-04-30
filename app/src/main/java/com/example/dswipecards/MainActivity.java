package com.example.dswipecards;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dswipecards.tindercard.FlingCardListener;
import com.example.dswipecards.tindercard.SwipeFlingAdapterView;
import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FlingCardListener.ActionDownInterface {

    public static MyAppAdapter myAppAdapter;
    public static ViewHolder viewHolder;
    private ArrayList<CardData> al;
    private SwipeFlingAdapterView flingContainer;

    //facebook logout button
//    private TextView buttonLogout;

//    private ArrayAdapter<CardData> arrayAdapter;
//    private int i;
//    @InjectView(R.id.frame) SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.inject(this);

        //Load Actionbar with app logo
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.name7);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        al = new ArrayList<>();

        //load 400 photos
        int counter = 0;
        while (counter < 1) {
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img01.jpg",
                    "http://www.benairyresearch.net/dev/Video1.mp4",
                    "Luke, 28\nDJ at Booms Music",
                    "DJ at Booms Music",
                    "5",
                    "House music. Beach vacations. Sushi.",
                    "4"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img02.jpg",
                    "http://www.benairyresearch.net/dev/Video2.mp4",
                    "Harry, 32\nMacquarie University",
                    "Macquarie University",
                    "1",
                    "Good wine and party anytime.",
                    "5"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img03.jpg",
                    "http://www.benairyresearch.net/dev/Video3.mp4",
                    "Sean, 24\nTruro College",
                    "Truro College",
                    "10",
                    "Just looking for someone to share a cup of hot chocolate when it's cold outside.",
                    "2"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img04.jpg",
                    "http://www.benairyresearch.net/dev/Video4.mp4",
                    "Jon, 42\nCEO",
                    "CEO",
                    "7",
                    "Come let's go to the other side of the world where it's only YOU and ME...",
                    "3"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img05.jpg",
                    "http://www.benairyresearch.net/dev/Video5.mp4",
                    "Charlotte, 32\nSenior Talent Agent",
                    "Senior Talent Agent",
                    "1",
                    "My face is a 4. My personality is a 6. So basically I'm a 10.",
                    "5"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img06.jpg",
                    "http://www.benairyresearch.net/dev/Video6.mp4",
                    "Tori, 33\nMedical Sales Rep",
                    "Medical Sales Rep",
                    "10",
                    "Laughing is the best medicine. Send a joke my way.",
                    "3"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img07.jpg",
                    "http://www.benairyresearch.net/dev/Video7.mp4",
                    "Misty, 22\nUNSW",
                    "UNSW",
                    "1",
                    "Nature lover, hiker, yoga instructor, foodie, smart, dog lover, writer.",
                    "4"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img08.jpg",
                    "http://www.benairyresearch.net/dev/Video8.mp4",
                    "Nao, 28\nExecutive Assistance",
                    "Executive Assistance",
                    "6",
                    "I love long walks in the park with my puppy and I'm looking for someone to walk with me.",
                    "4"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img09.jpg",
                    "http://www.benairyresearch.net/dev/Video9.mp4",
                    "Rico, 24\nUniversity of Technology Sydney",
                    "University of Technology Sydney",
                    "2",
                    "Half Swiss Half Colombian in Australia 8 years.",
                    "3"));
            al.add(new CardData(
                    "http://www.benairyresearch.net/dev/img10.jpg",
                    "http://www.benairyresearch.net/dev/Video10.mp4",
                    "Hayley, 33\nMake-up Artist",
                    "Make-up Artist",
                    "11",
                    "I love to stay fit and healthy. I enjoy running and anything outdoors.",
                    "5"));

//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "11. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "12. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "13. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "14. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "15. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "16. ", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "17. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "18. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "19. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "20. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "21. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "22. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "23. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "24. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "25. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "26. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "27. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "28. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "29. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "30. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "31. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "32. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "33. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "34. ", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "35. ", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "36. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "37. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "38. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "39. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "40. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "41. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "42. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "43. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "44. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "45. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "46. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "47. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "48. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "49. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "50. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "51. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "52. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "53. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "54. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "55. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "56. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "57. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "58. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "59. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "60. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//
//            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "70. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid03.mp4"));
//
//            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "80. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//
//            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "90. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//
//            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
//            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "100. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid02.mp4"));

            counter++;
        }
//        al.add("php");
//        al.add("c");
//        al.add("python");
//        al.add("java");
//        al.add("html");
//        al.add("c++");
//        al.add("css");
//        al.add("javascript");

        myAppAdapter = new MyAppAdapter(al, MainActivity.this);
        flingContainer.setAdapter(myAppAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed card!");
                //al.remove(0);
                //arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {

                //Save details to database here
                CardData cardData = al.get(0);
                String shortNameAge = cardData.getShortNameAge();
                Log.d("CARD-LEFT-EXIT", shortNameAge);

                al.remove(0);
                myAppAdapter.notifyDataSetChanged();
                //makeToast(MainActivity.this, "Left!");
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject

            }

            @Override
            public void onRightCardExit(Object dataObject) {
                al.remove(0);
                myAppAdapter.notifyDataSetChanged();
                //makeToast(MainActivity.this, "Right!");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                //al.add("XML ".concat(String.valueOf(i)));
                //myAppAdapter.notifyDataSetChanged();
                Log.d("LIST", "about to empty");
                //i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                if (view != null) { //cammy add if condition to resolve Issue01
                    view.findViewById(R.id.background).setAlpha(0);
                    view.findViewById(R.id.right_indicator_swipe).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                    view.findViewById(R.id.left_indicator_swipe).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
                } //cammy add if condition to resolve Issue01
            }
        });

        // Display long details panel when card is clicked on
        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                myAppAdapter.notifyDataSetChanged();
                //makeToast(MainActivity.this, "Clicked!");

                showHideLongDetailsPanel(view);

                setDataInLongDetailsPanel(view);
            }
        });

    } //end method onCreate()

    @OnClick(R.id.right)
    public void right() {
        /**
         * Trigger the right event manually.
         */
        flingContainer.getTopCardListener().selectRight();
    }

    @OnClick(R.id.left)
    public void left() {
        flingContainer.getTopCardListener().selectLeft();
    }

    @Override
    public void onActionDownPerform() {
        Log.e("action", "bingo");
    }

    public static class ViewHolder {
        public static FrameLayout background;
        public TextView DataText;
        public ImageView cardImage;
        public ImageButton playVideoButton;

    }

    public class MyAppAdapter extends BaseAdapter {

        public List<CardData> cardDataList;
        public Context context;

        private MyAppAdapter(List<CardData> apps, Context context) {
            this.cardDataList = apps;
            this.context = context;
        }

        @Override
        public int getCount() {
            return cardDataList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        //Performs loading of profile data
        public View getView(final int position, View convertView, ViewGroup parent) {
            View rowView = convertView;

            if (rowView == null) {
                LayoutInflater inflater = getLayoutInflater();

                //This is where item.xml is displayed
                rowView = inflater.inflate(R.layout.item, parent, false);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.DataText = (TextView) rowView.findViewById(R.id.short_name_age);
                viewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.profile_image);
                //get play video button
                viewHolder.playVideoButton = (ImageButton) rowView.findViewById(R.id.play_video_button);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.DataText.setText(cardDataList.get(position).getShortNameAge() + "");

            Glide.with(MainActivity.this).load(cardDataList.get(position).getImagePath()).into(viewHolder.cardImage);

            //Start to play video when button is clicked
            try {
                viewHolder.playVideoButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {

                        //Start a new Activity to play video on a new page
                        Intent intent = new Intent(view.getContext(), PlayVideoActivity.class);
                        //pass over the videoPath
                        String videoPath = cardDataList.get(position).getVideoPath();
                        intent.putExtra("VideoPath", videoPath);
                        startActivity(intent);
                    }
                });
            }
            catch (Exception e){
                System.out.println("Error when playing video.");
            }

            return rowView;
        }
    }

    public static void removeBackground() {
        viewHolder.background.setVisibility(View.GONE);
        myAppAdapter.notifyDataSetChanged();
    }

    static void makeToast(Context ctx, String s) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }

    private void showHideLongDetailsPanel(View view) {
        LinearLayout longDetailsPanel = (LinearLayout) view.findViewById(R.id.long_details_panel);
        float top = longDetailsPanel.getTop();
        float bottom = longDetailsPanel.getBottom();
        //System.out.printf("[Top]: %.2f \n",top);
        //System.out.printf("[Bottom]: %.2f \n",bottom);
        //toggle show/hide profile details panel
        float transparent = 0.0f; //0 means transparent
        if (longDetailsPanel.getAlpha() == transparent) {
            Log.d("alpha","alpha is 0");
            longDetailsPanel.setAlpha(1.0f); //display details panel if it is transparent (can set to 0.85f for translucent effect)

            //animate detailsPanel to slide up when click on card
            float topAfter = longDetailsPanel.getTop();
            float bottomAfter = longDetailsPanel.getBottom();
            //System.out.printf("[topAfter]: %.2f \n",topAfter);
            //System.out.printf("[bottomAfter]: %.2f \n",bottomAfter);

            ObjectAnimator heightAnimator = ObjectAnimator
                    .ofFloat(longDetailsPanel, "y", bottomAfter, topAfter)
                    .setDuration(100);
            heightAnimator.setInterpolator(new AccelerateInterpolator());
            heightAnimator.start();

        } else {
            Log.d("alpha","alpha is 1");
            longDetailsPanel.setAlpha(0); //set details panel to transparent if it is shown
        }
    }

    private void setDataInLongDetailsPanel(View view){
        CardData cardData = al.get(0);

        //Set Name and Age
        TextView longNameAgeTV = (TextView) view.findViewById(R.id.long_name_age);
        String shortNameAge = cardData.getShortNameAge();
        longNameAgeTV.setText(shortNameAge);

        //Set Work or Study Location
        TextView workStudyLocationTV = (TextView) view.findViewById(R.id.work_study_location);
        String workStudyLocation = cardData.getWorkStudyLocation();
        workStudyLocationTV.setText(workStudyLocation);

        //Set Distance Away
        TextView distanceAwayTV = (TextView) view.findViewById(R.id.distance_away);
        String distanceAway = cardData.getDistanceAway() + " km away";
        distanceAwayTV.setText(distanceAway);

        //Set Description
        TextView descriptionTV = (TextView) view.findViewById(R.id.description);
        String description = cardData.getDescription();
        descriptionTV.setText(description);

        //Set Rating
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        float starRating = Float.parseFloat(cardData.getRating());
        ratingBar.setRating(starRating);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Menu icons are inflated just as they were with actionbar
        // This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.facebookLogout:
                //makeToast(MainActivity.this,"Logout");
                facebookLogout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void facebookLogout() {
        PrefUtils.clearCurrentUser(MainActivity.this);

        // We can logout from facebook by calling following method
        LoginManager.getInstance().logOut();

        //Return to login page
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
