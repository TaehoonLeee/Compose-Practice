package com.example.composepractice.ui.market

import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composepractice.ui.gallery.GalleryViewModel
import com.example.composepractice.R

@Preview
@Composable
fun MarketScreen() {
    // Sharing ViewModel Means
    val testViewModel: GalleryViewModel = viewModel(LocalContext.current as ComponentActivity)
    Box(
        modifier = Modifier
            .background(Color(0xFFF7F6F2))
            .fillMaxSize()
    ) {
        Column {
            Header()
            Profile()
            TabBox()
            Spacer(modifier = Modifier.height(8.dp))
            Content()
        }
    }
}

@Composable
fun Header() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Market",
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .background(shape = CircleShape, color = Color.White)
                .padding(4.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "123", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 4.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.ic_baseline_adb_24), contentDescription = null
                )
            }
        }
    }
}

@Composable
fun Profile() {
    Box(modifier = Modifier.height(150.dp)) {

    }
}

@Composable
fun TabBox() {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFFF7F6F2)),
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = SpaceEvenly
            ) {
                Image(painter = painterResource(id = R.drawable.ic_baseline_adb_24), contentDescription = null)
                Text(
                    text = "구매내역",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Divider(modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 12.dp)
                .width(1.dp))
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = SpaceEvenly
            ) {
                Image(painter = painterResource(id = R.drawable.ic_baseline_adb_24), contentDescription = null)
                Text(
                    text = "찜한상품",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Divider(modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 12.dp)
                .width(1.dp))
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = SpaceEvenly
            ) {
                Image(painter = painterResource(id = R.drawable.ic_baseline_adb_24), contentDescription = null)
                Text(
                    text = "장바구니",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

    }
}