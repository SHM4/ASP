package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // 람다
            DiceRollerTheme { // 이런 게 람다
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()                      // fillMaxSize()를 Modifier 객체에 체이닝. 레이아웃이 전체 화면을 채우도록 함.
        .wrapContentSize(Alignment.Center)  // wrapContentSize() : 사용 가능한 공간이 최소한 내부에 있는 구성요소만큼 커야 한다고 지정
        // Alignment 객체 : 레이아웃 내부의 구성요소가 사용 가능한 공간보다 작을 경우, 사용 가능한 공간 내에서 구성요소를 정렬하는 방식을 지정
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) { // modifier : Modifier 타입의 매개변수
                                                            // 컴포저블에 Modifier 매개변수가 있으므로 컴포저블이 호출될 때 Modifier를 전달한다.
                                                            // 기본값으로 일반 Modifier 객체 설정할 수 있지만 비효율적이다.
                                                            // 왜냐하면 컴포저블이 재구성(컴포저블 메서드의 코드 블록이 재실행되는 것)을 거칠 수 있기 때문이다.
                                                            // Modifier 객체가 코드 블록에서 만들어지면 다시 만들어질 수 있다? -> 후반부에 더 다룰 예정
                                                            // 그렇기 때문에 DiceRollerApp()에서 Modifier 인수를 전달하는 것
    var result by remember { // remember : composable의 재구성 시 상태가 유지되도록 한다.
        mutableStateOf(1) // mutableStateOf : 관찰 가능한 상태를 생성하여 composable이 상태의 변경에 반응할 수 있도록 한다.
    }
    val imageResource = when (result) { // when : Java의 switch에 해당하는 표현식
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column ( // Column() 함수 : 하위 요소를 세로 순서로 배치하는 컴포저블 레이아웃
        modifier = modifier, // 상위 modifier 객체를 준수
        horizontalAlignment = Alignment.CenterHorizontally // 자식 요소들이 화면 중간에 위치하게 한다.
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(id = R.string.roll), fontSize = 24.sp)
        }
    }
}

// Modifier 클래스 : 컴포저블을 장식하거나 컴포저블에 동작을 추가한다.

