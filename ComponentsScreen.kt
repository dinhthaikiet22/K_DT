package com.example.jatpack

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign


@Composable
fun ComponentsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp) // Căn lề đều cho tiêu đề và ô
    ) {
        Text(
            text = "UI Components List",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp)) // Tăng khoảng cách giữa tiêu đề và phần tiếp theo

        Section(title = "Display") {
            ComponentItem("Text", "Displays text") { navController.navigate("text_detail") }
            ComponentItem("Image", "Displays an image") {}
        }

        Spacer(modifier = Modifier.height(20.dp)) // Thêm khoảng cách giữa các phần

        Section(title = "Input") {
            ComponentItem("TextField", "Input field for text") {}
            ComponentItem("PasswordField", "Input field for passwords") {}
        }

        Spacer(modifier = Modifier.height(20.dp))

        Section(title = "Layout") {
            ComponentItem("Column", "Arranges elements vertically") {}
            ComponentItem("Row", "Arranges elements horizontally") {}
        }
    }
}

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp) // Căn tiêu đề cùng lề với ô
        )
        Spacer(modifier = Modifier.height(8.dp)) // Tăng khoảng cách giữa tiêu đề và danh sách
        content()
    }
}

@Composable
fun ComponentItem(name: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 6.dp), // Đảm bảo căn lề đúng
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF81C3F8)),
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = description, fontSize = 14.sp)
        }
    }
}


