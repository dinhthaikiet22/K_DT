package com.example.jatpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextDetailScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Text Detail",
                            fontSize = 25.sp,
                            color = Color(0xFF2196F3),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 70.dp), // Dịch sang trái một chút
                            textAlign = TextAlign.Start
                        )
                    }
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.back), // Ảnh nút quay lại
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(55.dp) // Kích thước ảnh
                            .padding(start = 16.dp)
                            .clickable { onBackClick() }
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.White // Giữ màu nền đồng nhất
                )
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(Color.White), // Đảm bảo nền trắng toàn màn hình
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.text),
                contentDescription = "Formatted Text",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(width = 354.dp, height = 240.dp)
                    .absoluteOffset(x = 50.dp, y = 250.dp)
            )
        }
    }
}

