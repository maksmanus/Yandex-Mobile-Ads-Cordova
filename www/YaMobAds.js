var exec = require('cordova/exec');
var cordova = require('cordova');

let _YaMobAds = function ()
{
    this.DemoBlocks =
    {
        YandexBanner: 'demo-banner-yandex',
        YandexInterstial: 'demo-interstitial-yandex',
        YandexRewarded: 'demo-rewarded-yandex',
        YandexNativeApp: 'demo-native-app-yandex',
        YandexNativeVideo: 'demo-native-video-yandex',
        YandexNativeContent: 'demo-native-content-yandex',
        YandexAppopenAd: 'demo-appopenad-yandex',
        YandexFeed: 'demo-feed-yandex',
        YandexNativeBulk: 'demo-native-bulk-yandex',
    }

    this.InterstialEventsNames = 
    {
        onAdFailedToLoad: 'onAdFailedToLoadInterstial',
        onAdLoaded: 'onAdLoadedInterstial',
        onAdClicked: 'onAdClickedInterstial',
        onAdDismissed: 'onAdDismissedInterstial',
        onAdFailedToShow: 'onAdFailedToShowInterstial',
        onAdImpression: 'onAdImpressionInterstial',
        onAdShown: 'onAdShownInterstial'
    }

    this.RewardedEventsNames = 
    {
        onAdFailedToLoad: 'onAdFailedToLoadRewarded',
        onAdLoaded: 'onAdLoadedRewarded',
        onAdClicked: 'onAdClickedRewarded',
        onAdDismissed: 'onAdDismissedRewarded',
        onAdFailedToShow: 'onAdFailedToShowRewarded',
        onAdImpression: 'onAdImpressionRewarded',
        onAdShown: 'onAdShownRewarded',
        onRewarded: 'onRewardedRewarded'
    }

    this.StickyEventsNames = 
    {
        onAdClicked: 'onAdClickedSticky',
        onAdFailedToLoad: 'onAdFailedToLoadSticky',
        onAdLoaded: 'onAdLoadedSticky',
        onImpression: 'onImpressionSticky',
        onLeftApplication: 'onLeftApplicationSticky',
        onReturnedToApplication: 'onReturnedToApplicationSticky'
    }

    this.YandexAdsInit = function () 
    {
        exec(null, null, 'YaMobAds', 'YandexAdsInit', [null]);
        //Initialize InterstialEvents
    }

    this.SetUserContent = function (EnableUserContent)
    {
        if(typeof EnableUserContent === 'boolean')
        {
            exec(null, null, 'YaMobAds', 'SetUserContent', [EnableUserContent]);
        } 
    }

    this.SetAgeRestrictedUser = function (EnablegeRestrictedUser)
    {
        if(typeof EnablegeRestrictedUser === 'boolean')
        {
            exec(null, null, 'YaMobAds', 'SetAgeRestrictedUser', [EnablegeRestrictedUser]);
        }
    }

    // interstial ad block
    this.LoadInterstialAd = function(AdBlockId)
    {
        if(typeof AdBlockId === 'string')
        {
            exec(null, null, 'YaMobAds', 'LoadInterstialAd', [AdBlockId]);
        }
    }

    this.ShowInterstialAd = function()
    {
        exec(null, null, 'YaMobAds', 'ShowInterstialAd', [null]);
    }

    this.DestroyInterstialAd = function()
    {
        exec(null, null, 'YaMobAds', 'DestroyInterstialAd', [null]);
    }

    //rewarded ad block
    this.LoadRewardedAd = function(AdBlockId)
    {
        if(typeof AdBlockId === 'string')
        {
            exec(null, null, 'YaMobAds', 'LoadRewardedAd', [AdBlockId]);
        }
    }

    this.ShowRewardedAd = function()
    {
        exec(null, null, 'YaMobAds', 'ShowRewardedAd', [null]);
    }

    this.DestroyRewardedAd = function()
    {
        exec(null, null, 'YaMobAds', 'DestroyRewardedAd', [null]);
    }

    this.LoadStickyBannerAd = function(AdBlockId)
    {
        exec(null, null, 'YaMobAds', 'LoadStickyBannerAd', [AdBlockId]);
    }

    this.DestroyStickyBanner = function()
    {
        exec(null, null, 'YaMobAds', 'DestroyStickyBanner', [null]);
    }
}

let YaMobAds = new _YaMobAds()

module.exports = YaMobAds;
