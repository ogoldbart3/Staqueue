package com.grailcloset.staqueue;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
//    private ViewPager pager = null;
//    private MainPagerAdapter pagerAdapter = null;

    //-----------------------------------------------------------------------------
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Datamart.getInstance().setMainPagerAdapter(new MainPagerAdapter());
        Datamart.getInstance().setViewPager( (ViewPager) findViewById( R.id.view_pager ) );
        Datamart.getInstance().getViewPager().setAdapter(Datamart.getInstance().getMainPagerAdapter());

        // Create an initial view to display; must be a subclass of FrameLayout.
        LayoutInflater inflater = getLayoutInflater();

        FrameLayout v1 = (FrameLayout) inflater.inflate (R.layout.page_layout, null);
        Button button = (Button) v1.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout v1 = (FrameLayout) getLayoutInflater().inflate (R.layout.page_layout, null);
                Datamart.getInstance().addView(v1);
                Datamart.getInstance().notifyChange();
            }
        });
        Datamart.getInstance().addView( v1 );
        Datamart.getInstance().notifyChange();
    }

    //-----------------------------------------------------------------------------
    // Here's what the app should do to add a view to the ViewPager.
//    public void addView (View newPage)
//    {
//        int pageIndex = Datamart.getInstance().getMainPagerAdapter().addView(newPage);
//        // You might want to make "newPage" the currently displayed page:
////        pager.setCurrentItem (pageIndex, true);
//    }
//
//    //-----------------------------------------------------------------------------
//    // Here's what the app should do to remove a view from the ViewPager.
//    public void removeView (View defunctPage) {
//        int pageIndex = Datamart.getInstance().getMainPagerAdapter().removeView( Datamart.getInstance().getViewPager(), defunctPage );
//        // You might want to choose what page to display, if the current page was "defunctPage".
//        if ( pageIndex == Datamart.getInstance().getMainPagerAdapter().getCount() ) {
//            pageIndex--;
//        }
//        Datamart.getInstance().getViewPager().setCurrentItem(pageIndex);
//    }
//
//    //-----------------------------------------------------------------------------
//    // Here's what the app should do to get the currently displayed page.
//    public View getCurrentPage () {
//        return Datamart.getInstance().getMainPagerAdapter().getView(Datamart.getInstance().getViewPager().getCurrentItem());
//    }
//
//    //-----------------------------------------------------------------------------
//    // Here's what the app should do to set the currently displayed page.  "pageToShow" must
//    // currently be in the adapter, or this will crash.
//    public void setCurrentPage (View pageToShow) {
//        Datamart.getInstance().getViewPager().setCurrentItem(Datamart.getInstance().getMainPagerAdapter().getItemPosition(pageToShow), true);
//    }
}
