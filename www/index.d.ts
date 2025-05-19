
// YaMobAds.d.ts

    export class DemoBlocks {
        YandexBanner: string;
        YandexInterstial: string;
        YandexRewarded: string;
        YandexNativeApp: string;
        YandexNativeVideo: string;
        YandexNativeContent: string;
        YandexAppopenAd: string;
        YandexFeed: string;
        YandexNativeBulk: string;
    }

    export class InterstialEventsNames {
        onAdFailedToLoad: string;
        onAdLoaded: string;
        onAdClicked: string;
        onAdDismissed: string;
        onAdFailedToShow: string;
        onAdImpression: string;
        onAdShown: string;
    }

    export class RewardedEventsNames {
        onAdFailedToLoad: string;
        onAdLoaded: string;
        onAdClicked: string;
        onAdDismissed: string;
        onAdFailedToShow: string;
        onAdImpression: string;
        onAdShown: string;
        onRewarded: string;
    }

    export class StickyEventsNames {
        onAdClicked: string;
        onAdFailedToLoad: string;
        onAdLoaded: string;
        onImpression: string;
        onLeftApplication: string;
        onReturnedToApplication: string;
    }

    export class _YaMobAds 
    {
        /**
         * Demo Blocks Yandex ads ids 
         */
        DemoBlocks: DemoBlocks;
        
        /**
         * InterstialEventsNames contains Interstial Yandex Ads Events, using `document.addEventListener(YaMobAds.InterstialEventsNames.onAdClicked, YOUR_FUNCTION)` 
         * @example document.addEventListener(YaMobAds.InterstialEventsNames.onAdClicked, YOUR_FUNCTION)
         */
        InterstialEventsNames: InterstialEventsNames;
        /**
         * RewardedEventsNames contains Rewarded Yandex Ads Events, using `document.addEventListener(YaMobAds.RewardedEventsNames.onAdClicked, YOUR_FUNCTION)`
         * @example document.addEventListener(YaMobAds.RewardedEventsNames.onAdClicked, YOUR_FUNCTION)
         */
        RewardedEventsNames: RewardedEventsNames;
        /**
         * StickyEventsNames contains Sticky banner Yandex Ads Events, using `document.addEventListener(YaMobAds.StickyEventsNames.onAdClicked, YOUR_FUNCTION)`
         * @example document.addEventListener(YaMobAds.StickyEventsNames.onAdClicked, YOUR_FUNCTION)
         */
        StickyEventsNames: StickyEventsNames;

        /**
         * Initializes Yandex Ads
         */
        YandexAdsInit(): void;
        /**
         * Set User Content for Yandex Ads
         * @param EnableUserContent - Enabling ads setting user content, type: `boolean`, using `YaMobAds.SetUserContent(true)`
         * @example YaMobAds.SetUserContent(true)
         */
        SetUserContent(EnableUserContent: boolean): void;
        /**
         * 
         * @param EnablegeRestrictedUser enable restricted user for Yandex Ads, using `YaMobAds.SetAgeRestrictedUser(true)`
         * @example YaMobAds.SetAgeRestrictedUser(true)
         */
        SetAgeRestrictedUser(EnablegeRestrictedUser: boolean): void;
        
        // Interstitial
        /**
         * Loads Interstial Yandex ad
         * @param AdBlockId - blockid
         * using - `YaMobAds.LoadInterstialAd('ad-block-id)`
         * @example YaMobAds.LoadInterstialAd('ad-block-id)
         */
        LoadInterstialAd(AdBlockId: string): void;
        /**
         * Shows Interstial Yandex Ad
         */
        ShowInterstialAd(): void;
        /**
         * Destroys Interstial Yandex ads
         */
        DestroyInterstialAd(): void;
        
        /**
         * Loads Rewarded Yandex Ads
         * @param AdBlockId - blockid
         * using - `YaMobAds.LoadRewardedAd('ad-block-id)`
         * @example YaMobAds.LoadRewardedAd('ad-block-id)
         */
        LoadRewardedAd(AdBlockId: string): void;
        /**
         * Shows Rewarded Yandex Ads
         */
        ShowRewardedAd(): void;
        /**
         * Destroys Rewarded Yandex Ads 
         */
        DestroyRewardedAd(): void;
        
        // Sticky Banner
        /**
         * Loads Sticky Banner Yandex ads
         * @param AdBlockId - block id
         * using - `YaMobAds.LoadStickyBannerAd('ad-block-id)`
         * @example YaMobAds.LoadStickyBannerAd('ad-block-id)
         */
        LoadStickyBannerAd(AdBlockId: string): void;
        /**
         * Destroys Sticky Banner Yandex ads
         */
        DestroyStickyBanner(): void;
    }

    export * from './YaMobAds';
    import YaMobAds from './YaMobAds';
    export default YaMobAds;