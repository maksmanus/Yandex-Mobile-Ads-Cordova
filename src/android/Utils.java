package com.ZeroProd.yamobads;

import com.yandex.mobile.ads.banner.BannerAdSize;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

public class Utils 
{
    public static void RunJsEvent(String eventname)
    {
        String callEvent = String.format("javascript:document.dispatchEvent(new Event('%s'))", eventname);
        YaMobAds.Instance.getActivity().runOnUiThread(new Runnable() 
        {
            @Override
            public void run() 
            {
                YaMobAds.Instance.webView.loadUrl(callEvent);
            }
        });
    }    

    public static FrameLayout CreateBannerLayout(final int width, final int height, final int gravity)
    {
        FrameLayout root = (FrameLayout) YaMobAds.Instance.getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
        final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
        params.gravity = gravity;
        

        FrameLayout layout = new FrameLayout(YaMobAds.Instance.activity);
        YaMobAds.Instance.activity.runOnUiThread(new Runnable() 
        {
            @Override
            public void run() 
            {
                root.addView(layout, params);
            }
            
        });
        return layout;
    }

    @NonNull
    public static BannerAdSize getAdSize(Activity activity) {
        final DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        
        // Получаем root View activity
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        
        // Рассчитываем ширину баннера
        int adWidthPixels = rootView.getWidth();
        if (adWidthPixels == 0) {
            // Если View еще не отрисовано, используем полную ширину экрана
            adWidthPixels = displayMetrics.widthPixels;
        }
        
        // Конвертируем пиксели в dp
        final int adWidthDp = Math.round(adWidthPixels / displayMetrics.density);
        
        return BannerAdSize.stickySize(activity, adWidthDp);
    }
}
