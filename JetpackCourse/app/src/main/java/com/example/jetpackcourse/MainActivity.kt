package com.example.jetpackcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcourse.ui.theme.JetpackCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//           Row(modifier = Modifier.background(Color.Green).fillMaxSize(),
//                   horizontalArrangement = Arrangement.SpaceAround,
//                   verticalAlignment = Alignment.CenterVertically
//             )
//            {
//               Text("Hello")
//                Text("kli")
//               Text("my")
//           }
//            Column(modifier = Modifier.background(Color.Green).
//                    fillMaxHeight(0.5f).
//                    width(200.dp)
//                .padding(top = 50.dp)
//            ) {
//                Text("Hello",modifier = Modifier.offset(50.dp,20.dp))
//                Text("loi")
//                Text("uio")
//            }

//            Column(modifier = Modifier
//                .background(Color.Green)
//                .fillMaxHeight(0.5f)
//                .fillMaxWidth()
//                .border(5.dp,Color.Black)
//                .padding(top = 50.dp)
//                .border(5.dp,Color.Red)
//                .padding(top = 20.dp)
//                .border(5.dp,Color.Black)
//            ) {
//                Text("Hello",modifier = Modifier.clickable {
//
//                })
//                Spacer(modifier = Modifier.height(50.dp))
//                Text("loi")
//                Text("uio")
//            }

            Column (modifier = Modifier
                .background(Color.Green)
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .border(5.dp, Color.Red)
                .padding(5.dp)
                .border(5.dp,Color.Gray)
                .padding(5.dp)
                .border(5.dp,Color.Green)
            ){
                Text("Hello")
                Spacer(modifier = Modifier.height(50.dp))
                Text("my selfi")
            }


        }
    }
}