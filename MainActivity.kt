package com.example.baitap3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "screen1") {
                composable("screen1") { Screen1(navController) }
                composable("screen2") { Screen2(navController) }
                composable("screen3") { Screen3(navController) }
                composable("screen4") { Screen4(navController) }
            }
        }
    }
}

@Composable
fun Screen1(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.uth),
            contentDescription = "UTH Logo",
            modifier = Modifier.size(130.dp).clickable { navController.navigate("screen2") }
        )
        Text("UTH SmartTasks", fontSize = 35.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006EE9))
    }
}

@Composable
fun Screen2(navController: NavController) {
    OnboardingScreen(
        navController, R.drawable.image2, "Easy Time Management",
        "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first ",
        "Next", onNext = { navController.navigate("screen3") }, showBack = false, showSkip = true, selectedIndex = 0,
        imageSize = 400.dp, contentSpacing = 25.dp
    )
}

@Composable
fun Screen3(navController: NavController) {
    OnboardingScreen(
        navController, R.drawable.image3, "Increase Work Effectiveness",
        "Time management and the determination of more important tasks will give your job statistics better and always improve",
        "Next", onNext = { navController.navigate("screen4") }, showBack = true, showSkip = true, selectedIndex = 1,
        imageSize = 400.dp, contentSpacing = 25.dp
    )
}

@Composable
fun Screen4(navController: NavController) {
    OnboardingScreen(
        navController, R.drawable.image4, "Reminder Notification",
        "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
        "Get Started", onNext = { }, showBack = true, showSkip = true, selectedIndex = 2,
        imageSize = 400.dp, contentSpacing = 25.dp
    )
}

@Composable
fun OnboardingScreen(
    navController: NavController,
    imageRes: Int,
    title: String,
    description: String,
    buttonText: String,
    onNext: () -> Unit,
    showBack: Boolean,
    showSkip: Boolean,
    selectedIndex: Int,
    imageSize: Dp = 300.dp,
    contentSpacing: Dp = 20.dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top  // Để quản lý vị trí theo chiều dọc
    ) {
        // Thanh điều hướng (Dots + Skip)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DotsIndicator(selectedIndex)
            if (showSkip) {
                Text(
                    "Skip",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF006EE9),
                    modifier = Modifier.clickable {
                        navController.navigate("screen4")
                    }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f)) // Đẩy ảnh xuống giữa hơn

        // Ảnh minh họa
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(imageSize)
                .padding(top = contentSpacing)
        )

        // Tiêu đề và mô tả
        Column(
            modifier = Modifier.padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(contentSpacing))
            Text(
                description,
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.weight(0.7f)) // Giảm khoảng cách này để nội dung nằm giữa hơn

        // Nút điều hướng
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            horizontalArrangement = if (showBack) Arrangement.SpaceBetween else Arrangement.Center
        ) {
            if (showBack) {
                Image(
                    painter = painterResource(id = R.drawable.image5),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(60.dp)
                        .clickable { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.width(20.dp))
            }

            Button(
                onClick = onNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006EE9))
            ) {
                Text(buttonText, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

@Composable
fun DotsIndicator(selectedIndex: Int) {
    Row {
        repeat(3) { index ->
            Box(
                modifier = Modifier
                    .size(22.dp)
                    .padding(5.dp)
                    .background(
                        if (index == selectedIndex) Color.Blue else Color.LightGray,
                        CircleShape
                    )
            )
        }
    }
}