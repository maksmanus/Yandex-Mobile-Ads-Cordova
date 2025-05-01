package com.ZeroProd.yamobads;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.engine.SystemWebView;
import org.json.JSONArray;
import org.json.JSONException;

import com.yandex.mobile.ads.interstitial.InterstitialAd;
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener;
import com.yandex.mobile.ads.interstitial.InterstitialAdLoadListener;
import com.yandex.mobile.ads.interstitial.InterstitialAdLoader;
import com.yandex.mobile.ads.rewarded.Reward;
import com.yandex.mobile.ads.rewarded.RewardedAd;
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener;
import com.yandex.mobile.ads.rewarded.RewardedAdLoadListener;
import com.yandex.mobile.ads.rewarded.RewardedAdLoader;
import com.yandex.mobile.ads.banner.BannerAdEventListener;
import com.yandex.mobile.ads.banner.BannerAdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdError;
import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.AdRequestConfiguration;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.common.ImpressionData;
import com.yandex.mobile.ads.common.MobileAds;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class YaMobAds extends CordovaPlugin 
{
    Activity activity;
    FrameLayout adContainer = null;
    public static YaMobAds Instance = null;

    // interstialad block
    private InterstitialAd interstitialAd = null;
    private InterstitialAdLoader interstitialAdLoader = null;  
    private AdRequest bannerAdLoader = null;

    // rewarded ad block
    private RewardedAd rewardedAd = null;
    private RewardedAdLoader rewardedAdLoader = null;
    private BannerAdView bannerAd = null;
    

    public Activity getActivity() 
    {
        return (Activity) this.webView.getContext();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException 
    {
        if (action.equals("YandexAdsInit")) 
        {
            CookieManager.getInstance().setAcceptCookie(false);
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    MobileAds.initialize(activity, () -> {
                    });
                    callbackContext.success();
                }
            });
            return true;
        }

        if (action.equals("SetUserContent")) 
        {
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    try 
                    {
                        MobileAds.setUserConsent(args.getBoolean(0));
                        callbackContext.success();
                    } 
                    catch (Exception e) 
                    {
                    
                    }
                }
            });
            return true;
        }

        if (action.equals("SetAgeRestrictedUser")) 
        {
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    try 
                    {
                        MobileAds.setAgeRestrictedUser(args.getBoolean(0));
                        callbackContext.success();
                    } 
                    catch (Exception e) 
                    {

                    }
                }
            });
            return true;
        }

        // interstial ad block
        if (action.equals("LoadInterstialAd")) 
        {
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    try 
                    {
                        String ad_id = args.getString(0);
                        interstitialAdLoader = new InterstitialAdLoader(activity);
                        interstitialAdLoader.setAdLoadListener(new InterstitialAdLoadListener()
                        {
                            @Override
                            public void onAdFailedToLoad(AdRequestError arg0) 
                            {
                                Utils.RunJsEvent(InterstialEvents.onAdFailedToLoad);
                            }
    
                            @Override
                            public void onAdLoaded(InterstitialAd arg0) 
                            {
                                interstitialAd = arg0;
                                interstitialAd.setAdEventListener(new InterstitialAdEventListener() 
                                {
    
                                    @Override
                                    public void onAdClicked() 
                                    {
                                        Utils.RunJsEvent(InterstialEvents.onAdClicked);
                                    }
    
                                    @Override
                                    public void onAdDismissed() 
                                    {
                                        Utils.RunJsEvent(InterstialEvents.onAdDismissed);
                                    }
    
                                    @Override
                                    public void onAdFailedToShow(AdError arg0) 
                                    {
                                        Utils.RunJsEvent(InterstialEvents.onAdFailedToShow);
                                    }
    
                                    @Override
                                    public void onAdImpression(ImpressionData arg0) 
                                    {
                                        Utils.RunJsEvent(InterstialEvents.onAdImpression);
                                    }
    
                                    @Override
                                    public void onAdShown()
                                    {
                                        Utils.RunJsEvent(InterstialEvents.onAdShown);
                                    }
                                    
                                });
                                StaticState.IsInterstialLoaded = true;
                                Utils.RunJsEvent(InterstialEvents.onAdLoaded);
                            }
                        });     
                        AdRequestConfiguration configuration = new AdRequestConfiguration.Builder(ad_id).build();
                        interstitialAdLoader.loadAd(configuration);
                        callbackContext.success();
                    } 
                    catch (Exception e) 
                    {
                        // TODO: handle exception
                    }
                }
            });
            return true;
        }

        if (action.equals("ShowInterstialAd")) 
        {
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    try 
                    {
                        if (interstitialAd != null) 
                        {
                            interstitialAd.show(cordova.getActivity());
                            callbackContext.success();
                        }
                    } 
                    catch (Exception e) 
                    {
                        // TODO: handle exception
                    }
                }
            });

            return true;
        }

        if (action.equals("DestroyInterstialAd")) 
        {
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    if (interstitialAd != null) 
                    {
                        if (interstitialAdLoader != null) 
                        {
                            interstitialAdLoader.setAdLoadListener(null);
                            interstitialAdLoader = null;
                        }

                        interstitialAd.setAdEventListener(null);
                        interstitialAd = null;
                        callbackContext.success();
                    } 
                    else 
                    {
                        callbackContext.error("Interstial Ad is NULL");
                    }
                }
            });

            return true;
        }

        // rewarded ad block
        if(action.equals("LoadRewardedAd"))
        {
            String ad_id = args.getString(0);
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    rewardedAdLoader = new RewardedAdLoader(activity);
                    rewardedAdLoader.setAdLoadListener(new RewardedAdLoadListener() 
                    {

                        @Override
                        public void onAdFailedToLoad(AdRequestError arg0)
                        {
                            Utils.RunJsEvent(RewardedEvents.onAdFailedToLoad);                            
                        }

                        @Override
                        public void onAdLoaded(RewardedAd arg0)
                        {
                            rewardedAd = arg0;
                            rewardedAd.setAdEventListener(new RewardedAdEventListener()
                            {

                                @Override
                                public void onAdClicked() 
                                {
                                    Utils.RunJsEvent(RewardedEvents.onAdClicked);
                                }

                                @Override
                                public void onAdDismissed() 
                                {
                                    Utils.RunJsEvent(RewardedEvents.onAdDismissed);
                                }

                                @Override
                                public void onAdFailedToShow(AdError arg0) 
                                {
                                    Utils.RunJsEvent(RewardedEvents.onAdFailedToShow);
                                }

                                @Override
                                public void onAdImpression(ImpressionData arg0)
                                {
                                    Utils.RunJsEvent(RewardedEvents.onAdImpression);
                                }

                                @Override
                                public void onAdShown() 
                                {
                                    Utils.RunJsEvent(RewardedEvents.onAdShown);
                                }

                                @Override
                                public void onRewarded(Reward arg0)
                                {
                                    Utils.RunJsEvent(RewardedEvents.onRewarded);
                                }
                                
                            });
                            Utils.RunJsEvent(RewardedEvents.onAdLoaded);    
                        }
                    });

                    AdRequestConfiguration config = new AdRequestConfiguration.Builder(ad_id).build();
                    rewardedAdLoader.loadAd(config);
                    callbackContext.success();
                }
            });

            return true;
        }
        
        if(action.equals("ShowRewardedAd"))
        {
            activity.runOnUiThread(new Runnable()
            {
                @Override
                public void run() 
                {
                    rewardedAd.show(cordova.getActivity());
                    callbackContext.success();
                }
            });

            return true;
        }

        if(action.equals("DestroyRewardedAd"))
        {
            if(rewardedAd != null)
            {
                rewardedAd.setAdEventListener(null);
                rewardedAd = null;
            }

            if(rewardedAdLoader != null)
            {
                rewardedAdLoader.setAdLoadListener(null);
                rewardedAdLoader = null;
            }

            return true;
        }
        
        if(action.equals("LoadStickyBannerAd"))
        {
            String ad_id = args.getString(0);
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    Toast.makeText(activity, ad_id, Toast.LENGTH_LONG);
                    bannerAd = new BannerAdView(activity);
                    bannerAd.setAdSize(Utils.getAdSize(activity));
                    bannerAd.setAdUnitId(ad_id);

                    activity.addContentView(bannerAd, new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM));
                    bannerAd.setBannerAdEventListener(new BannerAdEventListener() 
                    {

                        @Override
                        public void onAdClicked() 
                        {
                            Utils.RunJsEvent(StickyAdEvents.onAdClicked);
                        }

                        @Override
                        public void onAdFailedToLoad(AdRequestError arg0) 
                        {
                            Utils.RunJsEvent(StickyAdEvents.onAdFailedToLoad);
                        }

                        @Override
                        public void onAdLoaded() 
                        {
                            Utils.RunJsEvent(StickyAdEvents.onAdLoaded);
                        }

                        @Override
                        public void onImpression(ImpressionData arg0) 
                        {
                            Utils.RunJsEvent(StickyAdEvents.onImpression);
                        }

                        @Override
                        public void onLeftApplication() 
                        {
                            Utils.RunJsEvent(StickyAdEvents.onLeftApplication);
                        }

                        @Override
                        public void onReturnedToApplication() 
                        {
                            Utils.RunJsEvent(StickyAdEvents.onReturnedToApplication);
                        }    
                    });
                    bannerAdLoader = new AdRequest.Builder().build();
                    bannerAd.loadAd(bannerAdLoader);
                    callbackContext.success();
                }
            });
            return true;
        }
        
        if(action.equals("DestroyStickyBanner"))
        {
            activity.runOnUiThread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    if(bannerAd != null)
                    {
                        ViewGroup parent = (ViewGroup) bannerAd.getParent();
                        parent.removeView(bannerAd);

                        bannerAd.destroy();
                        bannerAd.setBannerAdEventListener(null);
                        bannerAd = null;
                    }
                }
                
            });
            callbackContext.success();
            return true;
        }
        return false;
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) 
    {
        super.initialize(cordova, webView);
        activity = this.getActivity();
        Instance = this;
    }
}