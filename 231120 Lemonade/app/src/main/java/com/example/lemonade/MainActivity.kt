package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() { // MainActivity : 애플리케이션의 주 화면 정의
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme { // 사용자 정의 테마 적용
                MakeLemonade() // 메인 컴포저블 함수 호출
            }
        }
    }
}

@Preview(showBackground = true) // 미리보기
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        MakeLemonade()
    }
}

@OptIn(ExperimentalMaterial3Api::class) // 실험적인 Material 3 API를 사용하기 위한 어노테이션
@Composable
fun MakeLemonade(modifier: Modifier = Modifier) {
    var lemonStep by remember { mutableStateOf(1) }
    var tapsNeeded by remember { mutableStateOf(0) }
    var currentTaps by remember { mutableStateOf(0) }

    val imageResource = when (lemonStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val imageInst = when (lemonStep) {
        1 -> R.string.inst1
        2 -> R.string.inst2
        3 -> R.string.inst3
        else -> R.string.inst4
    }
    val imagedesc = when (lemonStep) {
        1 -> R.string.desc1
        2 -> R.string.desc2
        3 -> R.string.desc3
        else -> R.string.desc4
    }

    Scaffold( // Material Design의 기본 레이아웃 구조를 제공하는 컴포저블. topBar, bottomBar, floatingActionButton 등을 포함할 수 있다.
        topBar = {
            CenterAlignedTopAppBar( // 앱 바 상단에 타이틀이 중앙에 정렬되어 있는 컴포저블
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Yellow,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding -> // 상단 바와 같은 구성요소들에 의해 콘텐츠가 가려지지 않도록 Scaffold가 적절한 패딩을 제공
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Scaffold의 내부 패딩 적용
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            Box ( // 자식들을 겹쳐서 배치할 수 있게 해주는 컨테이너
                modifier = modifier
            ) {
                Column (
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(
                        onClick = {
                            when (lemonStep) {
                                1 -> {
                                    tapsNeeded = (2..4).random()
                                    lemonStep++
                                }
                                2 -> {
                                    currentTaps++
                                    if (currentTaps == tapsNeeded) {
                                        lemonStep++
                                        currentTaps = 0
                                    }
                                }
                                3 -> {
                                    lemonStep++
                                }
                                else -> {
                                    lemonStep = 1
                                }
                            }
                        },
                        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2))
                    ) {
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = stringResource(id = imagedesc)
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
                    Text(
                        text = when {
                            lemonStep == 2 && currentTaps != 0 -> {
                                val tapsLeft = tapsNeeded - currentTaps
                                if (tapsLeft > 1) "Please tap $tapsLeft more times" else "Please tap 1 last time"
                            }
                            else -> stringResource(id = imageInst)
                        },
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

// 드로어블 참조 방법 : 'R.drawable.파일 이름' 리소스 ID를 사용하여 벡터 드로어블 파일 참조 가능
// MaterialTheme : Jetpack Compose에서 앱의 시각적 디자인을 일관되게 적용할 수 있게 해주는 데 사용되는 컴포저블