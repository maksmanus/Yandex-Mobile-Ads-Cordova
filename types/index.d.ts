
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

    export class _YaMobAds {
        DemoBlocks: DemoBlocks;
        InterstialEventsNames: InterstialEventsNames;
        RewardedEventsNames: RewardedEventsNames;
        StickyEventsNames: StickyEventsNames;

        YandexAdsInit(): void;
        SetUserContent(EnableUserContent: boolean): void;
        SetAgeRestrictedUser(EnablegeRestrictedUser: boolean): void;
        
        // Interstitial
        LoadInterstialAd(AdBlockId: string): void;
        ShowInterstialAd(): void;
        DestroyInterstialAd(): void;
        
        // Rewarded
        LoadRewardedAd(AdBlockId: string): void;
        ShowRewardedAd(): void;
        DestroyRewardedAd(): void;
        
        // Sticky Banner
        LoadStickyBannerAd(AdBlockId: string): void;
        DestroyStickyBanner(): void;
    }

    export var YaMobAds : _YaMobAds;