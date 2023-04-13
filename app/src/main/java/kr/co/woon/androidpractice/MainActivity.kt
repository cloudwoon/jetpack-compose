package kr.co.woon.androidpractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.woon.androidpractice.ui.theme.AndroidPracticeTheme


//컴포즈는 선언형
/*명령형과 선언형이 있음.
선언형 : 결과만 명시 -> 알고리즘이 필요 없음*//*
명령형 : 과정을 명시 -> 알고리즘을 작성해야 함*/
class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val field = remember { mutableStateOf("") }
            val fields = remember { mutableStateListOf<String>() }
            Column(
                modifier = Modifier.padding(30.dp),
            ) {
                Row {
                    TextField(
                        value = field.value,
                        onValueChange = { field.value = it },
                    )
                    Button(onClick = {
                        fields.add(field.value)
                        field.value = ""
                    }) {
                        Text(text = "TODO")
                    }
                }
                fields.forEach{
                    Row {
                        val check = remember { mutableStateOf(false) }
                        Text(text = it)
                        Checkbox(checked = check.value, onCheckedChange = {check.value = !check.value})

                    }

                }

            }

        }
    }
}


//composition
//recomposition - UI 변화가 생겼을 때 다시 유아이를 그려주는 것
//리컴포지션을 시키기 위해서는 state라는 것을 사용함.
//그래서 state 관리를 잘 해줘야 함.

