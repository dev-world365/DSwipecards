package com.example.dswipecards;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dswipecards.tindercard.FlingCardListener;
import com.example.dswipecards.tindercard.SwipeFlingAdapterView;
import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FlingCardListener.ActionDownInterface {

    public static MyAppAdapter myAppAdapter;
    public static ViewHolder viewHolder;
    private ArrayList<CardData> al;
    private SwipeFlingAdapterView flingContainer;

    //facebook logout button
    private TextView buttonLogout;

    public static void removeBackground() {
        viewHolder.background.setVisibility(View.GONE);
        myAppAdapter.notifyDataSetChanged();
    }

//    private ArrayAdapter<CardData> arrayAdapter;
//    private int i;

//    @InjectView(R.id.frame) SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.inject(this);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        al = new ArrayList<>();

        //load 400 photos
        int counter = 0;
        while (counter < 4) {
            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "10. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid02.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "11. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "12. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "13. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "14. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "15. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "16. ", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "17. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "18. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "19. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "20. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "21. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "22. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "23. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "24. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "25. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "26. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "27. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "28. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "29. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "30. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "31. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "32. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "33. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "34. ", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "35. ", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "36. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "37. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "38. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "39. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "40. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "41. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "42. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "43. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "44. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "45. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "46. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "47. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "48. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "49. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "50. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "51. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "52. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "53. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "54. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "55. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "56. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "57. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "58. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "59. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "60. ", "http://www.benairyresearch.net/dev/myVid03.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid03.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "70. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid03.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "80. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid02.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "90. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid02.mp4"));

            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes", "http://www.benairyresearch.net/dev/myVid02.mp4"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "100. April, 35\nTech", "http://www.benairyresearch.net/dev/myVid02.mp4"));

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

//        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al );
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
                String description = cardData.getDescription();
                Log.d("CARD-LEFT-EXIT", description);

                al.remove(0);
                myAppAdapter.notifyDataSetChanged();
                makeToast(MainActivity.this, "Left!");
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject

            }

            @Override
            public void onRightCardExit(Object dataObject) {
                al.remove(0);
                myAppAdapter.notifyDataSetChanged();
                makeToast(MainActivity.this, "Right!");
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
                    view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                    view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
                } //cammy add if condition to resolve Issue01
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                //TODO: 06-Nov-16  add logic here to display tinder profile description
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                myAppAdapter.notifyDataSetChanged();
                makeToast(MainActivity.this, "Clicked!");

                CardData cardData = al.get(0);
                String description = cardData.getDescription();
                Log.d("CLICK", description);
                LinearLayout detailsPanel = (LinearLayout) view.findViewById(R.id.details_panel);
                TextView details = (TextView) view.findViewById(R.id.more_details);
                details.setText(description);
                float top = detailsPanel.getTop();
                float bottom = detailsPanel.getBottom();
                //System.out.printf("[Top]: %.2f \n",top);
                //System.out.printf("[Bottom]: %.2f \n",bottom);
                //toggle show/hide profile details panel
                float transparent = 0.0f; //0 means transparent
                if (detailsPanel.getAlpha() == transparent) {
                    Log.d("alpha","alpha is 0");
                    detailsPanel.setAlpha(1.0f); //display details panel if it is transparent (can set to 0.85 for translucent effect)

                    //animate detailsPanel to slide up when click on card
                    float topAfter = detailsPanel.getTop();
                    float bottomAfter = detailsPanel.getBottom();
                    //System.out.printf("[topAfter]: %.2f \n",topAfter);
                    //System.out.printf("[bottomAfter]: %.2f \n",bottomAfter);

                    ObjectAnimator heightAnimator = ObjectAnimator
                            .ofFloat(detailsPanel, "y", bottomAfter, topAfter)
                            .setDuration(100);
                    heightAnimator.setInterpolator(new AccelerateInterpolator());
                    heightAnimator.start();

                } else {
                    Log.d("alpha","alpha is 1");
                    detailsPanel.setAlpha(0); //set details panel to transparent if it is shown
                }
            }
        });

        //facebook logout button logic
        buttonLogout = (TextView) findViewById(R.id.buttonLogout);
        if (buttonLogout != null) {
            System.out.println("button logout is not null");
            buttonLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PrefUtils.clearCurrentUser(MainActivity.this);

                    // We can logout from facebook by calling following method
                    LoginManager.getInstance().logOut();

                    //Return to login page
                    Intent i = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        } else {
            System.out.println("button logout is null");
        }

    } //end method onCreate()

    static void makeToast(Context ctx, String s) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


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
        public Button playVideoButton;

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
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;


            if (rowView == null) {

                LayoutInflater inflater = getLayoutInflater();

                //This is where item.xml is displayed
                rowView = inflater.inflate(R.layout.item, parent, false);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.DataText = (TextView) rowView.findViewById(R.id.bookText);
                viewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.cardImage);
                //get play video button
                viewHolder.playVideoButton = (Button) rowView.findViewById(R.id.play_video_button);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.DataText.setText(cardDataList.get(position).getDescription() + "");

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
                System.out.println("Button listener cannot be added");
            }

            return rowView;
        }
    }
}
