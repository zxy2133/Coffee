package com.example.coffee.presentation.screens.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.presentation.navigation.Routes
import com.example.coffee.presentation.ui.theme.LightBrown


@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.welcome_coffee),
            contentDescription = "Coffee Welcome"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 70.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "沉醉于美妙的咖啡之中！",
                fontSize = 28.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "欢迎来到温馨的咖啡角，每一杯都是为您精心调制的口味！",
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(48.dp))
            Button(
                onClick = {
                    navController.navigate(Routes.HomeScreen) {
                        // 清栈：进入首页后移除欢迎页，按返回键不会回到欢迎页
                        popUpTo(Routes.WelcomeScreen) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = Color.White
                )
            ) {
                Text(text = "开始使用", fontSize = 18.sp)
            }
        }
    }
}