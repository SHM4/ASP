package com.example.a231121buildgrid.data

import com.example.a231121buildgrid.R
import com.example.a231121buildgrid.model.Topic

object DataSource {
    val topics = listOf(
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.crafts, 121, R.drawable.crafts),
        Topic(R.string.business, 78, R.drawable.business),
        Topic(R.string.culinary, 118, R.drawable.culinary),
        Topic(R.string.design, 423, R.drawable.design),
        Topic(R.string.fashion, 92, R.drawable.fashion),
        Topic(R.string.film, 165, R.drawable.film),
        Topic(R.string.gaming, 164, R.drawable.gaming),
        Topic(R.string.drawing, 326, R.drawable.drawing),
        Topic(R.string.lifestyle, 305, R.drawable.lifestyle),
        Topic(R.string.music, 212, R.drawable.music),
        Topic(R.string.painting, 172, R.drawable.painting),
        Topic(R.string.photography, 321, R.drawable.photography),
        Topic(R.string.tech, 118, R.drawable.tech)
    )
}

// 싱글톤 방식 : 프로그램 전체에서 공동된 하나의 인스턴스만을 사용 -> 메모리 사용 최소화. 전역적 접근 가능.
// affirmations의 DataSource처럼 클래스를 사용하면, 여러 인스턴스를 생성하고 각 인스턴스는 자신만의 상태를 유지할 수 있으므로 유연성이 높으며, 여러 개의 독립적인 DataSource가 필요한 경우에 유용하다.
// 지금의 방식에서는 반환값이 고정되어 있으므로 항상 동일한 결과를 얻게 되므로 클래스 방식보다는 싱글톤 방식이 더 효율적이다.