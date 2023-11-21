Affirmations App - Intermediate Code
================================

Intermediate code for the Android Basics with Compose: Affirmations app.


Introduction
------------
The Affirmations app contains a scrollable list of 10 cards.


Pre-requisites
--------------
* Familiarity with Lists in Kotlin
* Experience building layouts with Jetpack Compose
* Experience running apps on a device or emulator


Getting Started
---------------
1. Install Android Studio, if you don't already have it.
2. Download the sample.
3. Import the sample into Android Studio.
4. Build and run the sample.

All photos by Romain Guy. All photos are licensed under CC0 https://creativecommons.org/share-your-work/public-domain/cc0/

# drawable 폴더
- XML 파일의 런처 아이콘에 관한 벡터가 포함되어 있다.
- 드로어블 아이콘의 경우 벡터는 컴파일될 때 이미지를 그리는 일력의 안내이다.

# mipmap 폴더
- 위치 확인 : Project 창 > 뷰를 Project로 전환 > 리소스 디렉터리(app > src > main > res)
- Android 앱의 런처 아이콘 에셋을 배치하는 위치
- 이전 버전과의 호환성을 위해 각 밀도 버킷(mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi)에 다양한 버전의 맵 아이콘 비트맵 이미지를 제공
## mdpi - 중밀도 화면의 리소스(~160dpi)
## hdpi - 고밀도 화면의 리소스 (~240dpi)
## xhdpi - 초고밀도 화면의 리소스(~320dpi)
## xxhdpi - 초초고밀도 화면의 리소스(~480dpi)
## xxxhdpi - 초초초고밀도 화면의 리소스(~640dpi)
## anydpi - 어떤 밀도로도 조정 가능한 리소스
## nodpi - 화면의 픽셀 밀도와 관계없이 조정할 수 없는 리소스

# mipmap-anydpi-v26
- 리소스 디렉터리에 리소스 한정자를 추가하여 특정 구성(v24 또는 v26)의 기기에서 사용해야 하는 리소스를 지정한다.
- 적응형 아이콘은 플랫폼의 API 수준 26에서 추가되었으므로 -v26 리소스 한정자가 있는 mipmap 리소스 디렉터리에서 선언해야 한다.
- 즉, v26 디렉터리의 리소스는 API 26(Android 8.0) 이상을 실행하는 기기에만 적용된다. 그 이하 버전에서는 이 디렉터리의 리소스 파일은 무시되고 버킷 밉맵 디렉터리로 대체된다.

# 비트맵 이미지와 벡터 그래픽
- 둘 다 그래픽을 설명한다.
## 비트맵 이미지
- 각 픽셀의 색상 정보를 제외하고 보유한 이미지에 관해 잘 모른다.
## 벡터 그래픽
- 이미지를 정의하는 모양을 그리는 방법을 안다.
- 색상 정보와 함께 일련의 점과 선, 곡선으로 구성된 지침을 가진다.
- 화질 저하 없이 모든 화면 밀도의 어떤 캔버스 크기로도 조정할 수 있다.

# 벡터 드로어블
- Android의 벡터 그래픽 구현
- 휴대기기에서 유연하도록 만들어졌다.
- 픽셀 단위의 고정된 크기가 없다.
- XML로 정의할 수 있다.
- 모든 밀도 버킷에 비트맵 에셋 버전을 제공하는 대신 이미지를 한 번만 정의하면 되므로, 맵의 크기가 줄어 유지가 쉬워진다.
- 단, 단순한 모양으로 구성된 아이콘이 아니라 복잡한 사진의 경우 비트맵 에셋을 사용하는 것이 더 효율적이다.

# foreground, background 레이어 에셋은 '둘 다 크기가 108dpi x 108dpi여야 한다'는 것과 같은 특정 요구사항들을 가진다.

# 안전 영역
- foreground 레이어 중심에 있는 직경 66dpi의 원
- 기기 제조업체의 마스크 모양에 따라 아이콘의 가장자리가 잘릴 수 있으므로 아이콘에 관한 주요 정보를 안전 영역에 배치해야 한다.
- 안전 영역 밖의 콘텐츠는 배경 색상과 같이 필수적이지 않아야 하며, 잘려도 괜찮다.

# 적응형 및 레거시 아이콘
- 안드로이드 8.0 이상 기기의 경우 적응형 아이콘(foreground vector drawable과 background vector drawable의 조합)을 사용할 수 있다.
- 8.0 미만(즉, 앱의 최소 필수 API 수준 이상) 기기의 경우 레거시 런처 아이콘(다양한 밀도 버킷의 mipmap 폴더에 있는 비트맵 이미지)가 사용된다.
