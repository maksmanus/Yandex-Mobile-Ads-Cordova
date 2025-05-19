# Yandex Mobile ads Cordova plugin

## Install:
`npm install yamobads-cordova` 
or
`cordova plugin add yamobads-cordova`

### This plugin works only android cordova apps

# `YaMobAds.YandexAdsInit`
Initializes Yandex mobile Ads

# `YaMobAds.SetUserContent(EnableUserContent: boolean)`
Sets User Content, 
## parsms: 
## `EnableUserContent` - enabling user content in ads
`
# `YamobAds.SetAgeRestrictedUser(EnablegeRestrictedUser: boolean)`
Sets Age Restricted User

## params:
## `EnablegeRestrictedUser` - enable age restricted user

# `YaMobAds.LoadInterstialAd(AdBlockId: string)`
Loads Interstial Yandex Ads

## params
## `AdBlockId` - ad block id

# `YaMobAds.ShowInterstialAd()`
Shows interstial Yandex Ads 

# `YaMobAds.DestroyInterstialAd()`
Destroys interstial Yandex ads

# `YaModAds.LoadRewardedAd(AdBlockId: string)`
Loads rewarded Yandex ads

## params
## `AdBlockId` - ad block id

# `YaMobAds.ShowRewardedAd()`
Shows rewarded Yandex ads

# `YaMobAds.DestroyRewardedAd()`
Destroys rewarded Yandex Ads

# `LoadStickyBannerAd(AdBlockId: string)`
Loads sticky banner Yandex ads

## params
## `AdBlockId` - ad block id

# `YaMobAds.DestroyStickyBanner()`
Destroys sticky banner Yandex ads

# `YaMobAds.DemoBlocks`
Object contains demo ad blocks Yandex ads fro testing ads

You can read more about it [Here](https://ads.yandex.com/helpcenter/en/dev/android/demo-blocks)

# `YaMobAds.InterstialEventsNames`
InterstialEventsNames contains Interstial Yandex Ads Events, using example`document.addEventListener(YaMobAds.InterstialEventsNames.onAdClicked, YOUR_FUNCTION)` 

# `YaModAds.RewardedEventsNames`
RewardedEventsNames contains Rewarded Yandex Ads Events, using `document.addEventListener(YaMobAds.RewardedEventsNames.onAdClicked, YOUR_FUNCTION)`

# `YaMobAds.StickyEventsNames`
 StickyEventsNames contains Sticky banner Yandex Ads Events, using `document.addEventListener(YaMobAds.StickyEventsNames.onAdClicked, YOUR_FUNCTION)`