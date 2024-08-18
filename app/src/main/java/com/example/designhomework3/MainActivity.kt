package com.example.designhomework3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designhomework3.ui.theme.DesignHomework3Theme
import com.example.designhomework3.ui.theme.MainColor
import com.example.designhomework3.ui.theme.SecondaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignHomework3Theme {
                Home()
                }
            }
        }
    }

public val Flame: ImageVector
    get() {
        if (_Flame != null) {
            return _Flame!!
        }
        _Flame = ImageVector.Builder(
            name = "Flame",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(8.5f, 14.5f)
                arcTo(2.5f, 2.5f, 0f, false, false, 11f, 12f)
                curveToRelative(0f, -1.38f, -0.5f, -2f, -1f, -3f)
                curveToRelative(-1.072f, -2.143f, -0.224f, -4.054f, 2f, -6f)
                curveToRelative(0.5f, 2.5f, 2f, 4.9f, 4f, 6.5f)
                curveToRelative(2f, 1.6f, 3f, 3.5f, 3f, 5.5f)
                arcToRelative(7f, 7f, 0f, true, true, -14f, 0f)
                curveToRelative(0f, -1.153f, 0.433f, -2.294f, 1f, -3f)
                arcToRelative(2.5f, 2.5f, 0f, false, false, 2.5f, 2.5f)
                close()
            }
        }.build()
        return _Flame!!
    }

private var _Flame: ImageVector? = null




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Finder") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MainColor,
                    titleContentColor = SecondaryColor,
                ),
                navigationIcon = {
                    Icon(
                        imageVector = Flame,
                        contentDescription = "Logo",
                        tint = SecondaryColor
                    )
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween, // Changed to SpaceBetween
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Changed to fillMaxWidth
                    .weight(1f) // Allows the Box to take available space proportionally
            ) {
                // Image carousel as the background
                ImageCarousel(
                    images = listOf(
                        painterResource(id = R.drawable.ahmoz_resim1),
                        painterResource(id = R.drawable.ahmoz_resim2),
                        painterResource(id = R.drawable.ahmoz_resim3)
                    ),
                )

                // Text positioned at the top-left
                Text(
                    text = "Ozan 22",
                    color = Color.White,
                    fontSize = 36.sp,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(36.dp) // Adjust padding as needed
                )
            }

            // Space between the Box and Row
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp), // Added padding for horizontal alignment
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow, contentColor = Color.Black)) {
                    Text(text = "Undo")
                }
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)) {
                    Text(text = "Dislike")
                }
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)) {
                    Text(text = "Super Like")
                }
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Green, contentColor = Color.White)) {
                    Text(text = "Like")
                }
            }
        }
    }
}

@Composable
fun ImageCarousel(images: List<Painter>) {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        items(images) { image ->
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(400.dp)
            )
        }
    }
}