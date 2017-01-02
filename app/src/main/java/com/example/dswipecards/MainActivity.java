package com.example.dswipecards;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dswipecards.tindercard.FlingCardListener;
import com.example.dswipecards.tindercard.SwipeFlingAdapterView;

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
            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "10. April, 35\nTech"));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "11. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "12. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "13. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "14. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "15. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "16. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "17. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "18. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "19. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "20. "));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "21. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "22. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "23. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "24. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "25. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "26. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "27. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "28. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "29. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "30. "));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "31. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "32. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "33. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "34. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "35. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "36. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "37. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "38. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "39. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "40. "));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "41. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "42. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "43. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "44. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "45. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "46. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "47. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "48. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "49. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "50. "));

            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "51. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "52. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "53. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "54. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "55. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "56. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "57. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "58. "));
            al.add(new CardData("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "59. "));
            al.add(new CardData("http://www.benairyresearch.net/dev/shape.jpg", "60. "));

            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "70. April, 35\nTech"));

            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "80. April, 35\nTech"));

            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "90. April, 35\nTech"));

            al.add(new CardData("http://www.benairyresearch.net/dev/img01.jpg", "1. Leo, 38\nUNSW"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img02.jpg", "2. Harry, 32\nUniSys"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img03.jpg", "3. Joe, 29\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img04.jpg", "4. Brad, 21\nIBM"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img05.jpg", "5. Lucy, 30\nMyer"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img06.jpg", "6. Angel, 35\nPriceline"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img07.jpg", "7. Jane, 32\nNoni B"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img08.jpg", "8. Jenni, 30\nHollier"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img09.jpg", "9. Amy, 39\nColes"));
            al.add(new CardData("http://www.benairyresearch.net/dev/img10.jpg", "100. April, 35\nTech"));

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
                if (view!=null) { //cammy add if condition to resolve Issue01
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
            }
        });

    }

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

    }

    public class MyAppAdapter extends BaseAdapter {

        public List<CardData> parkingList;
        public Context context;

        private MyAppAdapter(List<CardData> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
        }

        @Override
        public int getCount() {
            return parkingList.size();
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
                rowView = inflater.inflate(R.layout.item, parent, false);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.DataText = (TextView) rowView.findViewById(R.id.bookText);
                viewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.cardImage);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.DataText.setText(parkingList.get(position).getDescription() + "");

            Glide.with(MainActivity.this).load(parkingList.get(position).getImagePath()).into(viewHolder.cardImage);

            return rowView;
        }
    }
}
