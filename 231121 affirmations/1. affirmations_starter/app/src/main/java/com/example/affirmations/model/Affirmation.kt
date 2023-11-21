// 모델 패키지 : 데이터 클래스로 표시되는 데이터 모델이 포함된 패키지
// 패키지 : 클래스와 다른 디렉터리가 포함된 디렉터리

// 데이터 클래스 : 속성만 포함하는 클래스의 한 유형
// 여러 데이터가 포함된 목록 항목의 경우 데이터의 속성을 모두 포함하는 클래스가 필요하다.

// Affirmation 데이터 클래스 : 문자열 리소스와 이미지 리소스로 구성된 Affirmation과 관련된 정보를 나타내는 속성으로 구성할 것이다.

package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourceId: Int, // 문자열 리소스에 저장된 격언 텍스트의 ID
    @DrawableRes val imageResourceId: Int // 드로어블 리소스에 저장된 격언 이미지의 ID
)
